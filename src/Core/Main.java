package Core;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Items.*;
import Map.*;
import Map.Buildings.Igloo;
import Map.Buildings.Tent;
import Player.*;
import Player.Character;

public class Main {
	
	/*
	 * Kezdetleges Main osztály, a forgatókönyvek megjelenítéséhez, valamint azok végrehajtásához van rá szükség.
	 * A késõbbiekben átalakításra kerül, úgy, hogy a játék vezérlését végezze.
	 */
	
	public static int FORGATOKONYV_SZAMA; // Tárolja, hogy melyik forgatókönyv kerül végrehajtásra.
	public static String tabok = ""; // Tabulátorokat tartalmaz a megfelelõ indentálás érdekében.

	public static void main(String[] args) throws IOException {
		 // A játék, amin végrehajtjuk a forgatókönyveket.
		Game game = new Game();
		game.Reset();
		
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		// Ameddig a bemenet nem egyezik a "kilep" szöveggel, addig lehetõségünk van forgatókönyvek végrehajtására.
		while(!bemenet.equals("kilep")) {
			
			bemenet = reader.readLine();
			
			//Beolvassa a kiválaszott forgatókönyv parancsait
			Scanner scanner;
			ArrayList<String> commands=new ArrayList<String>();
			FORGATOKONYV_SZAMA=Integer.parseInt(bemenet);

			scanner = new Scanner(new File(".\\\\\\\\src\\\\Forgatokonyvek\\\\"+FORGATOKONYV_SZAMA+".txt"));
			while (scanner.hasNextLine()) {
				commands.add(scanner.nextLine());
			}
			scanner.close();
			
			//Lefutnak a parancsok
			for(String s:commands)
			{
				String[] splitUp = s.split(" ");
				ArrayList<String> argt = new ArrayList<String>();
				for(String st : splitUp) 
				{
					argt.add(st);
				}
				String command = argt.get(0);
				argt.remove(0);
				
				ArrayList<Integer> arg = new ArrayList<Integer>();
				
				for(String st : argt) {
					arg.add(Integer.parseInt(st));
				}
				
				switch(command) {
					case "initgame":
						game.Reset();
						break;
					case "igloo":
						game.getMap().getField(arg.get(0)-1).buildBuilding(new Igloo());
						break;
					case "tent":
						game.getMap().getField(arg.get(0)-1).buildBuilding(new Tent());
						break;	
					case "polarbear":
						game.addCharacter(new PolarBear(), arg.get(0)-1);
						break;	
					case "eskimo":
						game.addCharacter(new Eskimo(), arg.get(0)-1);
						break;	
					case "startblizzard":
						game.callBlizzard();
						break;
					case "setfoundgunparts":
						game.setFoundGunParts(arg.get(0)-1);
						break;
					case "doturn":
						game.characters.get(arg.get(0)-1).doTurn();
						break;
					case "step":
						Character c = game.characters.get(arg.get(0)-1);
						c.getField().moveMeTo(c, arg.get(1)-1);
						break;
					case "save":
						Player saver = (Player)game.characters.get(arg.get(0)-1);
						Field safeField = saver.getField();
						if(safeField.savePerson(arg.get(1)))
							saver.drainStamina();
						break;
					case "skill":
						((Player)game.characters.get(arg.get(0)-1)).doSkill();
						break;
					case "dig":
						Player digger = (Player)game.characters.get(arg.get(0)-1);
						if(digger.getField().digSnow(1) == true)
							digger.drainStamina();
						break;
					case "freeitem":
						Player freer = (Player)game.characters.get(arg.get(0)-1);
						freer.getField().removeItemFromIce(freer);
						break;
					case "wingame":
						Game.winGame(game.characters.get(0).getField());
					//Enyémek---------------------------------------
					case "getcurrentplayer":
						Player currentplayer = (Player) game.getCharacters().get(game.getRoundNum() % game.getCharacters().size());
						System.out.println(currentplayer.getName());
						break;
					case "setfrozenitem":
						Item item;
						switch(argt.get(1)) {
							case "rope":
								item = new Rope();
								break;
							case "food":
								item = new Food();
								break;
							case "divingsuit":
								item = new DivingSuit();
								break;
							case "shovel":
								item = new Shovel();
								break;
							case "limitedshovel":
								item = new LimitedShovel();
								break;
							case "roket":
								item = new Rocket();
								break;
							case "barrel":
								item = new Barrel();
								break;
							case "grip":
								item=new Grip();
								break;
							default:
								item=new Grip();
								break;
						}
						IceField field=(IceField)game.getMap().getField(arg.get(0)-1);
						field.setFrozenItem(item);
						break;
					case "setsnowlayers":
						Field field2=game.getMap().getField(arg.get(0)-1);
						field2.setSnowLayers(arg.get(1));
						break;
					case "setmaxplayers":
						Field field3=game.getMap().getField(arg.get(0)-1);
						field3.setMaxPlayers(arg.get(1));
						break;
					case "setstamina":
						Player player=(Player)game.characters.get(arg.get(0)-1);
						player.setStamina(arg.get(1));
						break;
					case "sethealth":
						Player player2=(Player)game.characters.get(arg.get(0)-1);
						player2.setHealth(arg.get(1));
						break;
					case "setdsuiton":
						Player player3=(Player)game.characters.get(arg.get(0)-1);
						player3.setdSuitOn(arg.get(1)==0 ? false : true);
						break;
					case "giveitem":
						Item item2;
						switch(argt.get(1)) {
							case "rope":
								item2 = new Rope();
								break;
							case "food":
								item2 = new Food();
								break;
							case "divingsuit":
								item2 = new DivingSuit();
								break;
							case "shovel":
								item2 = new Shovel();
								break;
							case "limitedshovel":
								item2 = new LimitedShovel();
								break;
							case "roket":
								item2 = new Rocket();
								break;
							case "barrel":
								item2 = new Barrel();
								break;
							case "grip":
								item2 = new Grip();
								break;
							case "tent":
								item2 = new Tent();
								break;
							default:
								item2 = null;
								break;
						}
						Player player4=(Player)game.characters.get(arg.get(0)-1);
						player4.resetInventory();
						if(item2 != null)
							player4.getInventory().add(item2);
						break;
					case "statfield":
						Field statfield=game.getMap().getField(arg.get(0)-1);
						statfield.Properties();
						break;
					case "statfoundgunparts":
						System.out.println("Found gun parts: " + game.getFoundGunparts());
						break;
					case "statpolarbear":
						PolarBear polarbear=(PolarBear)game.characters.get(arg.get(0)-1);
						System.out.println("Field: " + game.getMap().getFieldNumber(polarbear.getField()));
						break;
					case "statplayer":
						Player statplayer=(Player)game.characters.get(arg.get(0)-1);
						System.out.println("Field: " + game.getMap().getFieldNumber(statplayer.getField()));
						statplayer.Properties();
						break;
					case "useitem":
						Player user=(Player)game.characters.get(arg.get(0)-1);
						user.getInventory().get(arg.get(1)-1).use(user);
						break;
					case "unequipsuit":
						Player unequipper=(Player)game.characters.get(arg.get(0)-1);
						unequipper.changeSuit(null);
						break;
					case "addgunparttofield":
						((IceField)game.getMap().getField(arg.get(0)-1)).acceptItem(new Barrel());
						break;
					case "pickupitem":
						Player pickupper = (Player)game.characters.get(arg.get(0)-1);
						((IceField)game.getMap().getField(arg.get(1)-1)).pickUpItem(pickupper);
						break;
					default:
						break;
				}
			}
			
		}
	}
}
