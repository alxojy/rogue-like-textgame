package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class OxygenTank extends Item {

    private Counter oxygenPoint   = new Counter(10);;
    private int emptyTank = 0 ;

    OxygenTank() {
        super("oxygen tank", 'o');
        this.addSkill(GameSkills.OXYGENTANK);
        System.out.println(this.hasSkill(GameSkills.OXYGENTANK));
    }

//    @Override
//    public Actions getAllowableActions() {
//            if (oxygenPoint.getValue() > -1) {
//                oxygenPoint.decrement();
//                System.out.println(oxygenPoint.getValue());
//
//                if (oxygenPoint.getValue() == emptyTank) {
//                    this.removeSkill(GameSkills.OXYGENTANK);
//                }
//            }
//        }
//    return super.allowableActions;
//    }

}
