package game;

import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

import java.util.Arrays;
import java.util.List;

public class EarthMap {

    public final static int ROCKET_X = 3;
    public final static int ROCKET_Y = 9;

    FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(), new RocketPad(),
            new OxygenDispenser(),new Water());

    //Earth
    List<String> earthMap = Arrays.asList(
            "...#######...........",
            "...#.....+...........",
            "...#.....#...........",
            "...###########~~~....",
            ".....................",
            ".....................",
            "..........###+####...",
            "...X......#......#...",
            "..........#......#...",
            "..........########...");
    GameMap earth = new GameMap(groundFactory, earthMap);

    public GameMap getEarth() {return earth;}






}
