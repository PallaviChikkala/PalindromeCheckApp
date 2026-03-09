// File: UseCase8PalindromeCheckerApp.java

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Convert string to linked list
    void convertStringToList(String str) {
        for (char ch : str.toCharArray()) {
            append(ch);
        }
    }

    // Append node at the end
    void append(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Check if linked list is palindrome
    boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle using fast & slow pointer
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverse(slow);

        // Step 3: Compare halves
        Node firstHalf = head;
        Node tempSecond = secondHalf;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }
        return true;
    }

    // Reverse linked list in place
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "madam"; // Change this string for testing
        LinkedList list = new LinkedList();
        list.convertStringToList(input);

        if (list.isPalindrome()) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }
    }
}