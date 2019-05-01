package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(), new RocketPad());

		List<String> map = Arrays.asList(
				".......................",
				"....######.............",
				"....#....#.........^...",
				"....#....+.............",
				"....######.............",
				".......................",
				".......................",
				".............######....",
				".............+....#....",
				".............#....#....",
				".............######....");
        GameMap startMap = new GameMap(groundFactory, map);
		world.addMap(startMap);

        Actor player = new GamePlayer("Player", '@', 1, 100);
        world.addPlayer(player, startMap, 8, 2);

        Grunt grunt = new Grunt("Mongo", player);
        startMap.addActor(grunt, 0, 0);
        //Grunt grunt2 = new Grunt("Norbert", player);
        //startMap.addActor(grunt2,  10, 10);
		//Goon goon = new Goon("Mongo", player);
		//startMap.addActor(goon, 0, 0);
        Ninja ninja1 = new Ninja("Ninjz", player);
        startMap.addActor(ninja1, 2, 4);

        DrMaybe drMaybe = new DrMaybe();
        startMap.addActor(drMaybe, 6, 3);

		Item rocketPlan = new Item("Rocket Plan", 'P');
		startMap.addItem(rocketPlan, 15, 8);

		world.run();
	}
}
