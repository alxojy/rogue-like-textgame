package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

public class StunBehaviour extends AttackAction implements ActionFactory {

    private Actor actor;
    private Actor subject;
    private Random rand = new Random();

    StunBehaviour(Actor actor, Actor subject) {
        super(actor, subject);
        this.actor = actor;
        this.subject = subject;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        WeaponItem stunPowderBag = new WeaponItem("stun powder bag", 's', 5, "stuns");

        if (subject instanceof GamePlayer) {
            if (((GamePlayer) subject).getPlayerStunned()) {
                return actor + " misses " + subject + ".";
            } else {
                if (rand.nextBoolean()) {
                    return actor + " misses " + subject;
                }

                int damage = stunPowderBag.damage();
                ((GamePlayer) subject).setPlayerStunned(true);
                String result = actor + " " + stunPowderBag.verb() + " " + subject + " for " + damage + " damage";

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

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + subject;
    }

    @Override
    public String hotKey() {
        return "";
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location here = map.locationOf(actor);
        Location there = map.locationOf(subject);

        int currentDistance = distance(here, there);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                int newDistance = distance(destination, there);
                if (currentDistance <= 5 && newDistance > currentDistance) {
                    System.out.println(execute(actor, map));
                    return new MoveActorAction(destination, exit.getName());
                }
                else if (currentDistance > 5) {
                    return new SkipTurnAction();
                }
            }
        }
    return null;
    }

    // Manhattan distance.
    private int distance(Location a, Location b) {
        int retVal;
        if (a != null && b != null) {
            retVal = Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
        }
        else {
            retVal = 0;
        }
        return retVal;
    }
}
