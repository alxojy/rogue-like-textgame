package game;

import edu.monash.fit2099.engine.*;

public class GamePlayer extends Player {

    private MaxCounter counter = new MaxCounter(3);
    private boolean stunnedPlayer = false;
    private GameMap map;

    public GamePlayer(String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        this.map = map;
        if (getPlayerStunned() && counter.canIncrement()) {
            counter.increment();
            return super.playTurn(new Actions(new SkipTurnAction()), map, display);
        }
        else if (!counter.canIncrement()) {
            setPlayerStunned(false);
            counter.increment();
        }
        return super.playTurn(actions, map, display);

    }

    public void setPlayerStunned(boolean stunStatus) {
        stunnedPlayer = stunStatus;
    }

    public boolean getPlayerStunned() {
        return stunnedPlayer;
    }

    public void removePlayerFromMap(GamePlayer player){
        map.removeActor(player);
    }
}
