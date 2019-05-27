package game;

import edu.monash.fit2099.engine.Item;

public class OxygenTank extends Item {

    /**
     * Constructor
     * Oxygen Tank Item has GameSkills.OXYGENTANK
     */
    OxygenTank() {
        super("oxygen tank", 'o');
        this.addSkill(GameSkills.OXYGENTANK);
    }

}
