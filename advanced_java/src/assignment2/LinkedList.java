package assignment2;

import java.util.Objects;

public class LinkedList {
    private Token head;
    private Token tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addToHead(String data) {
        head = new Token(data, head);

        if (tail == null) {
            // first element
            tail = head;
        }
    }

    public void addToTail(String data) {
        if (head == null) {
            // empty list
            head = new Token(data, null);
            tail = head;
        } else {
            // add new item at the end of list
            Token newItem = new Token(data, null);
            tail.link = newItem;
            tail = newItem;
        }
    }

    public Token deleteFromHead() {
        Token deletedItem = head;

        head = head.link;
        if (head == null) {
            // empty list
            tail = null;
        }
        return deletedItem;
    }

    public int size() {
        int count = 0;
        Token currentPosition = head;

        while (currentPosition != null) {
            count++;
            currentPosition = currentPosition.link;
        }

        return count;
    }

    public boolean contains(String target) {
        return find(target) != null;
    }

    public Token find(String target) {
        Token currentPosition = head;

        while (currentPosition != null) {
            if (currentPosition.data.equals(target)) {
                break;
            }
            currentPosition = currentPosition.link;
        }
        return currentPosition;
    }

    public void outputList() {
        Token currentPosition = head;

        while (currentPosition != null) {
            System.out.println(currentPosition);
            currentPosition = currentPosition.link;
        }
    }

    private class Token {
        private String data;
        private Token link;

        public Token() {
            data = null;
            link = null;
        }

        public Token(String data, Token link) {
            this.data = data;
            this.link = link;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Token token = (Token) o;
            return Objects.equals(data, token.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return data;
        }
    }
}
