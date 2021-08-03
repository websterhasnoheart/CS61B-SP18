import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testArrayDeque() {
        ArrayDequeSolution<Integer> rdeque = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> wdeque = new StudentArrayDeque<>();
        /* Store message in a StringBuilder() */
        StringBuilder msg = new StringBuilder();
        int size = 0;

        for (int i = 0; i < 1000; i++) {
            if (i % 5 == 0) {
                msg.append("size()\n");
                assertEquals(msg.toString(), rdeque.size(), wdeque.size());
            }
            double random = StdRandom.uniform();
            if (random < 0.25) {
                rdeque.addFirst(i);
                wdeque.addFirst(i);
                size++;
                msg.append("addFirst(" + i + ")\n");
                assertEquals(msg.toString(),rdeque.get(0),wdeque.get(0));
            } else if (random < 0.5 ) {
                rdeque.addLast(i);
                wdeque.addLast(i);
                size++;
                msg.append("addLast(" + i + ")\n");
                assertEquals(msg.toString(), rdeque.get(size-1), wdeque.get(size-1));
            } else if (random < 0.75) {
                if (rdeque.isEmpty()) {
                    msg.append("isEmpty()\n");
                    assertTrue(msg.toString(), wdeque.isEmpty());
                    continue;
                }
                Integer right = rdeque.removeFirst();
                Integer wrong = wdeque.removeFirst();
                size--;
                msg.append("removeFirst()\n");
                assertEquals(msg.toString(),right, wrong);
            } else {
                if (rdeque.isEmpty()) {
                    msg.append("isEmpty()");
                    assertTrue(msg.toString(), wdeque.isEmpty());
                    continue;
                }
                Integer right = rdeque.removeLast();
                Integer wrong = wdeque.removeLast();
                size--;
                msg.append("removeLast()\n");
                assertEquals(msg.toString(), right, wrong);
            }
        }
    }
}