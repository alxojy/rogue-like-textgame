package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Player;

import java.util.ArrayList;

public class BuildRocketAction extends Action {

    private Actor subject;

    BuildRocketAction(Actor actor) {
        subject = actor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        ArrayList<Item>  item = new ArrayList<>();

        boolean firstCond = false, secondCond = false;
        for (Item currentItem : actor.getInventory()) {
            if (currentItem.hasSkill(GameSkills.BUILDROCKETBASE)) {
                firstCond = true;

                item.add(currentItem);

            } else if (currentItem.hasSkill(GameSkills.BUILDROCKETTOP)) {
                secondCond = true;

                item.add(currentItem);
            }
        }
        if (firstCond && secondCond) {
            if (actor instanceof Player) {
                actor.addItemToInventory(createRocket());
                for (Item item1 : item){
                    System.out.println(item1);
                }

                return "rocket has been created";
            }
        }

        return "no skills";
    }

    @Override
    public String menuDescription(Actor actor) {
        return subject + " creates a rocket";
    }

    @Override
    public String hotKey() {
        return "";
    }

    private Item createRocket() {
        Item rocket = new Item("rocket", 'R');
        return rocket;
    }
}
