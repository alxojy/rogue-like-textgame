package game;

import edu.monash.fit2099.engine.*;

public class Application {

	public static void main(String[] args) {
		GameWorld world = new GameWorld(new Display());

		GameMap earth = EarthMap.getMap();
		world.addMap(earth);

		GamePlayer player = new GamePlayer("Player", '@', 1, 1);
		world.addPlayer(player, earth, 2, 12);
        Item rocketEngine = Item.newInventoryItem("rocket engine", 'e');
        rocketEngine.addSkill(GameSkills.BUILDROCKETBASE);
        player.addItemToInventory(rocketEngine);
        Item rocketBody = Item.newInventoryItem("rocket body", 'B');
        rocketBody.addSkill(GameSkills.BUILDROCKETTOP);
        player.addItemToInventory(rocketBody);

		//instantiate enemies
		Grunt mrGrunt = new Grunt("Mr Grunt", player);
		earth.addActor(mrGrunt, 2, 9);
		Grunt mrsGrunt = new Grunt("Mrs Grunt", player);
		earth.addActor(mrsGrunt, 14, 7);
		Goon toughGoon = new Goon("Tough Goon", player);
		earth.addActor(toughGoon, 19, 7);
		//Goon strongGoon = new Goon("Strong Goon", player);
		//earth.addActor(strongGoon, 2, 7);
		Ninja ninjaHatori = new Ninja("Ninja Hatori", player);
		earth.addActor(ninjaHatori, 18, 3);

		DrMaybe drMaybe = new DrMaybe("Doctor Maybe", player);
		earth.addActor(drMaybe, 6, 2);

		Q q = new Q();
		earth.addActor(q,13,5);

		OxygenDispenserScheduler oxygenDispenserScheduler = new OxygenDispenserScheduler(player);
		earth.addActor(oxygenDispenserScheduler, 18, 2);

		Item rocketPlan = new Item("rocket plans", 'p');
		rocketPlan.addSkill(GameSkills.GETROCKETBODY);
		earth.addItem(rocketPlan, 15, 8);

		//Item spaceSuit = new Item("space suit", 's');
		Item spaceSuit = Item.newInventoryItem("space suit",'s');
		spaceSuit.addSkill(GameSkills.SPACETRAVELLER);
		earth.addItem(spaceSuit, 22, 1);

//		here
		player.addItemToInventory(spaceSuit);





		//moon
		GameMap moon = MoonMap.getMap();
		world.addMap(moon);

		Grunt moonGrunt = new Grunt("Grunt", player);
		moon.addActor(moonGrunt, 2, 8);

		Goon moonGoon = new Goon("Goon", player);
		moon.addActor(moonGoon, 5, 7);

		Ninja ninjaJitsu = new Ninja("Ninja Jitsu", player);
		moon.addActor(ninjaJitsu, 6, 8);

		YugoMaxx yugoMaxx = new YugoMaxx("Yugo Maxx", player);
		moon.addActor(yugoMaxx, 13, 1);

		Item sleepingActor = new Item("Sleeping " + yugoMaxx, '%');
		sleepingActor.addSkill(GameSkills.YUGOBODY);
		earth.locationOf(player).addItem(sleepingActor);

		Item rocket = Item.newFurniture("rocket", '^');
		rocket.getAllowableActions().add(new MoveActorAction(earth.at(EarthMap.ROCKET_X, EarthMap.ROCKET_Y), "to Earth"));
		moon.addItem(rocket, MoonMap.ROCKET_X, MoonMap.ROCKET_Y);

		Item waterPistol = new Item("water pistol",'¬');
		waterPistol.addSkill(GameSkills.PISTOLISEMPTY);
		moon.addItem(waterPistol,8,3);

		world.run();
	}
}
