package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

/**
 * This class represents the stun behaviour and creates an Action for the actor to stun its target
 * @author Team Kimchi
 */
public class StunBehaviour extends Action implements ActionFactory {

    private GamePlayer subject;
    private Random rand = new Random();

    /**
     * Constructor.
     *
     * @param subject GamePlayer object, player that is the target
     */
    StunBehaviour(GamePlayer subject) {
        this.subject = subject;
    }

    /**
     * Performs the Action to stun the player.
     *
     * - If the player is stunned, it'll return the String that the stun was missed.
     * - If the player is not stunned, there is a 50% chance that the stun is successful.
     *      - If the stun is not successful, it'll return the String that the stun was missed.
     *      - If the stun is successful, it'll return the String that the player is stunned.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on
     * @return a String describing the actor stunning the player
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (subject.getPlayerStunned()) {
            return actor + " misses " + subject;
        }

        else {
            if (rand.nextBoolean()) {
                return actor + " misses " + subject;
            }
            subject.setPlayerStunned(true);
            return actor + " stuns " + subject + " with a bag of stun powder";
        }
    }

    /**
     * Returns a String describing the action suitable for displaying in the menu, which is stuns
     *
     * @param actor The actor performing the action.
     * @return a String describing the stuns action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " stuns " + subject;
    }
    /**
     * Returns the empty string, as no hotKey is permanently assigned to StunBehaviour.
     *
     * @return the empty string
     */
    @Override
    public String hotKey() {
        return "";
    }

    /**
     * Returns a suitable Action based on the distance between the actor and the player.
     *
     * 1. If the distance between the actor and the player is less than or equals to 5:
     *  - If there is no terrain that blocks thrown objects, it will execute the stun Action and the actor will
     *  move away from the player by instantiating a new MoveActorAction.
     *  - If there is a terrain that blocks thrown objects, it will return a newly instantiated SkipTurnAction.
     * 2. If the distance between the actor and the player is more than 5, it will instantiate a new
     *    SkipTurnAction so that the actor does nothing.
     *
     * @param actor the actor that shouts the insult
     * @param map the map that the player is on
     * @return MoveActorAction if conditions to stun is fulfilled. Return SkipTurnAction otherwise.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        try {
            Location here = map.locationOf(actor);
            Location there = map.locationOf(subject);

            int currentDistance = Distance.distance(here, there);
            if (sameMaps(here.map(), there.map())) {
                for (Exit exit : here.getExits()) {
                    Location destination = exit.getDestination();
                    if (destination.canActorEnter(actor)) {
                        int newDistance = Distance.distance(destination, there);
                        if (currentDistance <= 5 && newDistance > currentDistance) {
                            Range xs, ys;

                            xs = new Range(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
                            ys = new Range(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1);

                            for (int x : xs) {
                                for (int y : ys) {
                                    if (map.at(x, y).getGround().blocksThrownObjects()) {
                                        return new SkipTurnAction();
                                    }
                                }
                            }
                            System.out.println(execute(actor, map));
                            return new MoveActorAction(destination, exit.getName());
                        }
                    }
                }
            }
        }
        catch (NullPointerException npe) {
            return new SkipTurnAction();
        }
        return new SkipTurnAction();
    }

    private boolean sameMaps(GameMap a, GameMap b) {
        return a == b;
    }

}
