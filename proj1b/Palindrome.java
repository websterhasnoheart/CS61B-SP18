public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        Deque deque = wordToDeque(word);
        return isPalindromHelper(deque);
    }

    private boolean isPalindromHelper(Deque deque) {
        if (deque.size() <= 1) {
            return true;
        } else if (deque.removeFirst() != deque.removeLast()) {
            return false;
        } else {
            return isPalindromHelper(deque);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque deque = wordToDeque(word);
        return isPalindromeHelper(deque, cc);
    }

    private boolean isPalindromeHelper(Deque deque, CharacterComparator cc) {
        if (deque.size() <= 1) {
            return true;
        } else if (!cc.equalChars((char) deque.removeFirst(), (char) deque.removeLast())) {
            return false;
        } else {
            return isPalindromeHelper(deque, cc);
        }
    }
}
