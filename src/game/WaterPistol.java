//ignore this class

package game;

import edu.monash.fit2099.engine.Item;

public class WaterPistol extends Item{

    private boolean isEmpty;

    WaterPistol() {
        super("water pistol", '¬');
        this.addSkill(GameSkills.ISEMPTY);
    }

    public void setPistolEmpty (boolean isEmpty){
        this.isEmpty = isEmpty;



    }
}


