package game;

import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;

import java.util.Arrays;
import java.util.List;

public class MoonMap {
    public final static int ROCKET_X = 2;
    public final static int ROCKET_Y = 1;


    FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(), new RocketPad(),
            new OxygenDispenser(),new Water());

    List<String> moonMap = Arrays.asList(
            ".............",
            "..X..........",
            ".......####..",
            ".............",
            ".............",
            ".............",
            "#####........",
            "...........##",
            ".............",
            "#####........");
    GameMap moon = new GameMap(groundFactory, moonMap);

    public GameMap getMoon() {return moon;}

}
