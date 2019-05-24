package game;

import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents the Moon GameMap
 * @author Team Kimchi
 */
public class MoonMap {
    final static int ROCKET_X = 3;
    final static int ROCKET_Y = 3;

    private static FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(), new Water());

    private static List<String> moonMap = Arrays.asList(
            "...............",
            "...............",
            ".......####....",
            "...............",
            ".......####....",
            "...............",
            "#####..........",
            "...........##..",
            "..............#",
            "#####..........",
            "...............");
    private static GameMap moon = new GameMap(groundFactory, moonMap);

    public static GameMap getMap() {
        return moon;
    }
}