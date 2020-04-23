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
	 * Kezdetleges Main oszt�ly, a forgat�k�nyvek megjelen�t�s�hez, valamint azok v�grehajt�s�hoz van r� sz�ks�g.
	 * A k�s�bbiekben �talak�t�sra ker�l, �gy, hogy a j�t�k vez�rl�s�t v�gezze.
	 */
	
	public static int FORGATOKONYV_SZAMA; // T�rolja, hogy melyik forgat�k�nyv ker�l v�grehajt�sra.
	public static String tabok = ""; // Tabul�torokat tartalmaz a megfelel� indent�l�s �rdek�ben.

	public static void main(String[] args) throws IOException {
		 // A j�t�k, amin v�grehajtjuk a forgat�k�nyveket.
		Game game = new Game();
		game.Reset();
		// Forgat�k�nyvek list�ja.
		ArrayList<String> lista = new ArrayList<String>();
				lista.add("Valaszthato forgatokonyvek:"); 
				lista.add("1 \t J�t�k k�r kezel�se");			
				lista.add("2 \t J�t�kos stabil j�gmez�re l�p");
				lista.add("3 \t J�t�kos instabil j�gmez�re l�p �s a mez� �tfordul");
				lista.add("4 \t J�t�kos lyukba l�p");
				lista.add("5 \t H�vihar k�vetkezik be"); 		
				lista.add("6 \t Eszkim� haszn�lja a k�pess�g�t"); 
				lista.add("7 \t Kutat� haszn�lja a k�pess�g�t"); 
				lista.add("8 \t J�t�kos kiszabadit egy t�rgyat a j�gb�l");
				lista.add("9 \t J�t�kos felvesz egy t�rgyat"); 
				lista.add("10 \t J�t�kos eldob egy t�rgyat"); 
				lista.add("11 \t J�t�kos haszn�l egy t�rgyat"); 
				lista.add("12 \t J�t�kos haszn�l egy �s�t"); 
				lista.add("13 \t J�t�kos eszik"); 				
				lista.add("14 \t J�t�kos haszn�lja a k�telet"); 
				lista.add("15 \t J�t�kos felveszi a b�v�rruh�t"); 
				lista.add("16 \t J�t�k megnyer�s�nek kezdem�nyez�se (Jelz�pisztollyal)"); 
				lista.add("17 \t J�t�kos k�zzel �ssa havat");	
				lista.add("18 \t J�t�kos k�zzel �ssa havat");	
				lista.add("19 \t J�t�kos k�zzel �ssa havat");	
				lista.add("20 \t J�t�kos k�zzel �ssa havat");	
				lista.add("21 \t J�t�kos k�zzel �ssa havat");	
				lista.add("22 \t J�t�kos k�zzel �ssa havat");	
				lista.add("23 \t J�t�kos k�zzel �ssa havat");	
				lista.add("24 \t J�t�kos k�zzel �ssa havat");	
				lista.add("25 \t J�t�kos k�zzel �ssa havat");	
				lista.add("26 \t J�t�kos k�zzel �ssa havat");	
				lista.add("27 \t J�t�kos k�zzel �ssa havat");	
				lista.add("28 \t J�t�kos k�zzel �ssa havat");	
				lista.add("29 \t J�t�kos k�zzel �ssa havat");	
				lista.add("30 \t J�t�kos k�zzel �ssa havat\n");	
		
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		// Ameddig a bemenet nem egyezik a "kilep" sz�veggel, addig lehet�s�g�nk van forgat�k�nyvek v�grehajt�s�ra.
		while(!bemenet.equals("kilep")) {
			
			for(String s : lista)
				System.out.println(s);
			bemenet = reader.readLine();
			
			//Beolvassa a kiv�laszott forgat�k�nyv parancsait
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
					//Eny�mek---------------------------------------
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
