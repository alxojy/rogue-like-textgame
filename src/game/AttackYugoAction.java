package game;

import edu.monash.fit2099.engine.*;

/**
 * This class represents an action that attacks Yugo Maxx
 * @author Team Kimchi
 */
public class AttackYugoAction extends AttackAction {

    /**
     * Represents yugoMaxx , which is the subject that is being attacked.
     */
    private YugoMaxx yugoMaxx;

    /**
     * Constructor.
     *
     * @param player The gameplayer that is performing this action
     * @param yugoMaxx yugoMaxx who is being attacked
     */
    public AttackYugoAction(GamePlayer player, YugoMaxx yugoMaxx) {
        super(player, yugoMaxx);
        this.yugoMaxx = yugoMaxx;
    }


    /**
     * Performs the action attacking yugoMaxx
     *
     * Overrides its superclass's execute method and performs either of the following tasks:
     * 1. if yugoMaxx's exoskeleton is still effective, actor attacks yugoMaxx but no damage is done to yugoMaxx
     * 2. else if yugoMaxx is knocked out, add yugoMaxx's unconscious body onto the map.
     * 3.if neither 1,2 is true, attack normally.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string describing the action performed
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


