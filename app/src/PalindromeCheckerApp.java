import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class PalindromeCheckerApp {
    public static void main() {
        String word = "madam";

        // Create a deque and insert characters
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            deque.add(word.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear until deque is empty or mismatch found
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}