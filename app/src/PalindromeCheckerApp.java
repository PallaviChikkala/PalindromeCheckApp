// File: UseCase11PalindromeCheckerApp.java

// PalindromeChecker class encapsulates the palindrome logic
class PalindromeChecker {

    // Public method to expose palindrome checking
    public boolean checkPalindrome(String input) {
        // Normalize input: remove spaces and convert to lowercase
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
}

public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "RaceCar"; // You can change this string for testing

        // Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker();

        // Call the encapsulated method
        if (checker.checkPalindrome(input)) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }
    }
}