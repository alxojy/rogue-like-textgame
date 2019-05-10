package game;

/**
 * Resets its own value when the counter reaches its maximum value.
 * @author Team Kimchi
 */
public class MaxCounter extends Counter {

    /**
     * To keep track of the maximum value of the counter
     */
    private int max;

    /**
     * Constructor.
     *
     * @param max The maximum value of the counter
     */
    MaxCounter(int max)  {
        this.max = max;
    }

    /**
     * Increments and resets the counter when it reaches its maximum value.
     */

    @Override
    public void increment() {
        super.increment();
        if (this.getValue() == max) {
            this.reset();
        }
    }

    /**
     * Checks if counter can be incremented.
     *
     * Counter cannot be incremented further if the current value + 1 == max
     *
     * @return true if it can be incremented. false otherwise
     */
    public boolean canIncrement(){
        boolean flag = true;
        if (this.getValue()+1 == max ){
            flag = false;
        }
        return flag;
    }
}