package game.bonusGame;

import edu.monash.fit2099.engine.*;
import game.Counter;
import game.GamePlayer;


public class RedeemTicketAction extends RedeemAction {

    private GamePlayer player;
    private final static BonusGameSkills ticketSkills = BonusGameSkills.TICKET;

    RedeemTicketAction(GamePlayer player){
        this.player = player;
        super.addItemValue(ticketSkills, 2);
    }

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

    public Item createTicket() {
        Item ticket = Item.newInventoryItem("ticket",'t');
        ticket.addSkill(ticketSkills);
        return ticket;
    }

    @Override
    public String menuDescription(Actor actor) { return actor + " redeems teleportation tickets for a round trip (2 stones)";}

    @Override
    public String hotKey() {
        return "";
    }

}


