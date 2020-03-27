package Core;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Items.*;
import Map.*;
import Player.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Game game = new Game();
		
		ArrayList<String> lista = new ArrayList<String>();
				lista.add("Valaszthato forgatokonyvek:");
				lista.add("1 \t Játék kör kezelése");
				lista.add("2 \t Játékos stabil jégmezõre lép");
				lista.add("3 \t Játékos instabil jégmezõre lép");
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
		
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		while(!bemenet.equals("kilep")) {
			
			for(String s : lista)
				System.out.println(s);
			
			bemenet = reader.readLine();
			
			switch(bemenet) {
			case "1":
				System.out.println("forgatokony: 1");
				break;
			
			}
	        
		}
//Zalï¿½n pï¿½rba push
	}

}
