// CSLinkedListDriver.java
// Starter file for the Linked List portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runLL3_CourseWaitlist).

import java.util.Comparator;

public class CSLinkedListDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        //runLL1_Playlist();
        //runLL2_TodoList();
        //runLL3_CourseWaitlist();
        //runLL4_TextEditorLines();
        //runLL5_RecentlyContacted();
        //runLL6_ShoppingListAddAfter();
        //runLL7_BusRouteStops();
        //runLL8_EventScheduleSorted();
        //runLL9_BugTrackerRemoveById();
        //runLL10_PlaylistShuffleCopy();
    }

    // LL1 – Music Playlist Manager
    private static void runLL1_Playlist() {
        CSLinkedList<String> playlist = new CSLinkedList<>();

        // 2. Add several songs to the end of the list
        playlist.add("Yesterday");
        playlist.add("Bohemian Rhapsody");
        playlist.add("Hotel California");

        System.out.println("After adding songs: " + playlist);

        // 3. Insert a song at index 0 (top of playlist)
        playlist.add(0, "Imagine");
        System.out.println("After inserting at top: " + playlist);

        // 4. Remove a song from the middle
        playlist.remove(2); // removes "Bohemian Rhapsody" if using the list above
        System.out.println("After removing middle song: " + playlist);
    }

    // LL2 – To-Do List with Priorities
    private static void runLL2_TodoList() {
        CSLinkedList<String> todo = new CSLinkedList<>();

        // Regular tasks at the end
        todo.add("Finish CS homework");
        todo.add("Do laundry");
        todo.add("Go grocery shopping");
        System.out.println("Initial to-do list: " + todo);

        // Urgent tasks at index 0
        todo.add(0, "Pay rent (URGENT)");
        System.out.println("After adding urgent task: " + todo);

        todo.add(0, "Email professor (URGENT)");
        System.out.println("After adding another urgent task: " + todo);

        // Remove a completed task by index (here index 2, somewhere in the middle)
        String completed = todo.remove(2);
        System.out.println("After completing \"" + completed + "\": " + todo);
    }

    // LL3 – Course Waitlist (No Duplicates)
    private static void runLL3_CourseWaitlist() {
        CSLinkedList<String> waitlist = new CSLinkedList<>();

        String[] names = {
                "Alice", "Bob", "Charlie", "Alice",
                "Diana", "Bob", "Eve"
        };

        for (String name : names) {
            boolean added = waitlist.addIfAbsent(name);
            System.out.println("Trying to add " + name + " -> "
                    + (added ? "added" : "duplicate, ignored"));
        }

        System.out.println("Final waitlist: " + waitlist);
    }

    // LL4 – Text Editor Line Manager
    private static void runLL4_TextEditorLines() {
        // TODO: Implement task LL4 here.
    }

    // LL5 – Recently Contacted Friends (Move to Front)
    private static void runLL5_RecentlyContacted() {
        CSLinkedList<String> contacts = new CSLinkedList<>();

        contacts.add("Alice");
        contacts.add("Bob");
        contacts.add("Charlie");
        contacts.add("Diana");

        System.out.println("Initial recently contacted: " + contacts);

        contacts.moveToFront("Charlie");
        System.out.println("After messaging Charlie: " + contacts);

        contacts.moveToFront("Bob");
        System.out.println("After messaging Bob: " + contacts);

        contacts.moveToFront("Alice");
        System.out.println("After messaging Alice: " + contacts);
    }

    // LL6 – Shopping List: Insert After Item
    private static void runLL6_ShoppingListAddAfter() {
        CSLinkedList<String> shopping = new CSLinkedList<>();

        shopping.add("Milk");
        shopping.add("Coffee");
        shopping.add("Bread");

        System.out.println("Original shopping list: " + shopping);

        boolean ok = shopping.addAfter("Coffee", "Sugar");
        System.out.println("After adding Sugar after Coffee (success=" + ok + "): " + shopping);

        ok = shopping.addAfter("Tea", "Honey"); // target not in list
        System.out.println("Trying to add Honey after Tea (success=" + ok + "): " + shopping);
    }

    // LL7 – Bus Route Stops
    private static void runLL7_BusRouteStops() {
        CSLinkedList<String> route = new CSLinkedList<>();

        route.add("Depot");
        route.add("Downtown");
        route.add("Library");
        route.add("Stadium");

        System.out.println("Original route: " + route);

        // Add a new stop in the middle
        route.add(2, "Museum");
        System.out.println("After adding Museum stop: " + route);

        // Remove a closed stop (for example, Library)
        String closed = route.remove(3);
        System.out.println("After removing closed stop \"" + closed + "\": " + route);
    }

    // LL8 – Event Schedule (Insert by Time)
    private static void runLL8_EventScheduleSorted() {
        CSLinkedList<String> schedule = new CSLinkedList<>();

        Comparator<String> byTime = (a, b) -> a.compareTo(b); // "09:00 ..." sorts lexicographically

        schedule.addInOrder("13:00 Lunch", byTime);
        schedule.addInOrder("09:00 Breakfast", byTime);
        schedule.addInOrder("18:30 Dinner", byTime);
        schedule.addInOrder("11:00 Class", byTime);

        System.out.println("Schedule in time order: " + schedule);
    }

    // LL9 – Bug Tracker List (Remove by ID)
    private static void runLL9_BugTrackerRemoveById() {
        CSLinkedList<String> bugs = new CSLinkedList<>();

        bugs.add("BUG-101");
        bugs.add("BUG-102");
        bugs.add("BUG-103");
        bugs.add("BUG-102");
        bugs.add("BUG-104");

        System.out.println("Original bug list: " + bugs);

        boolean removed = bugs.removeFirstOccurrence("BUG-102");
        System.out.println("After fixing BUG-102 (removed=" + removed + "): " + bugs);

        removed = bugs.removeFirstOccurrence("BUG-999");
        System.out.println("Trying to remove BUG-999 (removed=" + removed + "): " + bugs);
    }

    // LL10 – Playlist Shuffle Copy
    private static void runLL10_PlaylistShuffleCopy() {
        CSLinkedList<String> playlist = new CSLinkedList<>();

        playlist.add("Song A");
        playlist.add("Song B");
        playlist.add("Song C");
        playlist.add("Song D");

        System.out.println("Original playlist: " + playlist);

        // Make a separate copy
        CSLinkedList<String> shuffled = playlist.copy();

        // "Shuffle" the copy a bit: swap first and last, then move one song
        if (shuffled.size() > 1) {
            String temp = shuffled.get(0);
            shuffled.set(0, shuffled.get(shuffled.size() - 1));
            shuffled.set(shuffled.size() - 1, temp);
        }

        if (shuffled.size() > 2) {
            String moved = shuffled.remove(1);
            shuffled.add(moved);
        }

        System.out.println("Shuffled copy: " + shuffled);
        System.out.println("Original still unchanged: " + playlist);
    }

}
