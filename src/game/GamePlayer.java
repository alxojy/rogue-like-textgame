package game;

import edu.monash.fit2099.engine.*;

/**
 * Represents a player in the game.
 *
 * GamePlayer has additional MaxCounter attribute and stunnedPlayer boolean variable.
 * These additional instance variables enables GamePlayer to be stunned by Ninja
 * @author Team Kimchi
 *
 */
public class GamePlayer extends Player {

    /**
     * MaxCounter attribute used to store the maximum value that resets itself when the maximum value is reached.
     * Since the player should be stunned for 2 turns, its maximum value is 3.
     */
    private MaxCounter counter = new MaxCounter(3);
    private boolean stunnedPlayer = false;
    private GameMap map;

    /**
     * Constructor.
     *
     * @param name Name of the player.
     * @param displayChar char to display the player.
     * @param priority Priority of the player.
     * @param hitPoints Player's starting number of hitPoints.
     */
    GamePlayer(String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
    }

    /**
     * Returns an Action performed by the player.
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
