package game.bonusGame;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.TalkAction;

import java.util.Random;

public class TreeTalkAction extends TalkAction {

    private Actor subject;

    /**
     * An array of insults
     */
    private static String[] dialogues = {"Water me. I'm thirsty", "Oh, look! I'm growing a new leaf",
            "Did you know you can redeem items with stones?", "I wish I had more tree friends"};

    /**
     * Constructor.
     *
     * @param actor Actor player performing the talk action
     * @param subject Actor stone tree
     */
    TreeTalkAction (Actor actor, Actor subject) {
        super(actor, subject);
        this.subject = subject;
    }

    /**
     * Performs the stone tree's talk action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A dialogue for stone tree is returned
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int ranNum = new Random().nextInt(dialogues.length);
        String dialogue = dialogues[ranNum];
        return subject + ": " + dialogue;
    }

    /**
     * Returns a description of talk action to display on the menu.
     *
     * @param actor The actor performing the action.
     * @return  a String describing the talk action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " talks to stone tree";
    }
}
