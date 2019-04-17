package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

public class StunAttackAction extends AttackAction {

    private Actor actor;
    private Actor subject;
    private Random rand = new Random();

    StunAttackAction(Actor actor, Actor subject) {
        super(actor, subject);
        this.actor = actor;
        this.subject = subject;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        WeaponItem stunPowderBag = new WeaponItem("stun powder bag", 's', 10, "stuns");

        if (subject instanceof GamePlayer) {
            if (((GamePlayer) subject).getPlayerStunned()) {
                return actor + " misses " + subject + ".";
            } else {
                if (rand.nextBoolean()) {
                    return actor + " misses " + subject + ".";
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

}
