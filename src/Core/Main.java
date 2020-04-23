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
		// Forgatókönyvek listája.
		ArrayList<String> lista = new ArrayList<String>();
				lista.add("Valaszthato forgatokonyvek:"); 
				lista.add("1 \t Játék kör kezelése");			
				lista.add("2 \t Játékos stabil jégmezõre lép");
				lista.add("3 \t Játékos instabil jégmezõre lép és a mezõ átfordul");
				lista.add("4 \t Játékos lyukba lép");
				lista.add("5 \t Hóvihar következik be"); 		
				lista.add("6 \t Eszkimó használja a képességét"); 
				lista.add("7 \t Kutató használja a képességét"); 
				lista.add("8 \t Játékos kiszabadit egy tárgyat a jégbõl");
				lista.add("9 \t Játékos felvesz egy tárgyat"); 
				lista.add("10 \t Játékos eldob egy tárgyat"); 
				lista.add("11 \t Játékos használ egy tárgyat"); 
				lista.add("12 \t Játékos használ egy ásót"); 
				lista.add("13 \t Játékos eszik"); 				
				lista.add("14 \t Játékos használja a kötelet"); 
				lista.add("15 \t Játékos felveszi a búvárruhát"); 
				lista.add("16 \t Játék megnyerésének kezdeményezése (Jelzõpisztollyal)"); 
				lista.add("17 \t Játékos kézzel ássa havat");	
				lista.add("18 \t Játékos kézzel ássa havat");	
				lista.add("19 \t Játékos kézzel ássa havat");	
				lista.add("20 \t Játékos kézzel ássa havat");	
				lista.add("21 \t Játékos kézzel ássa havat");	
				lista.add("22 \t Játékos kézzel ássa havat");	
				lista.add("23 \t Játékos kézzel ássa havat");	
				lista.add("24 \t Játékos kézzel ássa havat");	
				lista.add("25 \t Játékos kézzel ássa havat");	
				lista.add("26 \t Játékos kézzel ássa havat");	
				lista.add("27 \t Játékos kézzel ássa havat");	
				lista.add("28 \t Játékos kézzel ássa havat");	
				lista.add("29 \t Játékos kézzel ássa havat");	
				lista.add("30 \t Játékos kézzel ássa havat\n");	
		
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		// Ameddig a bemenet nem egyezik a "kilep" szöveggel, addig lehetõségünk van forgatókönyvek végrehajtására.
		while(!bemenet.equals("kilep")) {
			
			for(String s : lista)
				System.out.println(s);
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
						game.getMap().getField(arg.get(0)).buildBuilding(new Igloo());
						break;
					case "tent":
						game.getMap().getField(arg.get(0)).buildBuilding(new Tent());
						break;	
					case "startblizzard":
						game.callBlizzard();
						break;
					case "setfoundgunparts":
						game.setFoundGunParts(arg.get(0));
						break;
					case "doturn":
						game.characters.get(arg.get(0)).doTurn();
						break;
					case "step":
						Character c = game.characters.get(arg.get(0));
						c.getField().moveMeTo(c, arg.get(1));;
						break;
					case "save":
						Player saver = (Player)game.characters.get(arg.get(0));
						saver.getItem(0).use(saver);
						break;
					case "skill":
						((Player)game.characters.get(arg.get(0))).doSkill();
						break;
					case "dig":
						Player digger = (Player)game.characters.get(arg.get(0));
						if(digger.getField().digSnow(1) == true)
							digger.drainStamina();
						break;
					case "freeitem":
						Player freer = (Player)game.characters.get(arg.get(0));
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
						IceField field=(IceField)game.getMap().getField(arg.get(0));
						field.setFrozenItem(item);
						break;
					case "setsnowlayers":
						Field field2=game.getMap().getField(arg.get(0));
						field2.setSnowLayers(arg.get(1));
						break;
					case "setmaxplayers":
						Field field3=game.getMap().getField(arg.get(0));
						field3.setMaxPlayers(arg.get(1));
						break;
					case "setstamina":
						Player player=(Player)game.characters.get(arg.get(0));
						player.setStamina(arg.get(1));
						break;
					case "sethealth":
						Player player2=(Player)game.characters.get(arg.get(0));
						player2.setHealth(arg.get(1));
						break;
					case "setdsuiton":
						Player player3=(Player)game.characters.get(arg.get(0));
						player3.setdSuitOn(arg.get(1)==1 ? true : false);
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
							default:
								item2 = new Grip();
								break;
						}
						Player player4=(Player)game.characters.get(arg.get(0));
						player4.resetInventory();
						player4.getInventory().add(item2);
						break;
					case "statfield":
						Field field4=game.getMap().getField(arg.get(0));
						field4.Properties();
						break;
					case "statpolarbear":
						PolarBear polarbear=(PolarBear)game.characters.get(arg.get(0));
						System.out.println(game.getMap().getFieldNumber(polarbear.getField()));
						break;
					case "statplayer":
						Player player5=(Player)game.characters.get(arg.get(0));
						for(Item i:player5.getInventory())
						{
							System.out.println(i.getClass()+"\n");
						}
						System.out.println(player5.getStamina());
						break;
					default:
						break;
				}
			}
			
		}
	}
}
