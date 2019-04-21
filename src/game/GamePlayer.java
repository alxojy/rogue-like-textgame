package game;

import edu.monash.fit2099.engine.*;

public class GamePlayer extends Player {

    private int counter = 0;
    private boolean stunnedPlayer = false;

    public GamePlayer(String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        if (getPlayerStunned() && counter < 2) {
            incrementCounter();
            return super.playTurn(new Actions(new SkipTurnAction()), map, display);
        }
        else if (counter == 2) {
            resetCounter();
            setPlayerStunned(false);
        }
        return super.playTurn(actions, map, display);

    }

    private void incrementCounter() {
        counter += 1;
    }

    private void resetCounter() {
        counter = 0;
    }

    public void setPlayerStunned(boolean stunStatus) {
        stunnedPlayer = stunStatus;
    }

    public boolean getPlayerStunned() {
        return stunnedPlayer;
    }
}
