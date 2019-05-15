package game;

import edu.monash.fit2099.engine.*;

public class AttackYugoAction extends AttackAction {

    private YugoMexx yugoMexx;
    private GamePlayer player;

    public AttackYugoAction(GamePlayer player, YugoMexx yugoMexx) {
        super(player, yugoMexx);
        this.yugoMexx = yugoMexx;
        this.player = player;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        if (yugoMexx.hasExoskeleton()) {
            return actor + " attacks " + yugoMexx + " but there's 0 damage ";
        }
        return super.execute(actor, map);
    }
}


