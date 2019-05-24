package game;

import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;
import edu.monash.fit2099.engine.Item;

public class GameWorld extends World {

    public GameWorld(Display display){
        super(display);
    }

    protected String endGameMessage(){
        if (!this.player.isConscious()){
            return "Player loses";
        }
        else if (checkYugoMaxxBody()){
            return "Player Wins";
        }
        return "Game ended";
    }

    protected boolean stillRunning() {
        GameMap playersMap = actorLocations.locationOf(player).map();
        if(checkYugoMaxxBody() && playersMap == EarthMap.getMap()) {
            return false;
        }
        return actorLocations.contains(player);
    }


    private boolean checkYugoMaxxBody(){
        for (Item item : this.player.getInventory()){
            if (item.hasSkill(GameSkills.YUGOBODY)){
                return true;
            }
        }
        return false;
    }
}
