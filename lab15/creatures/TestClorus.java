package creatures;
import huglife.*;
import org.junit.Test;

import java.awt.*;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TestClorus {

    @Test
    public void testBasics() {
        Clorus r = new Clorus(2.0);
        assertEquals(2, r.energy(), 0.01);
        assertEquals(new Color(34, 0, 231), r.color());
        r.move();
        assertEquals(1.97, r.energy(), 0.02);
        r.move();
        assertEquals(1.94, r.energy(), 0.02);
        r.stay();
        assertEquals(1.93, r.energy(), 0.01);
        r.stay();
        assertEquals(1.92, r.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Clorus r = new Clorus(2.0);
        Clorus offSpring = r.replicate();
        assertNotEquals(offSpring, r);
        assertEquals(1.0, r.energy(), 0.01);
        assertEquals(1.0, offSpring.energy(), 0.01);
    }

    @Test
    public void testChooseAction() {
        Clorus p = new Clorus(2.0);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Plip());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = p.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);

        p = new Clorus(2.0);
        surrounded = new HashMap<>();
        surrounded.put(Direction.TOP, new Plip());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Empty());
        actual = p.chooseAction(surrounded);
        expected = new Action(Action.ActionType.ATTACK, Direction.TOP);

        assertEquals(expected, actual);

        p = new Clorus(1.0);
        surrounded = new HashMap<>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Empty());
        actual = p.chooseAction(surrounded);
        expected = new Action(Action.ActionType.REPLICATE, Direction.RIGHT);

        assertEquals(expected, actual);

        p = new Clorus(0.5);
        surrounded = new HashMap<>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Empty());
        actual = p.chooseAction(surrounded);
        expected = new Action(Action.ActionType.MOVE, Direction.RIGHT);

        assertEquals(expected, actual);

    }
}
