package Core;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Items.*;
import Map.*;
import Player.*;

public class Main {
	
	public static int FORGATOKONYV_SZAMA;
	public static String tabok = "";

	public static void main(String[] args) throws IOException {
		Game game = new Game();
		
		ArrayList<String> lista = new ArrayList<String>();
				lista.add("Valaszthato forgatokonyvek:");
				lista.add("1 \t Játék kör kezelése");
				lista.add("2 \t Játékos stabil jégmezõre lép");
				lista.add("3 \t Játékos instabil jégmezõre lép");
				lista.add("4 \t Játékos lyukba lép");
				lista.add("5 \t Hóvihar következik be"); // KÉSZ
				lista.add("6 \t Eszkimó használja a képességét"); // KÉSZ
				lista.add("7 \t Kutató használja a képességét"); // KÉSZ
				lista.add("8 \t Játékos kiszabadit egy tárgyat a jégbõl");
				lista.add("9 \t Játékos felvesz egy tárgyat"); // KÉSZ
				lista.add("10 \t Játékos eldob egy tárgyat"); // KÉSZ
				lista.add("11 \t Játékos használ egy tárgyat"); // KÉSZ
				lista.add("12 \t Játékos használ egy ásót");
				lista.add("13 \t Játékos eszik");
				lista.add("14 \t Játékos használja a kötelet");
				lista.add("15 \t Játékos felveszi a búvárruhát");
				lista.add("16 \t Játék megnyerésének kezdeményezése (Jelzõpisztollyal)");
				lista.add("17 \t Játékos kézzel ássa havat\n");	
		
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		while(!bemenet.equals("kilep")) {
			
			for(String s : lista)
				System.out.println(s);
			
			bemenet = reader.readLine();
			
			switch(bemenet) {
			
			//Zalán - Kör kezelés
			case "1":
				break;
			
			//Norbi - Stabilra lépés
			case "2":
				break;
			
			//Norbi - Instabilra lépés
			case "3":
				break;
			
			//Norbi - Lyukba lépés
			case "4":
				break;
				
			//Dominik - hóvihar
			case "5":
				FORGATOKONYV_SZAMA = 5;
				game.doRound();
				break;
				
			//Bence - Eszkimó képesség
			case "6":
				FORGATOKONYV_SZAMA = 6;
				game.doRound();
				break;
				
			//Bence - Kutató képesség
			case "7":
				FORGATOKONYV_SZAMA = 7;
				game.doRound();
				break;
				
			//Zalán - Tárgy kiszabaditás
			case "8":
				break;
			
			//Dominik - item felvétel
			case "9":
				FORGATOKONYV_SZAMA = 9;
				game.doRound();
				break;
			
			//Dominik - tárgy eldobás
			case "10":	
				FORGATOKONYV_SZAMA = 10;
				game.doRound();
				break;
				
			//Bence - Tárgyhasználat
			case "11":
				FORGATOKONYV_SZAMA = 11;
				game.doRound();
				break;
				
			//Dominik - Ásó használat
			case "12":
				Player p12 = new Eskimo();
				Item i12 = new Shovel();
				i12.use(p12);			
				break;
				
			//Dani - Étel használat
			case "13":
				Player p13 = new Eskimo();
				Item i13 = new Food();
				i13.use(p13);
				break;
				
			//Dani - Kötél használat
			case "14":
				Player p14 = new Eskimo();
				Item i14 = new Rope();
				i14.use(p14);
				break;	
				
			//Dani - Búvárruha felvétele
			case "15":
				Player p15 = new Eskimo();
				Item i15 = new DivingSuit();
				i15.use(p15);
				break;
				
			//Dani - Pisztoly elsütés
			case "16":
				Player p16 = new Eskimo();
				Field f16 = p16.getField();
				Game g16 = new Game();
				g16.winGame(f16);
				break;
		
			//Zalán - Kézzel ásás
			case "17":
				break;
				
			default:
				break;
			}
		}
	}
}
