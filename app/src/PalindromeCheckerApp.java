// File: UseCase9PalindromeCheckerApp.java

public class PalindromeCheckerApp {

    // Recursive function to check palindrome
    static boolean isPalindrome(String str, int start, int end) {
        // Base condition: if start >= end, it's a palindrome
        if (start >= end) {
            return true;
        }

        // If mismatch found, return false
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call: move inward
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String input = "madam"; // You can change this string for testing

        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }
    }
}