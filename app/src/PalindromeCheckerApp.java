import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main() {
        // File: UseCase5PalindromeCheckerApp.java

                String word = "madam";

                // Create a stack of characters
                Stack<Character> stack = new Stack<>();

                // Push each character into the stack
                for (int i = 0; i < word.length(); i++) {
                    stack.push(word.charAt(i));
                }

                // Pop characters to build the reversed string
                String reversed = "";
                while (!stack.isEmpty()) {
                    reversed = reversed + stack.pop();
                }

                // Compare original and reversed using equals()
                if (word.equals(reversed)) {
                    System.out.println(word + " is a palindrome.");
                } else {
                    System.out.println(word + " is not a palindrome.");
                }
            }
        }