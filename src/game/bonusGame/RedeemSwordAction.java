package game.bonusGame;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.WeaponItem;
import game.Counter;
import game.GamePlayer;

public class RedeemSwordAction extends RedeemAction {

    private GamePlayer gamePlayer;
    private final static BonusGameSkills weaponSkills = BonusGameSkills.SWORD;

    RedeemSwordAction(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
        super.addItemValue(weaponSkills, 4);
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Counter stoneCounter = gamePlayer.getStoneCounter();
        if (checkSufficientStones(weaponSkills, stoneCounter)) {
            WeaponItem sword = new WeaponItem("sword", '/', 10, "slices");
            sword.addSkill(weaponSkills);
            map.locationOf(actor).addItem(sword);
            redeem(weaponSkills, stoneCounter);
            return "A sword has been dropped on the location of " + actor;
        }
        return super.execute(actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " redeems a sword (4 stones)";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
