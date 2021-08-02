/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int n = 3;
        OffByN offBy3 = new OffByN(n);

        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }

        // FUN PARTⅠ
        while(!in.isEmpty()) {
            char word = in.readChar();
            if(offBy3.equalChars('c',word)) {
                System.out.println(word);
            }
        }
    }
}
