import org.junit.Test;
import static org.junit.Assert.*;

public class FilkTest {
    @Test
    public void testFilk() {
        Integer A = 120;
        Integer B = 120;

        assertTrue(Flik.isSameNumber(A,B));
    }
}
