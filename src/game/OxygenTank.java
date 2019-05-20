package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Item;

public class OxygenTank extends Item {

    private MaxCounter oxygenPoint = new MaxCounter(11);

    OxygenTank() {
        super("oxygen tank", 'o');
        this.addSkill(GameSkills.OXYGENTANK);
    }

    @Override
    public Actions getAllowableActions() {
        // need to do some checking. maybe a skill? gameskills.OXYGENMOON (name must be changed later) only decrement
        if (oxygenPoint.getValue() > -1) {
            oxygenPoint.decrement();
            System.out.println(oxygenPoint.getValue());

            if (oxygenPoint.getValue() == 0) {
                this.removeSkill(GameSkills.OXYGENTANK);
            }
        }

    return super.allowableActions;
    }

}
