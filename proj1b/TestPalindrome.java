import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindorme() {
        assertTrue(palindrome.isPalindrome("bab"));
        assertTrue(palindrome.isPalindrome("asdsa"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("cat"));
    }

    @Test
    public void testPalindorme() {
        OffByOne offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake",offByOne));
        assertFalse(palindrome.isPalindrome("whatthefuck",offByOne));
        assertTrue(palindrome.isPalindrome("&%",offByOne));
    }
}
