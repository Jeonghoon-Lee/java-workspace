package day3_generic_linkedlist;

import java.util.Objects;

public class GenericLinkedList<T> {
    private class Node<T> {
        private T data;
        private Node<T> link;

        public Node() { }

        public Node(T data, Node<T> link) {
            this.data = data;
            this.link = link;
        }
    }

    private Node head;

    public GenericLinkedList() {
        head = null;
    }

    public void addToStart(T newItem) {
        head = new Node<T>(newItem, head);
    }

    public Node<T> deleteHeadNode() {
        if (head == null)
            return null;

        Node<T> deletedNode = head;

        head = deletedNode.link;
        return deletedNode;
    }

    public int size() {
        int count = 0;
        Node<T> position = head;

        while (position != null) {
            count++;
            position = position.link;
        }

        return count;
    }

    public boolean contains(Node<T> target) {
        return find(target) != null;
    }

    public Node<T> find(Node<T> target) {
        Node position = head;

        while (position != null) {
            if (position.data.equals(target)) {
                break;
            } else {
                position = position.link;
            }
        }
        return position;
    }

    public void outputList() {
        Node<T> position = head;

        while (position != null) {
            System.out.println(position.data);
            position = position.link;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clearList() {
        head = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenericLinkedList<?> that = (GenericLinkedList<?>) o;

        if (this.size() != that.size()) return false;

        Node<T> position = head;
        Node<T> positionOther = that.head;
        while (position != null) {
            if (!position.data.equals(positionOther.data))
                return false;
            position = position.link;
            positionOther = positionOther.link;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }
}
