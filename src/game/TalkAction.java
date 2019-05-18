package game;

import edu.monash.fit2099.engine.*;

/**
 * This class represents an Action that talks
 * @author Team Kimchi
 */
public class TalkAction extends Action {
    private Actor actor;
    private Actor subject;

    /**
     * Constructor.
     *
     * @param actor Actor player performing the talk action
     * @param subject Actor Q
     */
    TalkAction (Actor actor,Actor subject) {
        this.actor = actor;
        this.subject = subject;
    }

    /**
     * Performs the talk action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A suitable String to be printed out based on whether the actor has the Item rocket plans which has
     * GameSkills.GETROCKETBODY
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String description = this.actor + " is talking to " + subject;
        String qDialogue = "" ;
        for (Item item : actor.getInventory()){
            if ((item.hasSkill(GameSkills.GETROCKETBODY))) {
                qDialogue = "Q: Hand them over, I don’t have all day!";
            }
        }
        if (qDialogue.equals("")){
            qDialogue = "Q: I can give you something that will help, but I’m going to need the plans.";
        }
        return description + "\n" + qDialogue;
    }

    /**
     * Returns a description of talk action to display on the menu.
     *
     * @param actor The actor performing the action.
     * @return  a String describing the talk action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " talks to Q";
    }

    /**
     * Returns the empty string, as no hotKey is permanently assigned to talk action.
     *
     * @return the empty string
     */
    @Override
    public String hotKey() {
        return "";
    }
    
}
