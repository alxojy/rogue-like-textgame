package game;

import edu.monash.fit2099.engine.*;

// DO NOT CARE ABOUT THIS CLASS TQVM
public class GameWorld extends World {

    Display display;
    Actor actor;

    public GameWorld(Display display) {
        super(display);
        this.display = display;
    }

    public void run() {
        super.run();
        while (stillRunning()) {
            //processGround(newGameMap);
        }
    }

    protected void processActorTurn(Actor actor) {
        this.actor = actor;
        super.processActorTurn(actor);
    }

    protected void processGround(NewGameMap map) {
        Range xs = map.getMapWidth();
        Range ys = map.getMapHeight();

        for (int x : xs) {
            for (int y : ys) {
                Action groundAction = ((GameGround) map.at(x, y).getGround()).getGroundAction();
                if (groundAction != null) {
                    String result = groundAction.execute(actor, map);
                    display.println(result);
                }
            }
        }
    }
}
