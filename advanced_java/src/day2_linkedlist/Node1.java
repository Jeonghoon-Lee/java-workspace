package day2_linkedlist;

import java.util.Objects;

public class Node1 {
    private String name;

    private Node1 link;

    public Node1() { }

    public Node1(String name, Node1 link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node1 getLink() {
        return link;
    }

    public void setLink(Node1 link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node1 node1 = (Node1) o;
        return Objects.equals(name, node1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "day2_linkedlist.Node1{" +
                "name='" + name + '\'' +
                '}';
    }
}
