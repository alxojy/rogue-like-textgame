package game;

import edu.monash.fit2099.engine.*;
import game.bonusGame.BonusGameSkills;
import game.bonusGame.TeleportationPad;
import game.bonusGame.StoneTree;

public class Application {

	public static void main(String[] args) {
		GameWorld world = new GameWorld(new Display());

		//Instantiate the maps- Earth & Moon
		GameMap earth = EarthMap.getMap();
		world.addMap(earth);

		GameMap moon = MoonMap.getMap();
		world.addMap(moon);

		//Instantiate the player
		GamePlayer player = new GamePlayer("Player", '@', 1, 200);
		world.addPlayer(player, earth, 2, 12);

		//Enemies on Earth
		Grunt mrGrunt = new Grunt("Mr Grunt", player);
		earth.addActor(mrGrunt, 2, 9);

		Grunt mrsGrunt = new Grunt("Mrs Grunt", player);
		earth.addActor(mrsGrunt, 19, 7);

		Goon toughGoon = new Goon("Tough Goon", player);
		earth.addActor(toughGoon, 14, 7);

		Goon strongGoon = new Goon("Strong Goon", player);
		earth.addActor(strongGoon, 2, 1);

		Ninja ninjaHatori = new Ninja("Ninja Hatori", player);
		earth.addActor(ninjaHatori, 18, 4);

		//Miniboss on Earth
		DrMaybe drMaybe = new DrMaybe("Doctor Maybe", player);
		earth.addActor(drMaybe, 21, 1);

		//Instantiate Q
		Q q = new Q();
		earth.addActor(q,13,5);

		//Bonus game feature- stone tree entity
		StoneTree stoneTree = new StoneTree(player);
		earth.addActor(stoneTree, 5, 5);

		//Items on Earth
		Item rocketPlan = new Item("rocket plans", 'p');
		rocketPlan.addSkill(GameSkills.GETROCKETBODY);
		earth.addItem(rocketPlan, 22, 8);

		Item spaceSuit = new Item("space suit",'s');
		spaceSuit.addSkill(GameSkills.SPACETRAVELLER);
		earth.addItem(spaceSuit, 6, 1);

		//Bonus game Item
		Item waterBucket = new Item("water bucket",'⊔');
		waterBucket.addSkill(BonusGameSkills.BUCKETISEMPTY);
		earth.addItem(waterBucket,8,5);

		//Bonus game feature- Teleportation pads
        TeleportationPad teleportationPad = new TeleportationPad(player,"out of locked room");
		teleportationPad.addTeleportationPadToMap(earth,18,8);

		TeleportationPad teleportationPad2 = new TeleportationPad(player,"into locked room");
		teleportationPad2.addTeleportationPadToMap(earth,19,5);

        //Enemies on the Moon
		Grunt moonGrunt = new Grunt("Grunt", player);
		moon.addActor(moonGrunt, 2, 8);

		Goon moonGoon = new Goon("Goon", player);
		moon.addActor(moonGoon, 5, 7);

		Ninja ninjaJitsu = new Ninja("Ninja Jitsu", player);
		moon.addActor(ninjaJitsu, 6, 8);

		//Miniboss on the Moon
		YugoMaxx yugoMaxx = new YugoMaxx("Yugo Maxx", player);
		moon.addActor(yugoMaxx, 13, 1);

		//Item on the Moon
		Item waterPistol = new Item("water pistol",'¬');
		waterPistol.addSkill(GameSkills.PISTOLISEMPTY);
		moon.addItem(waterPistol,8,3);

		Item rocket = new RocketToEarth();
		moon.addItem(rocket, MoonMap.ROCKET_X, MoonMap.ROCKET_Y);

		world.run();
	}
}
