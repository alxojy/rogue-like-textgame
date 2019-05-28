package game;

import edu.monash.fit2099.engine.*;

/**
 * This class represents an action that attacks Yugo Maxx
 * @author Team Kimchi
 */
public class AttackYugoAction extends AttackAction {

    /**
     * Represents Yugo Maxx, which is the subject that is being attacked.
     */
    private YugoMaxx yugoMaxx;

    /**
     * Constructor.
     *
     * @param player The player that is performing this action
     * @param yugoMaxx Yugo Maxx who is the subject being attacked
     */
    public AttackYugoAction(GamePlayer player, YugoMaxx yugoMaxx) {
        super(player, yugoMaxx);
        this.yugoMaxx = yugoMaxx;
    }


    /**
     * Performs the Action of attacking Yugo Maxx.
     *
     * Overrides its superclass's execute method and performs either of the following tasks:
     * 1. If Yugo Maxx's exoskeleton is present, the actor attacks Yugo Maxx but there's no damage to Yugo Maxx.
     * Otherwise, it attacks Yugo Maxx by calling its superclass' execute method.
     * 2. If Yugo Maxx is knocked out, Yugo Maxx's unconcious body is added to the map. GameSkills.YUGOBODY is added
     * to its body so that the body can be identified.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string describing that Yugo Maxx has been attacked.
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        Weapon weapon = actor.getWeapon();
        int damage = weapon.damage();

        if (yugoMaxx.hasExoskeleton()) {
            return actor + " attacks " + yugoMaxx + " but there's 0 damage ";
        }
        yugoMaxx.hurt(damage);
        if (!yugoMaxx.isConscious()) {
            Item sleepingActor = new Item("Sleeping " + yugoMaxx, '%');
            sleepingActor.addSkill(GameSkills.YUGOBODY);
            map.locationOf(yugoMaxx).addItem(sleepingActor);
            map.removeActor(yugoMaxx);
            return yugoMaxx+" is knocked out";
        }
        yugoMaxx.heal(damage);
        return super.execute(actor, map);
    }
}


