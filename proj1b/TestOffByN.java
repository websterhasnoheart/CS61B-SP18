import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN;

    @Test
    public void testOffByN() {
        offByN = new OffByN(4);
        assertTrue(offByN.equalChars('a', 'e'));
        assertTrue(offByN.equalChars('e', 'i'));
    }

}
