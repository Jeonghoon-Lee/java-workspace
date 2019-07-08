package day3_generic_linkedlist;

import java.util.Objects;

public class Entry {
    private String item;
    private int count;

    public Entry(String item, int count) {
        this.item = item;
        this.count = count;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return count == entry.count &&
                Objects.equals(item, entry.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, count);
    }

    @Override
    public String toString() {
        return item + " = " + count;
    }
}

