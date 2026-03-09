public class PalindromeCheckerApp {
    public static void main() {
        // Hardcoded string literal
        String word = "madam";

        // Reverse the string using a loop
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i); // String concatenation
        }

        // Compare original and reversed using equals()
        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}