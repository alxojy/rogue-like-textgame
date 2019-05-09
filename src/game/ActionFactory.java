package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Creates an Action that represents a behaviour
 */
public interface ActionFactory {
	Action getAction(Actor actor, GameMap map);
}
