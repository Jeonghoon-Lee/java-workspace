

public class LinkedListDemo {
    public static void main(String args[]) {
        LinkedList list = new LinkedList();

        list.addToStart("John");
        list.addToStart("David");
        list.addToStart("Smith");

        System.out.println("Number of items in the list: " + list.size());

        System.out.println("\n----- Items in the list -----");
        list.outputList();

        System.out.println("Check 'Smith' in the list: " + list.contains("Smith"));
        System.out.println("Check 'Maria' in the list: " + list.contains("Maria"));

        System.out.println("\nDelete from list");
        while (!list.isEmpty()) {
            System.out.println(list.deleteHeadNode());
        }

        System.out.println("Number of items after deleting: " + list.size());
    }
}
