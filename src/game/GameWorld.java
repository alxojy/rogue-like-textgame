package game;

import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;
import edu.monash.fit2099.engine.Item;


/**
 * This class extends from World and it represents GameWorld objects
 * @author Team Kimchi
 */

public class GameWorld extends World {
    /**
     * Constructor.
     *
     * @param display a Display object
     */

    public GameWorld(Display display){
        super(display);
    }

    /**
     * returns a suitable EndGameMessage based on the scenario
     * if player is not conscious, returns "player loses"
     * else if player carried yugoMaxx's unconscious body back to earth, returns "player wins"
     * else, returns Game Ended
     * @return
     */
    protected String endGameMessage(){
        if (!this.player.isConscious()){
            return "Player loses";
        }
        else if (checkYugoMaxxBody()){
            return "Player brought Yugo Maxx's body to Earth. Player wins";
        }
        return "Game ended";
    }

    /**
     * This method checks if the game is still running
     * Returns false when :
     * 1. player is no longer in the game.
     * 2. player successfully defeats yugoMaxx and carries his unconscious body back to earth
     *
     * Returns true , if player is still in the game.
     * @return a boolean that indicates if the game is still running
     */
    protected boolean stillRunning() {
        try {
            GameMap playersMap = actorLocations.locationOf(player).map();
            if(checkYugoMaxxBody() && playersMap == EarthMap.getMap()) {
                return false;
            }
        }
        catch (NullPointerException npe) {
        }
        return actorLocations.contains(player);
    }

    /**
     * Checks if the player's inventory has yugoMaxx's unconscious body which has skill GameSkills.YUGOBODY
     *
     * @return true if the actor's inventory has the yugoMaxx's unconscious body with GameSkills.YUGOBODY. false otherwise
     */
    private boolean checkYugoMaxxBody(){
        for (Item item : this.player.getInventory()){
            if (item.hasSkill(GameSkills.YUGOBODY)){
                return true;
            }
        }
        return false;
    }
}
