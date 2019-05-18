package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an actor who is a miniboss called Yugo Maxx
 * @author Team Kimchi
 */
public class YugoMaxx extends Actor {

    private GamePlayer player;
    private boolean exoskeleton = true;

    private List<ActionFactory> actionFactories = new ArrayList<>();

    YugoMaxx(String name, GamePlayer player) {
        super(name, 'y', 6, Grunt.GRUNT_HITPOINTS/2);
        this.player = player;
        addBehaviour(new WanderBehaviour());
    }

    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            Location yugoLocation = map.locationOf(this);
            Location playerLocation = map.locationOf(player);
            if (!Distance.isAdjacent(yugoLocation, playerLocation)) {
                return action;
            }
        }

        return new AttackAction(this, player);
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions actions = new Actions();
        for (Item currentItem: otherActor.getInventory()) {
            if (currentItem.hasSkill(GameSkills.PISTOLISFULL) && exoskeleton) {
                actions.add(new SquirtingWaterAction(this, currentItem));
            }
        }

        actions.add(new AttackYugoAction(player, this));
        return actions;
    }


    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(Goon.GOON_DAMAGE, "punches");
    }

    public void removeExoskeleton() {exoskeleton = false;}

    public boolean hasExoskeleton() {return exoskeleton;}
}
