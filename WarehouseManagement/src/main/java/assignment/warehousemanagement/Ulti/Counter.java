package assignment.warehousemanagement.Ulti;

public class Counter {
    int count;
    public Counter() {
        count = 0;
    }
    public int incAndGet() {
        return ++count;
    }
    public int get() {
        return count;
    }
}
