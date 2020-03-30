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
	
	/*
	 * Kezdetleges Main osztály, a forgatókönyvek megjelenítéséhez, valamint azok végrehajtásához van rá szükség.
	 * A késõbbiekben átalakításra kerül, úgy, hogy a játék vezérlését végezze.
	 */
	
	public static int FORGATOKONYV_SZAMA; // Tárolja, hogy melyik forgatókönyv kerül végrehajtásra.
	public static String tabok = ""; // Tabulátorokat tartalmaz a megfelelõ indentálás érdekében.

	public static void main(String[] args) throws IOException {
		Game game = new Game(); // A játék, amin végrehajtjuk a forgatókönyveket.
		
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
				lista.add("17 \t Játékos kézzel ássa havat\n");	
		
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		// Ameddig a bemenet nem egyezik a "kilep" szöveggel, addig lehetõségünk van forgatókönyvek végrehajtására.
		while(!bemenet.equals("kilep")) {
			
			for(String s : lista)
				System.out.println(s);
			
			bemenet = reader.readLine();
			// A dokumentációban leírtaknak megfelelõen a megadott sorszámú forgatókönyvet, a megadott személy csinálta.
			switch(bemenet) {
			case "1":
				FORGATOKONYV_SZAMA = 1;
				game.doRound();
				break;
			case "2":
				FORGATOKONYV_SZAMA = 2;
				game.doRound();
				break;
			case "3":
				FORGATOKONYV_SZAMA = 3;
				game.doRound();
				break;
			case "4":
				FORGATOKONYV_SZAMA = 4;
				game.doRound();
				break;
			case "5":
				FORGATOKONYV_SZAMA = 5;
				game.doRound();
				break;
			case "6":
				FORGATOKONYV_SZAMA = 6;
				game.doRound();
				break;
			case "7":
				FORGATOKONYV_SZAMA = 7;
				game.doRound();
				break;
			case "8":
				FORGATOKONYV_SZAMA = 8;
				game.doRound();
				break;
			case "9":
				FORGATOKONYV_SZAMA = 9;
				game.doRound();
				break;
			case "10":	
				FORGATOKONYV_SZAMA = 10;
				game.doRound();
				break;
			case "11":
				FORGATOKONYV_SZAMA = 11;
				game.doRound();
				break;
			case "12":
				FORGATOKONYV_SZAMA = 12;
				game.doRound();
				break;
			case "13":
				FORGATOKONYV_SZAMA = 13;
				game.doRound();
				break;
			case "14":
				FORGATOKONYV_SZAMA = 14;
				game.doRound();
				break;	
			case "15":
				FORGATOKONYV_SZAMA = 15;
				game.doRound();
				break;
			case "16":
				FORGATOKONYV_SZAMA = 16;
				game.doRound();
				break;
			case "17":
				FORGATOKONYV_SZAMA = 17;
				game.doRound();
				break;
			default:
				break;
			}
		}
	}
}
