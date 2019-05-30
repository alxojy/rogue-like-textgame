package game.bonusGame;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import game.GamePlayer;


public class RedeemTicketAction extends Action {
    private GamePlayer player;

    public RedeemTicketAction(GamePlayer player){
        this.player = player;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        player.addItemToInventory(createTicket());
        player.addItemToInventory(createTicket());
        return actor + " redeemed two tickets that can be used for teleportation.";
    }

    public Item createTicket() {
        Item ticket = Item.newInventoryItem("ticket",'t');
        ticket.addSkill(BonusGameSkills.TICKET);

        return ticket;
    }

    @Override
    public String menuDescription(Actor actor) { return actor + " redeems teleportation tickets for a round trip.";}

    @Override
    public String hotKey() {
        return "";
    }

}


