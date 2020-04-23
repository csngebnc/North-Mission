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
import Player.*;

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

			scanner = new Scanner(new File(".\\\\Forgatokonyvek\\\\"+FORGATOKONYV_SZAMA+".txt"));
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
					case "eskimo":
						game.getMap().getField(arg.get(1)).acceptCharacter(c);
						break;
					case "initgame":
						game.Reset();
						break;
					case "initgame":
						game.Reset();
						break;
					case "initgame":
						game.Reset();
						break;
					case "initgame":
						game.Reset();
						break;
					case "initgame":
						game.Reset();
						break;
					case "initgame":
						game.Reset();
						break;
					case "initgame":
						game.Reset();
						break;
					case "initgame":
						game.Reset();
						break;
						
					case "initgame":
						game.Reset();
						break;
					default:
						break;
				}
			}
			
		}
	}
}
