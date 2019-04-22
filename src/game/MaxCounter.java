package game;

public class MaxCounter extends Counter {

    private int max;

    public MaxCounter(int max)  {
        this.max = max;
    }

    public int getMax() {
        return max;
    }


    public boolean canIncrement(){
        boolean flag = true;
        if (this.getValue()+1 == max ){
            flag = false;
        }
        return flag;
    }

    @Override
    public void increment() {
        super.increment();
        if (this.getValue() == max) {
            this.reset();
        }
    }
}