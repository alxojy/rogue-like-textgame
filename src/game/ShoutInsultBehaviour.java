package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

public class ShoutInsultBehaviour extends Action implements ActionFactory {

    private Actor target;
    private Random rand = new Random();
    private static String[] insults = {"That's a bad move...", "This is an abomination!",
            "Did you press the wrong button again?"};

    public ShoutInsultBehaviour(Actor subject) {
        this.target = subject;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        int ranNum = rand.nextInt(insults.length);
        String insult = insults[ranNum];
        return actor + " insulted " + target + System.lineSeparator()+
                insult;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (rand.nextDouble() <= 0.10) {
            return this;
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
