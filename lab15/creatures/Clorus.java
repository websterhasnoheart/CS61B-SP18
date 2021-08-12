package creatures;
import huglife.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class Clorus extends Creature {
    private int r;
    private int b;
    private int g;
    private static final double MOVEENERGYLOSS = 0.03;
    private static final double STAYENERGYLOSS = 0.01;

    /**
     * Creates a creature with the name N. The intention is that this
     * name should be shared between all creatures of the same type.
     */
    public Clorus(Double e) {
        super("clorus");
        r = 0;
        b = 0;
        g = 0;
        energy = e;
    }

    public Clorus() {
        this(1.0);
    }

    @Override
    public void move() {
        energy -= MOVEENERGYLOSS;
    }

    @Override
    public void attack(Creature c) {
        energy += c.energy();
    }

    @Override
    public Clorus replicate() {
        Clorus offSpring = new Clorus(0.5 * energy);
        this.energy = this.energy * 0.5;
        return offSpring;
    }

    @Override
    public void stay() {
        energy -= STAYENERGYLOSS;
    }


    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        List<Direction> plips = getNeighborsOfType(neighbors, "plip");
        if (!empties.isEmpty()) {
            return new Action(Action.ActionType.STAY);
        } else if (!plips.isEmpty()) {
            Direction moveDir = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.ATTACK, moveDir);
        } else if (energy >= 1) {
            Direction moveDir = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.REPLICATE, moveDir);
        } else {
            Direction moveDir = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.MOVE, moveDir);
        }
    }

    @Override
    public Color color() {
        return color(34, 0, 231);
    }
}
