package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

import java.util.Random;

public class SquirtingWaterAction extends Action {

    YugoMaxx yugoMaxx;
    Item waterPistol;
    Random random = new Random();

    SquirtingWaterAction(YugoMaxx subject, Item waterPistol) {
        yugoMaxx = subject;
        this.waterPistol = waterPistol;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String returnStatement
                ;
        if (random.nextDouble() <= 0.70) {
            yugoMaxx.removeExoskeleton();
            returnStatement = actor + " successfully squirted water " + yugoMaxx + "\n" +
                    yugoMaxx + "'s exoskeleton has been removed.";
        }
        else {
            returnStatement = actor + " missed " + yugoMaxx;
        }

        waterPistol.removeSkill(GameSkills.ISFULL);
        waterPistol.addSkill(GameSkills.ISEMPTY);
        return returnStatement;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " squirts water at " + yugoMaxx;
    }

    @Override
    public String hotKey() {
        return "";
    }
}
