package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

public class RocketPad extends Ground {
    Item rocketBody = null, rocketEngine= null ;

    public RocketPad() {
        super('^');
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
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
        if (actor instanceof GamePlayer) {
            if (checkItems(location)) {
                actions.add(new BuildRocketAction(actor,location, rocketBody, rocketEngine));
                ((GamePlayer) actor).removePlayerFromMap((GamePlayer)actor);

            }
        }
        return actions;
    }

    public boolean checkItems(Location location){
        boolean retVal = false;
        List<Item> itemList = location.getItems();
        boolean firstCond = false, secondCond = false;

        for (Item currentItem : itemList) {
            if (currentItem.hasSkill(GameSkills.BUILDROCKETBASE)) {
                firstCond = true;
                rocketBody = currentItem;
            }
            else if (currentItem.hasSkill(GameSkills.BUILDROCKETTOP)) {
                secondCond = true;
                rocketEngine = currentItem;
            }
        }
        if (firstCond && secondCond) {
            retVal = true;
            location.removeItem(rocketBody);
            location.removeItem(rocketEngine);
        }
        return retVal;
    }
}
