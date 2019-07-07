package day2_linkedlist;

public class LinkedList {
    private Node1 head;

    public LinkedList() {
        head = null;
    }

    public void addToStart(String item) {
        Node1 newItem = new Node1(item, head);

        head = newItem;
    }

    public Node1 deleteHeadNode() {
        Node1 deletedNode = head;

        head = deletedNode.getLink();

        return deletedNode;
    }

    public int size() {
        int count = 0;
        Node1 currentPosition = head;

        while (currentPosition != null) {
            count++;
            currentPosition = currentPosition.getLink();
        }

        return count;
    }

    public boolean contains(String target) {
        return find(target) != null;
    }

    public Node1 find(String target) {
        Node1 currentPosition = head;

        while (currentPosition != null) {
            if (currentPosition.getName().equals(target)) {
                break;
            } else {
                currentPosition = currentPosition.getLink();
            }
        }
        return currentPosition;
    }

    public void outputList() {
        Node1 currentPosition = head;

        while (currentPosition != null) {
            System.out.println(currentPosition);
            currentPosition = currentPosition.getLink();
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
