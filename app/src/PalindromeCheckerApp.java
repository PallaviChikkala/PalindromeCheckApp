// File: UseCase10PalindromeCheckerApp.java

public class PalindromeCheckerApp {

    // Method to normalize string: remove spaces and convert to lowercase
    static String normalize(String str) {
        // Remove all spaces using regex and convert to lowercase
        return str.replaceAll("\\s+", "").toLowerCase();
    }

    // Method to check palindrome
    static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "A man a plan a canal Panama"; // You can change this string for testing

        // Normalize input
        String normalized = normalize(input);

        // Check palindrome
        if (isPalindrome(normalized)) {
            System.out.println("The string \"" + input + "\" is a palindrome (ignoring case and spaces).");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome (ignoring case and spaces).");
        }
    }
}