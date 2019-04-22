package game;

public class Counter {

    private int value = 0;

    public void reset() {
        value = 0;
    }

    public void decrement() {
        value--;
    }

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
