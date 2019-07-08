package day3_generic_linkedlist;

public class GenericLinkedListDemo {
    public static void main(String[] args) {
        GenericLinkedList<Entry> list = new GenericLinkedList<>();

        list.addToStart(new Entry("Apple", 1));
        list.addToStart(new Entry("Cherry", 2));
        list.addToStart(new Entry("Graph", 3));

        System.out.printf("\nItem count of list: %d\n\n", list.size());

        list.outputList();
    }
}
