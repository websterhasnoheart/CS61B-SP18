package synthesizer;
import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T> {
    int capacity();  // return the size of the buffer
    int fillCount(); //return the number of items currently in the buffer
    void enqueue(T x); //add item x to the end of the queue
    T dequeue(); //delete and return item from the front
    T peek(); //return but not to delete item from the front

    default boolean isEmpty() {
        return fillCount() == 0;
    }

    default boolean isFull() {
        return fillCount() == capacity();
    }
}
