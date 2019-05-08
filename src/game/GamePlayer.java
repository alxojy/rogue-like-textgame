package game;

import edu.monash.fit2099.engine.*;

/**
 *
 * The GamePlayer extends from Player.
 * GamePlayer has additional MaxCounter attribute and stunnedPlayer boolean variable.
 * These additional instance variables enables GamePlayer to be stunned by Ninja
 *
 */
public class GamePlayer extends Player {

    private MaxCounter counter = new MaxCounter(3);
    private boolean stunnedPlayer = false;
    private GameMap map;

    /**
     * Constructor.
     *
     * @param name Name to call the GamePlayer in the UI
     * @param displayChar Character to display the GamePlayer in UI
     * @param priority How early in the turn the GamePlayer can act
     * @param hitPoints GamePlayer's starting number of hitpoints
     */
    GamePlayer(String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
    }

    /**
     * Overrides the method from Player
     *
     * Additional feature
     * This overridden method
     * 1. increments and resets the counter attribute.
     * 2. changes the status of stunnedPlayer
     *
     * This allows the player to be stunned for TWO turns.
     *
     * @param actions the actions to display
     * @param map the map to display
     * @param display the object that performs the console I/O
     * @return the Action that the user selects
     *
     */
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

    /**
     * To change the status of stunnedPlayer
     * @param stunStatus the new status to update to
     */
    protected void setPlayerStunned(boolean stunStatus) {
        stunnedPlayer = stunStatus;
    }

    /**
     * Returns the status of stunnedPlayer
     * @return the current status of stunnedPlayer
     */
    protected boolean getPlayerStunned() {
        return stunnedPlayer;
    }

}
