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
				"....#....#.............",
				"....#....+.............",
				"....######.............",
				".......................",
				".......................",
				".............######....",
				".............+....#....",
				"...X.........#....#....",
				".............######....");
        GameMap startMap = new GameMap(groundFactory, map);
		world.addMap(startMap);

        Actor player = new GamePlayer("Player", '@', 1, 100);
        world.addPlayer(player, startMap, 8, 2);

        Grunt grunt = new Grunt("Grunt", player);
        startMap.addActor(grunt, 0, 0);
		Goon goon = new Goon("Goon", player);
		startMap.addActor(goon, 1, 5);
        Ninja ninja1 = new Ninja("Ninja", player);
        startMap.addActor(ninja1, 2, 4);

        DrMaybe drMaybe = new DrMaybe();
		startMap.addActor(drMaybe, 2, 7);
        //startMap.addActor(drMaybe, 6, 3);

		Q q = new Q();
		startMap.addActor(q,3,8);

		Item rocketPlan = new Item("rocket plans", 'P');
		rocketPlan.addSkill(GameSkills.GETROCKETBODY);
		//startMap.addItem(rocketPlan, 15, 8);
		startMap.addItem(rocketPlan, 3, 8);

		world.run();
	}
}
