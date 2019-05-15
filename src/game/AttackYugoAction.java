package game;

import edu.monash.fit2099.engine.*;

public class AttackYugoAction extends AttackAction {

    private YugoMaxx yugoMaxx;
    private GamePlayer player;

    public AttackYugoAction(GamePlayer player, YugoMaxx yugoMaxx) {
        super(player, yugoMaxx);
        this.yugoMaxx = yugoMaxx;
        this.player = player;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        if (yugoMaxx.hasExoskeleton()) {
            return actor + " attacks " + yugoMaxx + " but there's 0 damage ";
        }
        return super.execute(actor, map);
    }
}


