package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

import java.util.Random;

public class SquirtingWaterAction extends Action {

    private YugoMaxx yugoMaxx;
    private Item waterPistol;
    private Random random = new Random();

    SquirtingWaterAction(YugoMaxx subject, Item waterPistol) {
        yugoMaxx = subject;
        this.waterPistol = waterPistol;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        waterPistol.removeSkill(GameSkills.PISTOLISFULL);
        waterPistol.addSkill(GameSkills.PISTOLISEMPTY);

        if (random.nextDouble() <= 0.70) {
            yugoMaxx.removeExoskeleton();
            return actor + " successfully squirted water at" + yugoMaxx + "\n" +
                    yugoMaxx + "'s exoskeleton has been removed.";
        }
        else {
            return actor + " missed " + yugoMaxx;
        }
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
