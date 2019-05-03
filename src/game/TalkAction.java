package game;

import edu.monash.fit2099.engine.*;

/**
 * Action to allow Q to talk
 */
public class TalkAction extends Action {
    private Actor actor;
    private Actor subject;

    TalkAction (Actor actor,Actor subject) {
        this.actor = actor;
        this.subject = subject;
    }

    /**
     * Allow Q to talk.
     * Overrides Action.execute()
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable string to be printed out later.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String description = actor + "is talking to " + subject;
        String retVal = "" ;
        for (Item item : actor.getInventory()){
            if ((item.hasSkill(GameSkills.GETROCKETBODY))) {
                retVal = "Q : Hand them over, I don’t have all day!";
            }
        }
        if (retVal == ""){
            retVal = "Q : I can give you something that will help, but I’m going to need the plans.";
        }

        return description + retVal;
    }

    /**
     * Returns a String describing the action suitable for displaying in the menu, which is talks
     *
     * @param actor The actor performing the action.
     * @return  a String describing the talk action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " talks to Q";
    }

    /**
     * Returns the empty string, as no hotkey is permanently assigned to talk action.
     * @return the empty string
     */
    @Override
    public String hotKey() {
        return "";
    }
    
}
