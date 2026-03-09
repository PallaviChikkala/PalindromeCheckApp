// File: UseCase12PalindromeCheckerApp.java

import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

// Step 1: Define the Strategy interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Step 2: Implement Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        // Push all characters onto stack
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        // Compare by popping
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Step 3: Implement Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        // Add all characters to deque
        for (char ch : normalized.toCharArray()) {
            deque.add(ch);
        }

        // Compare front and back
        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }
}

// Step 4: Context class that uses a strategy
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public PalindromeCheckerContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCheck(String input) {
        return strategy.checkPalindrome(input);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "A man a plan a canal Panama"; // Change for testing

        // Choose strategy dynamically
        PalindromeCheckerContext context;

        // Example: Use StackStrategy
        context = new PalindromeCheckerContext(new StackStrategy());
        System.out.println("Using StackStrategy:");
        System.out.println("Is \"" + input + "\" a palindrome? " + context.executeCheck(input));

        // Example: Use DequeStrategy
        context = new PalindromeCheckerContext(new DequeStrategy());
        System.out.println("\nUsing DequeStrategy:");
        System.out.println("Is \"" + input + "\" a palindrome? " + context.executeCheck(input));
    }
}