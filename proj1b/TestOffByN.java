import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static OffByN offByN;

    @Test
    public void testOffByN() {
        offByN = new OffByN(4);
        assertTrue(offByN.equalChars('a','e'));
        assertTrue(offByN.equalChars('e','i'));
        assertTrue(offByN.equalChars('g','s'));
    }
}
