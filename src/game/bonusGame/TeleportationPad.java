package game.bonusGame;
import edu.monash.fit2099.engine.*;
import java.util.ArrayList;

public class TeleportationPad extends Item {
    private static ArrayList<TeleportationPad> teleportationPads = new ArrayList<>();
    private Actor subject;
    private Location location;
    private String direction;

    /**
     * Constructor
     *
     * @param player the player to be moved to Earth
     */
    public TeleportationPad(Actor player, String direction) {
        super("teleportation pad", '⎔');
        Item.newFurniture("teleportation pad", '⎔');
        teleportationPads.add(this);
        this.direction = direction;
        subject = player;
    }

    public void addTeleportationPadToMap(GameMap map, int x , int y){
        map.addItem(this ,x,y);
        location = map.at(x,y);
    }

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
