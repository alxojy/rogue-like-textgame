package game;

/**
 * Class representing MaxCounter object, inherits from Counter
 * has an additional attribute called max , to keep track of the maximum
 * value of the counter
 * @author Team Kimchi
 */
public class MaxCounter extends Counter {

    private int max;

    /**
     * Constructor.
     * @param max the maximum value of the counter
     */
    MaxCounter(int max)  {
        this.max = max;
    }

    /**
     * Checks if counter can be incremented
     * Counter cannot be increment further if the current value + 1 = max
     * @return True or False
     */
    public boolean canIncrement(){
        boolean flag = true;
        if (this.getValue()+1 == max ){
            flag = false;
        }
        return flag;
    }

    /**
     * Increments and resets the counter
     * If the value of counter after incrementing = value of max :
     * reset the counter
     */

    @Override
    public void increment() {
        super.increment();
        if (this.getValue() == max) {
            this.reset();
        }
    }
}