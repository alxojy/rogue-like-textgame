package game;

import edu.monash.fit2099.engine.Item;

/**
 * This class represents an OxygenTank Item
 * @author Team Kimchi
 */

public class OxygenTank extends Item {

    /**
     * Constructor.
     *
     * Oxygen tank Item has GameSkills.OXYGENTANK
     */
    OxygenTank() {
        super("oxygen tank", 'o');
        this.addSkill(GameSkills.OXYGENTANK);
    }

}
