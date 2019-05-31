package game;

import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;
import edu.monash.fit2099.engine.Item;


/**
 * This class represents the world in the game.
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
     * Returns a suitable end game message based on the scenario
     *
     * If the player is knocked out, returns the String "Player loses"
     * Else if when the player defeats Yugo Maxx and carries his unconscious body back to Earth, returns the String
     * “Player wins”
     * Else, returns the String, "Game ended"
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
     * Checks if the game is still running
     *
     * Returns false when :
     * 1. The player is no longer in the game AND
     * 2. The player successfully defeats Yugo Maxx and carries his unconscious body back to Earth
     *
     * Returns true if the player is still in the game.
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
     * Checks if the player's inventory has Yugo Maxx's unconscious body which has skill GameSkills.YUGOBODY
     *
     * @return true if the actor's inventory has the Yugo Maxx's unconscious body with GameSkills.YUGOBODY.
     * false otherwise
     */
    private boolean checkYugoMaxxBody(){
        return this.player.hasSkill(GameSkills.YUGOBODY);
    }
}
