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
				"....#######............",
				"....#.....+............",
				"....#.....#............",
				"....#############......",
				".......................",
				".......................",
				"...........###+####....",
				"...X.......#......#....",
				"...........#......#....",
				"...........########....");
        GameMap startMap = new GameMap(groundFactory, map);
		world.addMap(startMap);

        Actor player = new GamePlayer("Player", '@', 1, 100);
        world.addPlayer(player, startMap, 2, 16);

        Grunt mrGrunt = new Grunt("Mr Grunt", player);
        startMap.addActor(mrGrunt, 2, 0);
		Grunt mrsGrunt = new Grunt("Mrs Grunt", player);
		startMap.addActor(mrsGrunt, 14, 8);
		Goon toughGoon = new Goon("Tough Goon", player);
		startMap.addActor(toughGoon, 19, 5);
        Goon strongGoon = new Goon("Strong Goon", player);
        startMap.addActor(strongGoon, 2, 4);
        Ninja ninjaHatori = new Ninja("Ninja Hatori", player);
        startMap.addActor(ninjaHatori, 18, 1);
        Ninja ninjaJitsu = new Ninja("Ninja Jitsu", player);
        startMap.addActor(ninjaJitsu, 6, 8);

        DrMaybe drMaybe = new DrMaybe();
        startMap.addActor(drMaybe, 6, 3);

		Q q = new Q();
		startMap.addActor(q,13,6);

		Item rocketPlan = new Item("rocket plans", 'p');
		rocketPlan.addSkill(GameSkills.GETROCKETBODY);
		startMap.addItem(rocketPlan, 15, 8);

		world.run();
	}
}
