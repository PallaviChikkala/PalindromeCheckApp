// File: UseCase13PalindromeCheckerApp.java

import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    // Approach 1: Simple two-pointer check
    static boolean twoPointerCheck(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Approach 2: Stack-based check
    static boolean stackCheck(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Approach 3: Deque-based check
    static boolean dequeCheck(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : normalized.toCharArray()) {
            deque.add(ch);
        }

        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "A man a plan a canal Panama"; // Change for testing

        // Measure performance of each approach
        long start, end;

        start = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        end = System.nanoTime();
        long timeTwoPointer = end - start;

        start = System.nanoTime();
        boolean result2 = stackCheck(input);
        end = System.nanoTime();
        long timeStack = end - start;

        start = System.nanoTime();
        boolean result3 = dequeCheck(input);
        end = System.nanoTime();
        long timeDeque = end - start;

        // Display results
        System.out.println("Input: \"" + input + "\"\n");
        System.out.println("Two-Pointer Check: " + result1 + " | Time: " + timeTwoPointer + " ns");
        System.out.println("Stack Check:       " + result2 + " | Time: " + timeStack + " ns");
        System.out.println("Deque Check:       " + result3 + " | Time: " + timeDeque + " ns");
    }
}