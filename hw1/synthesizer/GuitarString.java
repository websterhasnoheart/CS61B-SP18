package synthesizer;

public class GuitarString {
    private static final int SR = 44100; //sampling rate
    private static final Double DECAY = .996; //energy decay factor

    /* create a buffer for storing sound data */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        buffer = new ArrayRingBuffer<>((int) Math.round(SR / frequency));
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.enqueue(0.0);
        }
    }

    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // every ranromNum should be different from each other
        for (int i = 0; i < buffer.capacity(); i++) {
            double randomNum = Math.random() - 0.5;
            buffer.dequeue();
            buffer.enqueue(randomNum);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double frontSample = buffer.dequeue();
        buffer.enqueue(DECAY * 0.5 * (frontSample + sample()));
    }

    /* get the first item on the current buffer */
    public double sample() {
        return buffer.peek();
    }
}
