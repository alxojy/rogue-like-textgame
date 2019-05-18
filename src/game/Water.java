package game;

import edu.monash.fit2099.engine.*;

public class Water extends Ground {

    /**
     * Constructor.
     *
     * Initialises the char to display for water as '~'.
     */
    public Water() {
        super('~');
    }

    /**
     * water is an impassable terrain.
     *
     * @param actor Actor adjacent to water
     * @return false
     */
    @Override
    public boolean canActorEnter(Actor actor) { return false; }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        Actions actions = new Actions();
        if (containsPistol(actor)) {
            actions.add(new FillEmptyPistolAction());
        }
        return actions;
    }

    private boolean containsPistol(Actor actor) {
        for (Item currentItem : actor.getInventory()) {
            if (currentItem.hasSkill(GameSkills.PISTOLISEMPTY)) {
                return true;
            }
        }
        return false;
    }
}

