package game.bonusGame;
import edu.monash.fit2099.engine.*;
import java.util.ArrayList;

/**
 * This class represents a TeleportationPad Item that allows actor to teleport
 * @author Team Kimchi
 */
public class TeleportationPad extends Item {
    private static ArrayList<TeleportationPad> teleportationPads = new ArrayList<>();
    private Actor subject;
    private Location location;
    private String direction;

    /**
     * Constructor
     *
     * @param player the player that will be teleported
     * @param  direction the direction of the movement. EG: "into the locked room"
     */
    public TeleportationPad(Actor player, String direction) {
        super("teleportation pad", '◌');
        Item.newFurniture("teleportation pad", '◌');
        teleportationPads.add(this);
        this.direction = direction;
        subject = player;
    }

    /**
     * This method adds teleporationPad to the given map and initialises the location of the
     * teleporation pad
     * @param map the map to add the teleportation pad
     * @param x index x
     * @param y index y
     */
    public void addTeleportationPadToMap(GameMap map, int x , int y){
        map.addItem(this ,x,y);
        location = map.at(x,y);
    }

    /**
     * Returns a list of actions that can be performed when the actor is standing on TeleportationPad item furniture.
     *
     * If subject's inventory has ticket item, subject is allowed to teleport to another teleportation pad.
     * This calls for the teleportAction class.
     *
     * @return TeleportAction if the player has ticket item.
     *         An empty Action list if the player does not have the ticket.
     */
    @Override
    public Actions getAllowableActions() {
        Actions actions = new Actions();
        if (subject.hasSkill(BonusGameSkills.TICKET))
        for (Item currentItem: subject.getInventory()) {
            if (currentItem.hasSkill(BonusGameSkills.TICKET)) {
                for (TeleportationPad currentPad: teleportationPads ){
                    if (this != currentPad ){
                        actions.add(new TeleportAction(currentPad.location, direction, subject, currentItem));
                        return actions;
                    }
                }
            }
        }
        return actions;
    }


}
