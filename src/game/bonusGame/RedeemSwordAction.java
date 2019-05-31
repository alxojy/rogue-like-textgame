package game.bonusGame;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Weapon;
import edu.monash.fit2099.engine.WeaponItem;
import game.Counter;
import game.GamePlayer;

/**
 * This class represents the Action of redeeming a sword
 * @author Team Kimchi
 */
public class RedeemSwordAction extends RedeemAction {

    private GamePlayer gamePlayer;
    private final static BonusGameSkills weaponSkills = BonusGameSkills.SWORD;

    /**
     * Constructor.
     *
     * Calls its superclass' addItemValue method to initialise the value of sword = 4 stones
     * @param gamePlayer the player in the game
     */
    RedeemSwordAction(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
        super.addItemValue(weaponSkills, 4);
    }

    /**
     * Performs the Action of redeeming a sword which is a weapon.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on
     * @return A String describing that the sword has been redeemed if the player has sufficient number of stones
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Counter stoneCounter = gamePlayer.getStoneCounter();
        if (checkSufficientStones(weaponSkills, stoneCounter)) {
            map.locationOf(actor).addItem(createSword());
            redeem(weaponSkills, stoneCounter);
            return "A sword has been dropped on the location of " + actor;
        }
        return super.execute(actor, map);
    }

    /**
     * Creates a WeaponItem which is a sword
     *
     * @return WeaponItem sword
     */
    private WeaponItem createSword() {
        WeaponItem sword = new WeaponItem("sword", '/', 10, "slices");
        sword.addSkill(weaponSkills);
        return sword;
    }

    /**
     * Returns a String description for displaying in the menu, which is redeems a sword
     *
     * @param actor The actor performing the action.
     * @return A String describing the sword redemption action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " redeems a sword (4 stones)";
    }

    /**
     * Returns the empty String, as no hotKey is permanently assigned to RedeemSwordAction.
     *
     * @return The empty String
     */
    @Override
    public String hotKey() {
        return "";
    }
}
