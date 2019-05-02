package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

public class RocketPad extends Ground {
    public RocketPad() {
        super('^');
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions = new Actions();
        ActorLocations actorLocations = new ActorLocations();

        if (actor instanceof GamePlayer) {
            if (checkItems(location)) {
                actions.add(new BuildRocketAction(actor));
                for (Actor actorInLocation : actorLocations) {
                    ((Enemy) actorInLocation).removeActor(actorInLocation);
                }
                ((GamePlayer) actor).removePlayerFromMap((GamePlayer) actor);
            }
        }
        return actions;
    }

    private boolean checkItems(Location location){
        boolean retVal = false;
        Item rocketBody = null, rocketEngine= null ;
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
