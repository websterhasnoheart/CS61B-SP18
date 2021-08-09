package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    private int first;
    private int last;
    private T[] rb;

    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }


    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last++] =  x;
        if (last == capacity) {
            last = 0;  // circular structure, remember?
        }
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        T removedItem = rb[first++];
        if (first == capacity) {
            first = 0;
        }
        fillCount--;
        return removedItem;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int pos;
        private int num;

        MyIterator() {
            pos = first;
            num = 0;
        }

        @Override
        public boolean hasNext() {
            return (num < fillCount);
        }

        @Override
        public T next() {
            T returnItem = rb[pos++];
            if (pos == capacity) {
                pos = 0;
            }
            num++;
            return returnItem;
        }
    }
}
