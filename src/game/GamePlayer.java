package game;

import edu.monash.fit2099.engine.*;

/**
 * Represents a player in the game.
 *
 * GamePlayer has additional MaxCounter attribute and stunnedPlayer boolean variable.
 * These additional instance variables enables GamePlayer to be stunned by Ninja.
 * @author Team Kimchi
 *
 */
public class GamePlayer extends Player {

    public static ActionScheduler actionScheduler = new ActionScheduler();

    /**
     * MaxCounter attribute used to store the maximum value that resets itself when the maximum value is reached.
     * Since the player should be stunned for 2 turns, its maximum value is 3.
     */
    private MaxCounter counter = new MaxCounter(3);

    /**
     * boolean attribute used to return the state of whether the player is stunned.
     */
    private boolean stunnedPlayer = false;

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
     * Plays a turn and display the actions that can be performed by the player.
     *
     * If the player is stunned. This overridden method;
     * 1. Increments the counter if the player is stunned and the counter can be incremented. If the counter can be
     * incremented, it indicates that the player has not been stunned for two turns. Hence,it adds a newly instantiated
     * SkipTurnAction into the newly instantiated Actions as the player is not allowed to perform any other actions.
     *
     * 2. Once the counter reaches its maximum value, it cannot be incremented anymore and
     * the counter will reset in the MaxCounter class. It sets the boolean stunnedPlayer to false
     * to return the state that the player is no longer stunned.
     *
     * If the player is not stunned, calls its superclass's playTurn method to play a turn and display
     * the actions that can be performed by the player.
     *
     * @param actions the actions to display
     * @param map the map to display
     * @param display the object that performs the console I/O
     * @return The Action that the user selects if the player is not stunned. The SkipTurnAction if the player is stunned.
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        if (getPlayerStunned() && counter.canIncrement()) {
            counter.increment();
            return super.playTurn(new Actions(new SkipTurnAction()), map, display);
        }
        else if (!counter.canIncrement()) {
            setPlayerStunned(false);
            counter.increment();
        }
        else if (!actionScheduler.isEmpty()) {
            actionScheduler.doActionScheduled(this, map);
        }
        return super.playTurn(actions, map, display);
    }

    /**
     * To change the boolean indicating if the player is stunned. Changes the boolean attribute, stunnedPlayer.
     *
     * @param stunStatus The new status to update the stunnedPlayer boolean to.
     */

    protected void setPlayerStunned(boolean stunStatus) {
        stunnedPlayer = stunStatus;
    }

    /**
     * Returns the status if the player is stunned. Returns the boolean stunnedPlayer.
     *
     * @return A boolean indicating if the player is stunned.
     */
    protected boolean getPlayerStunned() {
        return stunnedPlayer;
    }

}
