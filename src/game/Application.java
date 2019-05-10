package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(), new RocketPad());

		List<String> map = Arrays.asList(
				"...#######...........",
				"...#.....+...........",
				"...#.....#...........",
				"...#############.....",
				".....................",
				".....................",
				"..........###+####...",
				"...X......#......#...",
				"..........#......#...",
				"..........########...");
        GameMap startMap = new GameMap(groundFactory, map);
		world.addMap(startMap);

        GamePlayer player = new GamePlayer("Player", '@', 1, 200);
        world.addPlayer(player, startMap, 2, 16);

        //instantiate enemies
        Grunt mrGrunt = new Grunt("Mr Grunt", player);
        startMap.addActor(mrGrunt, 2, 9);
		Grunt mrsGrunt = new Grunt("Mrs Grunt", player);
		startMap.addActor(mrsGrunt, 14, 7);
		Goon toughGoon = new Goon("Tough Goon", player);
		startMap.addActor(toughGoon, 19, 7);
        Goon strongGoon = new Goon("Strong Goon", player);
        startMap.addActor(strongGoon, 2, 7);
        Ninja ninjaHatori = new Ninja("Ninja Hatori", player);
        startMap.addActor(ninjaHatori, 18, 3);
        Ninja ninjaJitsu = new Ninja("Ninja Jitsu", player);
        startMap.addActor(ninjaJitsu, 6, 8);

        DrMaybe drMaybe = new DrMaybe("Doctor Maybe", player);
        startMap.addActor(drMaybe, 6, 2);

		Q q = new Q();
		startMap.addActor(q,13,5);

		Item rocketPlan = new Item("rocket plans", 'p');
		rocketPlan.addSkill(GameSkills.GETROCKETBODY);
		startMap.addItem(rocketPlan, 15, 8);

		world.run();
	}
}
