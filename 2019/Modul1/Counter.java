package Modul1;

public class Counter {
    private int count = 0;
    public int increment() {
        if(getCount() < Integer.MAX_VALUE) {
            return count++;
        }
        else  return count;
    }
    public int decrement() {
        if(getCount() > 0) {
            return count--;
        }
        else  return count;
    }

    public int getCount() {
        return count;
    }
}