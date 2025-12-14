// ArrayQueueDriver.java
// Starter file for the Queue portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runQ2_CallCenterQueue).

public class ArrayQueueDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        //runQ1_PrintQueue();
        //runQ2_CallCenterQueue();
        //runQ3_ThemeParkRideLine();
        //runQ4_CustomerServiceTickets();
        //runQ5_TaskSchedulingQueue();
        //runQ6_CheckoutLine();
        //runQ7_MessageQueueChatApp();
        //runQ8_PrintSpoolingBurst();
        //runQ9_RoundRobinService();
    }

    // Q1 – Print Queue
    private static void runQ1_PrintQueue() {
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

    // Q2 – Call Center Queue
    private static void runQ2_CallCenterQueue() {
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

    // Q3 – Theme Park Ride Line
    private static void runQ3_ThemeParkRideLine() {
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

    // Q4 – Customer Service Tickets
    private static void runQ4_CustomerServiceTickets() {
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

    // Q5 – Task Scheduling Queue
    private static void runQ5_TaskSchedulingQueue() {
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

    // Q6 – Checkout Line at a Store
    private static void runQ6_CheckoutLine() {
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

    // Q7 – Message Queue in a Chat App
    private static void runQ7_MessageQueueChatApp() {
        String word = "racecar";
        ListStack<Character> stack = new ListStack<>();

        for (char c : word.toCharArray()) stack.push(c);

        String reversed = "";
        while (!stack.isEmpty()) reversed += stack.pop();

        System.out.println(word + " is palindrome? " + word.equals(reversed));
    }

    // Q8 – Print Spooling with Burst of Jobs
    private static void runQ8_PrintSpoolingBurst() {
        ListStack<String> calls = new ListStack<>();

        calls.push("main()");
        calls.push("functionA()");
        calls.push("functionB()");

        System.out.println("Current call: " + calls.peek());

        // Returning from functionB
        calls.pop();
        System.out.println("After return, now in: " + calls.peek());
    }

    // Q9 – Round-Robin Service (Single Queue Version)
    private static void runQ9_RoundRobinService() {
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
