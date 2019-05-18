package game;

import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

import java.util.Arrays;
import java.util.List;

public class EarthMap {

    final static int ROCKET_X = 2;
    final static int ROCKET_Y = 8;

    private static FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(), new RocketPad(),
            new OxygenDispenser(), new Water());

    //Earth
    private static List<String> earthMap = Arrays.asList(
            "...#######..........#####",
            "...#.....+..........#...#",
            "...#.....#........O.#.###",
            "...#########.............",
            "...~~~...................",
            "..~~~~...................",
            "..........###+####.......",
            "..........#......#.......",
            "..X.......#......#.......",
            "..........########.......");
    private static GameMap earth = new GameMap(groundFactory, earthMap);

    public static GameMap getMap() {return earth;}

}
