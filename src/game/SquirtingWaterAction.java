package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

import java.util.Random;

public class SquirtingWaterAction extends Action {

    YugoMexx yugoMexx;
    Item waterPistol;
    Random random = new Random();

    SquirtingWaterAction(YugoMexx subject, Item waterPistol) {
        yugoMexx = subject;
        this.waterPistol = waterPistol;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String returnStatement
                ;
        if (random.nextDouble() <= 0.70) {
            yugoMexx.removeExoskeleton();
            returnStatement = actor + " successfully squirted water " + yugoMexx + "\n" +
                    yugoMexx + "'s exoskeleton has been removed.";
        }
        else {
            returnStatement = actor + " missed " + yugoMexx;
        }

        waterPistol.removeSkill(GameSkills.ISFULL);
        waterPistol.addSkill(GameSkills.ISEMPTY);
        return returnStatement;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " squirts water at " + yugoMexx;
    }

    @Override
    public String hotKey() {
        return "";
    }
}
