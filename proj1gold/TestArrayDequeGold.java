import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class TestArrayDequeGold {

    @Test
    public void testArrayDeque() {
        StudentArrayDeque<Integer> wdeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> rdeque = new ArrayDequeSolution<>();

        /* addLast() test */
        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(100);
            wdeque.addLast(random);
            rdeque.addLast(random);
        }

        for (int i = 0; i < 10; i++) {
            Integer actual = wdeque.get(i);
            Integer expected = rdeque.get(i);
            assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }

        /* addFirst() test */
        for (int i = 0; i < 10; i++) {
            Integer random = StdRandom.uniform(100);
            wdeque.addFirst(random);
            rdeque.addFirst(random);
        }

        for (int i = 0; i < 10; i++) {
            Integer actual = wdeque.get(i);
            Integer expected = rdeque.get(i);
            assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }

        /* removeFirst() test */
        ArrayList<Integer> actualList = new ArrayList<>();
        ArrayList<Integer> expectedList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            actualList.add(wdeque.removeFirst());
            expectedList.add(rdeque.removeFirst());
        }
        for (int i = 0; i < 10; i++) {
            Integer actual = wdeque.get(i);
            Integer expected = rdeque.get(i);
            assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }
        for (int i = 0; i < 10; i++) {
            Integer actual = actualList.get(i);
            Integer expected = expectedList.get(i);
            assertEquals("Oh noooo!\nThis is a bad removeFirst():\n   Random number " + actual
                            + " not equal to " + expected + "!",
                    expected, actual);
        }

        /* removeLast() test */
        actualList.clear();
        expectedList.clear();
        for (int i = 0; i < 10; i++) {
            actualList.add(wdeque.removeLast());
            expectedList.add(rdeque.removeLast());
        }

        Integer actual = wdeque.size();
        Integer expected = rdeque.size();
        assertEquals("Oh noooo!\nThis is a bad:\n   actual size " + actual
                        + " not equal to " + expected + "size !",
                expected, actual);
        for (int i = 0; i < 10; i++) {
            assertEquals("Oh noooo!\nThis is a bad removeLast():\n   Random number " + actualList.get(i)
                    + " not equal to " +  expectedList.get(i) + "!",
                    expectedList.get(i), actualList.get(i));
        }
    }

    @Test
    public void testArrayDeque2() {
        StudentArrayDeque<Integer> wdeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> rdeque = new ArrayDequeSolution<>();

        Integer random = StdRandom.uniform(100);
        wdeque.addFirst(random);
        rdeque.addFirst(random);
        assertEquals("addFirst(" + random + ")", wdeque.get(0), rdeque.get(0));
        System.out.println("addFirst(" + random + ")");

        wdeque.addLast(random);
        rdeque.addLast(random);
        assertEquals("addFirst(" + random + ")", wdeque.get(0), rdeque.get(0));
        System.out.println("addFirst(" + random + ")");

        Integer actual = wdeque.removeFirst();
        Integer expected = rdeque.removeFirst();
        assertEquals("removeFirst()", actual, expected);
        System.out.println("removeFirst()");

        actual = wdeque.removeLast();
        expected = rdeque.removeLast();
        assertEquals("removeLast()", actual, expected);
        System.out.println("removeLast()" );
    }

}
