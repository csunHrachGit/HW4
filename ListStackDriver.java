// ListStackDriver.java
// Starter file for the Stack portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runS4_ReverseWord).

public class ListStackDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        //runS1_BrowserBackButton();
        //runS2_TextEditorUndo();
        //runS3_BalancedParentheses();
        //runS4_ReverseWord();
        //runS5_DirectoryNavigation();
        //runS6_CalculatorHistory();
        //runS7_PalindromeChecker();
        //runS8_FunctionCallStack();
        //runS9_StackOfPlates();
    }

    // S1 – Browser Back Button
    private static void runS1_BrowserBackButton() {
        ListStack<String> history = new ListStack<>();

        // Visiting pages
        history.push("google.com");
        history.push("github.com");
        history.push("stackoverflow.com");

        System.out.println("Current page: " + history.peek());

        // Go back
        System.out.println("Back...");
        history.pop();

        System.out.println("Now at: " + history.peek());
        System.out.println("Full history: " + history);
    }

    // S2 – Undo in a Text Editor
    private static void runS2_TextEditorUndo() {
        ListStack<String> undo = new ListStack<>();

        String text = "";
        undo.push(text);

        // User types something
        text = "Hello";
        undo.push(text);

        text = "Hello world";
        undo.push(text);

        System.out.println("Current text: " + text);

        // Undo last change
        undo.pop();
        text = undo.peek();

        System.out.println("After undo: " + text);
    }

    // S3 – Checking Balanced Parentheses
    private static void runS3_BalancedParentheses() {
        String expr = "(a + b) * (c + (d - e))";
        ListStack<Character> stack = new ListStack<>();

        boolean balanced = true;

        for (char ch : expr.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                if (stack.isEmpty()) {
                    balanced = false;
                    break;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) balanced = false;

        System.out.println(expr + " is balanced? " + balanced);
    }

    // S4 – Reversing a Word Using a Stack
    private static void runS4_ReverseWord() {
        String word = "hello";
        ListStack<Character> stack = new ListStack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        System.out.println("Original: " + word);
        System.out.println("Reversed: " + reversed);
    }

    // S5 – Directory Navigation (cd / cd ..)
    private static void runS5_DirectoryNavigation() {
        ListStack<String> path = new ListStack<>();

        // cd folder
        path.push("home");
        path.push("user");
        path.push("documents");

        System.out.println("Current path: " + path);

        // cd ..
        System.out.println("cd ..");
        path.pop();

        System.out.println("Now in: " + path);
    }

    // S6 – History of Calculator Operations
    private static void runS6_CalculatorHistory() {
        ListStack<String> history = new ListStack<>();

        // Recording operations
        history.push("5 + 3 = 8");
        history.push("8 * 2 = 16");
        history.push("16 - 4 = 12");

        System.out.println("Latest operation: " + history.peek());

        // Undo last operation
        System.out.println("Undoing...");
        history.pop();

        System.out.println("Now latest: " + history.peek());
    }

    // S7 – Palindrome Checker
    private static void runS7_PalindromeChecker() {
        String word = "racecar";
        ListStack<Character> stack = new ListStack<>();

        for (char c : word.toCharArray()) stack.push(c);

        String reversed = "";
        while (!stack.isEmpty()) reversed += stack.pop();

        System.out.println(word + " is palindrome? " + word.equals(reversed));
    }

    // S8 – Function Call Stack Simulator
    private static void runS8_FunctionCallStack() {
        ListStack<String> calls = new ListStack<>();

        calls.push("main()");
        calls.push("functionA()");
        calls.push("functionB()");

        System.out.println("Current call: " + calls.peek());

        // Returning from functionB
        calls.pop();
        System.out.println("After return, now in: " + calls.peek());
    }

    // S9 – Stack of Plates (Capacity-Limited Stack)
    private static void runS9_StackOfPlates() {
        int capacity = 3;
        ListStack<String> plates = new ListStack<>();

        for (int i = 1; i <= 4; i++) {
            if (plates.size() == capacity) {
                System.out.println("Cannot push plate " + i + ": stack is full.");
            } else {
                plates.push("Plate " + i);
                System.out.println("Pushed Plate " + i);
            }
        }

        System.out.println("Final stack: " + plates);
    }
}
