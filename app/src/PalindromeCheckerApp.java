import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class PalindromeCheckerApp {
    public static void main() {
                String word = "madam";

                // Create a queue and a stack
                Queue<Character> queue = new LinkedList<>();
                Stack<Character> stack = new Stack<>();

                // Enqueue and push each character
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    queue.add(ch);   // enqueue
                    stack.push(ch);  // push
                }

                boolean isPalindrome = true;

                // Compare dequeue vs pop
                while (!queue.isEmpty() && !stack.isEmpty()) {
                    char fromQueue = queue.remove(); // dequeue
                    char fromStack = stack.pop();    // pop

                    if (fromQueue != fromStack) {
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