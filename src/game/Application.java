package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.World;

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor());

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"..+.#...#....#....#....",
				"....#........#....#....",
				"....#####....##.###....",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................");
        GameMap startMap = new GameMap(groundFactory, map);
		world.addMap(startMap);

        Actor player = new Player("Player", '@', 1, 100);
        world.addPlayer(player, startMap, 2, 2);

        Grunt grunt = new Grunt("Mongo", player);
        startMap.addActor(grunt, 0, 0);
        Grunt grunt2 = new Grunt("Norbert", player);
        startMap.addActor(grunt2,  10, 10);

        Q q = new Q();
        startMap.addActor(q, 5, 5);

        List<String> drMaybeLockedRoom = Arrays.asList(
                ".........###.",
                "...###.......",
                ".............",
                "........###..",
                "...#.........",
                "..........#..");
        GameMap drMaybeMap = new GameMap(groundFactory, drMaybeLockedRoom);
        world.addMap(drMaybeMap);

        DrMaybe drMaybe = new DrMaybe();
        drMaybeMap.addActor(drMaybe, 5, 5);

		world.run();
	}
}
