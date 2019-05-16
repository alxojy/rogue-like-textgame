package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import java.util.LinkedList;
import java.util.Queue;

public class ActionScheduler {

    private Queue<Action> ActionQueue = new LinkedList<>();

    public boolean isEmpty() {return ActionQueue.size() == 0;}

    public void addActionToSchedule(Action action) {
        ActionQueue.add(action);
    }

    public void doActionScheduled(Actor actor, GameMap map) {
        //it works but prints at the wrong place :(
        System.out.println(ActionQueue.remove().execute(actor, map));
    }

}
