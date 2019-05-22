package game;

import edu.monash.fit2099.engine.*;

public class AttackYugoAction extends AttackAction {

    private YugoMaxx yugoMaxx;
    private GamePlayer player;
    private Item waterPistol;

    public AttackYugoAction(GamePlayer player, YugoMaxx yugoMaxx) {
        super(player, yugoMaxx);
        this.yugoMaxx = yugoMaxx;
        this.player = player;
    }

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


