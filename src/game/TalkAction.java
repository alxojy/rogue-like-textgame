package game;

import edu.monash.fit2099.engine.*;

public class TalkAction extends Action {
    private Actor actor;
    private Actor subject;

    TalkAction (Actor actor,Actor subject) {
        this.actor = actor;
        this.subject = subject;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String retVal = "" ;
        for (Item item : actor.getInventory()){
            if ((item.hasSkill(GameSkills.GETROCKETBODY))) {
                retVal = "Q : Hand them over, I don’t have all day!";
            }
        }
        if (retVal == ""){
            retVal = "Q : I can give you something that will help, but I’m going to need the plans.";
        }

        return retVal;
    }

    //need to somehow update method to have different lines for talk
    @Override
    public String menuDescription(Actor actor) {
        return actor +" talks to Q";
    }

    @Override
    public String hotKey() {
        return "";
    }
    
}
