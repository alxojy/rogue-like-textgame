package game;

import edu.monash.fit2099.engine.*;

public class RocketPad extends Ground {

    public RocketPad() {
        super('^');
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        Actions actions = new Actions();
        /*
        boolean firstCond = false, secondCond = false;
        for (Item currentItem: actor.getInventory()){
            if (currentItem.hasSkill(GameSkills.BUILDROCKETBASE)) {
                firstCond = true;
            }
            else if (currentItem.hasSkill(GameSkills.BUILDROCKETTOP)) {
                secondCond = true;
            }
        }
        if (firstCond && secondCond) {
            if (actor instanceof Player) {
                actions.add(new BuildRocketAction(actor));
            }
        }*/
        if (actor instanceof Player) {
            actions.add(new BuildRocketAction(actor));
        }
        return actions;
    }
}
