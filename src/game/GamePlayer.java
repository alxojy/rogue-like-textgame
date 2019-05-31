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

    //MaxCounter attribute used to store the maximum value that resets itself when the maximum value is reached.
    //Since the player should be stunned for 2 turns, its maximum value is 3.
    private MaxCounter stunnedCounter = new MaxCounter(3);

    //boolean attribute used to return the state of whether the player is stunned.
    private boolean stunnedPlayer = false;

    //Counter attribute used to store the oxygen points that the player possesses.
    private Counter oxygenPoints = new Counter();

    //Counter attribute used to store the number of stones in the player's inventory.
    private Counter stoneCounter = new Counter();

    private final int zeroOxygen = 0;

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
     * If the player is stunned, it adds a newly instantiated SkipTurnAction into the newly instantiated Actions as the
     * player is not allowed to perform any other actions. If the player is on the Moon with insufficient oxygen points,
     * the player will be transported back to Earth.
     *
     * @param actions the actions to display
     * @param map the map to display
     * @param display the object that performs the console I/O
     * @return The Action that the user selects if the player is not stunned. The SkipTurnAction if the player is stunned.
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        addOxygenPoints();
        decrementOxygenPoints(map);
        System.out.println("Oxygen points: " + oxygenPoints.getValue());
        System.out.println("Number of stones: " + stoneCounter.getValue());
        // safety feature- transports player back to Earth if insufficient oxygen points
        if (onTheMoon(map) && oxygenPoints.getValue() <= zeroOxygen) {
            removeOxygenTank();
            return super.playTurn(new RocketToEarth().getAllowableActions(), map, display);
        }
        // player does nothing during the turn when the player is stunned
        else if (getPlayerStunned() && stunnedCounter.canIncrement()) {
            stunnedCounter.increment();
            return super.playTurn(new Actions(new SkipTurnAction()), map, display);
        }
        else if (!stunnedCounter.canIncrement()) {
            setPlayerStunned(false);
            stunnedCounter.increment();
        }
        actions.add(new QuitGameAction());
        return super.playTurn(actions, map, display);
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1000, "punches");
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

    /**
     * Returns a boolean which indicates if the player is on the Moon
     *
     * @param map tha current map that GamePlayer is on
     * @return true if player is on the MoonMap, false if otherwise
     */
    private boolean onTheMoon(GameMap map) {
        return map == MoonMap.getMap();
    }

    /**
     * This method increases the oxygen point by 10 points whenever the player picks up a new oxygen tank.
     * It also adds skills GameSkills.USEDOXYGENTANK to the oxygen tank item , this is to prevent the program from
     * incrementing the oxygen points with the same oxygen tank.
     */
    private void addOxygenPoints() {
        for (Item currentItem : this.getInventory()) {
            if (currentItem.hasSkill(GameSkills.OXYGENTANK) && !currentItem.hasSkill(GameSkills.USEDOXYGENTANK)) {
                oxygenPoints.increment(10);
                currentItem.addSkill(GameSkills.USEDOXYGENTANK);
            }
        }
    }

    /**
     * Decrement the player's oxygen point by one, if the player is on the Moon
     *
     * @param map the currentmap that the player is on
     */
    private void decrementOxygenPoints(GameMap map) {
        if (onTheMoon(map)) {
            oxygenPoints.decrement();
        }
    }

    /**
     * This method removes all the oxygen tank from the player's inventory.
     * This happens immediately after the player is transported back to Earth.
     * This prevents gamePlayer from transporting to Moon again with insufficient oxygen points.
     */
    private void removeOxygenTank(){
        for (Item currentItem :this.getInventory()){
            if (currentItem.hasSkill(GameSkills.OXYGENTANK)){
                this.removeItemFromInventory(currentItem);
            }
        }
    }

    /**
     * **This method is for the bonus mark feature**
     *
     * Returns the Counter of stones that the player possesses
     *
     * @return Counter of stones that the player possesses
     */
    public Counter getStoneCounter() {
        return stoneCounter;
    }

}
