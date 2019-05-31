package game.bonusGame;

import edu.monash.fit2099.engine.*;
import game.Counter;
import game.GamePlayer;

/**
 * This class represents the Action of redeeming a ticket for intra-world teleportation
 * @author Team Kimchi
 */
public class RedeemTicketAction extends RedeemAction {

    private GamePlayer player;
    private final static BonusGameSkills ticketSkills = BonusGameSkills.TICKET;

    /**
     * Constructor.
     *
     * Calls its superclass' addItemValue method to initialise the value of ticket = 2 stones
     * @param player the player in the game
     */
    RedeemTicketAction(GamePlayer player){
        this.player = player;
        super.addItemValue(ticketSkills, 2);
    }

    /**
     * Performs the Action of redeeming a ticket for intra-world teleportation.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on
     * @return A String describing that the ticket has been redeemed if the player has sufficient number of stones
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Counter stoneCounter = player.getStoneCounter();
        if (checkSufficientStones(ticketSkills, stoneCounter)) {
            player.addItemToInventory(createTicket());
            player.addItemToInventory(createTicket());
            redeem(ticketSkills, stoneCounter);
            return actor + " redeemed two tickets that can be used for teleportation";
        }
        return super.execute(actor, map);
    }

    /**
     * Creates an Item which is a ticket
     *
     * @return Item ticket
     */
    private Item createTicket() {
        Item ticket = Item.newInventoryItem("ticket",'t');
        ticket.addSkill(ticketSkills);
        return ticket;
    }

    /**
     * Returns a String description for displaying in the menu, which is redeems teleportation tickets
     *
     * @param actor The actor performing the action.
     * @return A String describing the ticket redemption action
     */
    @Override
    public String menuDescription(Actor actor) { return actor + " redeems teleportation tickets for a round trip (2 stones)";}

    /**
     * Returns the empty String, as no hotKey is permanently assigned to RedeemTicketAction.
     *
     * @return The empty String
     */
    @Override
    public String hotKey() {
        return "";
    }

}


