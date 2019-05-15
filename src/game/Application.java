package game;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;

public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new LockedDoor(), new RocketPad(),
				new OxygenDispenser(),new Water());

		//Earth
		List<String> earthMap = Arrays.asList(
				"...#######...........",
				"...#.....+...........",
				"...#.....#........O..",
				"...###########~~~....",
				".....................",
				".....................",
				"..........###+####...",
				"...X......#......#...",
				"..........#......#...",
				"..........########...");
		GameMap earth = new GameMap(groundFactory, earthMap);
		world.addMap(earth);

		GamePlayer player = new GamePlayer("Player", '@', 1, 200);
		world.addPlayer(player, earth, 2, 16);

		//instantiate enemies
		//Grunt mrGrunt = new Grunt("Mr Grunt", player);
		//earth.addActor(mrGrunt, 2, 9);
		Grunt mrsGrunt = new Grunt("Mrs Grunt", player);
		earth.addActor(mrsGrunt, 14, 7);
		//Goon toughGoon = new Goon("Tough Goon", player);
		//earth.addActor(toughGoon, 19, 7);
		Goon strongGoon = new Goon("Strong Goon", player);
		earth.addActor(strongGoon, 2, 7);
		//Ninja ninjaHatori = new Ninja("Ninja Hatori", player);
		//earth.addActor(ninjaHatori, 18, 3);
		Ninja ninjaJitsu = new Ninja("Ninja Jitsu", player);
		earth.addActor(ninjaJitsu, 6, 8);

		DrMaybe drMaybe = new DrMaybe("Doctor Maybe", player);
		earth.addActor(drMaybe, 6, 2);

		Q q = new Q();
		earth.addActor(q,13,5);

		Item waterPistol = new Item("Water Pistol",'¬');
		waterPistol.addSkill(GameSkills.ISEMPTY);
		earth.addItem(waterPistol,16,2);

		Item rocketPlan = new Item("rocket plans", 'p');
		rocketPlan.addSkill(GameSkills.GETROCKETBODY);
		earth.addItem(rocketPlan, 15, 8);

		//Moon
		List<String> moonMap = Arrays.asList(
				".............",
				".............",
				".......####..",
				".............",
				".............",
				".............",
				"#####........",
				"...........##",
				".............",
				"#####........");
		GameMap moon = new GameMap(groundFactory, moonMap);
		world.addMap(moon);

		Item rocket = Item.newFurniture("rocket", '^');
		moon.addItem(rocket, 3,3);



		world.run();
	}
}
