package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

/**
 * This class represents the stun attack behaviour and an AttackAction for the actor to stun its target
 * @author Team Kimchi
 */
public class StunBehaviour extends AttackAction implements ActionFactory {

    private GamePlayer subject;
    private Random rand = new Random();
    /**
     * Constructor initialises the actor carrying out the stun attack and the actor that is the target
     *
     * @param actor actor carrying out the attack
     * @param subject actor that is the target
     */
    StunBehaviour(Actor actor, GamePlayer subject) {
        super(actor, subject);
        this.subject = subject;
    }

    /**
     * This method executes the stun attack action
     * Overrides Action.execute()
     * - If the player is stunned, it'll return the String that the stun attack was missed.
     * - If the player is not stunned, there is a 50% chance that the stun attack is successful.
     *      - If the stun attack is not successful, it'll return the String that the stun attack was missed.
     *      - If the stun attack is successful, it'll return the String that the player is stunned and
     *        damages the player
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on
     * @return an Action
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        if (canWeaponStun(actor.getWeapon())) {
            if (subject.getPlayerStunned()) {
                return actor + " misses " + subject;
            }
            else {
                if (rand.nextBoolean()) {
                    return actor + " misses " + subject;
                }

                int damage = actor.getWeapon().damage();
                subject.setPlayerStunned(true);
                String result = actor + " " + actor.getWeapon().verb() + " " + subject + " for " + damage + " damage";

                subject.hurt(damage);
                if (!subject.isConscious()) {

                    Item sleepingActor = new Item("Sleeping " + subject, '%');
                    map.locationOf(subject).addItem(sleepingActor);
                    for (Item item : subject.getInventory()) {
                        new DropItemAction(item).execute(subject, map);
                    }
                    map.removeActor(subject);
                    result += System.lineSeparator() + subject + " is knocked out.";
                }
                return result;

            }
        }
        return super.execute(actor, map);
    }

    /**
     * Returns a String describing the action suitable for displaying in the menu, which is stun attacks
     *
     * @param actor The actor performing the action.
     * @return a String describing the stun attack action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " stun attacks " + subject;
    }

    @Override
    public String hotKey() {
        return "";
    }

    /**
     * Returns a suitable Action based on the distance between the actor and the player
     *
     * 1. If the distance between the actor and the player is less than or equals to 5, it will execute the
     *    stun attack action and the actor will move away from the player by instantiating a new MoveActorAction
     * 2. If the distance between the actor and the player is more than 5, it will instantiate a new
     *    SkipTurnAction so that the actor does nothing
     *
     * @param actor the actor that shouts the insult
     * @param map the map that the player is on
     * @return shout insult action if successful. null if not
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        Location there = map.locationOf(subject);

        int currentDistance = new Distance().distance(here, there);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                int newDistance = new Distance().distance(destination, there);
                if (currentDistance <= 5 && newDistance > currentDistance) {
                    Range xs, ys;

                    xs = new Range(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
                    ys = new Range(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1);

                    for (int x : xs) {
                        for (int y : ys) {
                            if (map.at(x, y).getGround().blocksThrownObjects())
                                return new SkipTurnAction();
                        }
                    }
                    System.out.println(execute(actor, map));
                    return new MoveActorAction(destination, exit.getName());
                }
            }
        }
    return new SkipTurnAction();
    }

    private boolean canWeaponStun(Weapon weapon) {
        if (weapon instanceof WeaponItem) {
            return ((WeaponItem) weapon).getDisplayChar() == 's';
        }
        return false;
    }
}
