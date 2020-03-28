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
				lista.add("1 \t J�t�k k�r kezel�se");
				lista.add("2 \t J�t�kos stabil j�gmez�re l�p");
				lista.add("3 \t J�t�kos instabil j�gmez�re l�p");
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
				lista.add("17 \t J�t�kos k�zzel �ssa havat\n");	
		
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		while(!bemenet.equals("kilep")) {
			
			for(String s : lista)
				System.out.println(s);
			
			bemenet = reader.readLine();
			
			switch(bemenet) {
			
			//Zal�n - K�r kezel�s
			case "1":
				break;
			
			//Norbi - Stabilra l�p�s
			case "2":
				break;
			
			//Norbi - Instabilra l�p�s
			case "3":
				break;
			
			//Norbi - Lyukba l�p�s
			case "4":
				break;
				
			//Dominik - h�vihar
			case "5":
				game.callBlizzard();
				break;
				
			//Bence - Eszkim� k�pess�g
			case "6":
				FORGATOKONYV_SZAMA = 6;
				game.doRound();
				break;
				
			//Bence - Kutat� k�pess�g
			case "7":
				FORGATOKONYV_SZAMA = 7;
				game.doRound();
				break;
				
			//Zal�n - T�rgy kiszabadit�s
			case "8":
				break;
			
			//Dominik - item felv�tel
			case "9":
				Field f9 = new IceField();
				Player p9 = new Eskimo();
				f9.pickUpItem(p9);
				break;
			
			//Dominik - t�rgy eldob�s
			case "10":		
				//Milyen t�rgyat akarunk eldobni
				Field f10 = new IceField();
				Player p10 = new Eskimo();
				boolean loop = true;
				Scanner scanner = new Scanner(System.in);
				
				System.out.println("Milyen t�rgyat dobjunk el? (T - Eldobhat�t, P - Alkatr�szt");
				while(loop) {
					if(scanner.nextLine() == "T") {
						Item item = new Shovel();
						if(item.throwTo(f10))
							p10.drainStamina();
						loop = false;
					} else if (scanner.nextLine() == "P") {
						Item item = new Barrel();
						if(item.throwTo(f10))
							p10.drainStamina();
						loop = false;
					}
				}
				scanner.close();
				break;
				
			//Bence - T�rgyhaszn�lat
			case "11":
				FORGATOKONYV_SZAMA = 11;
				game.doRound();
				break;
				
			//Dominik - �s� haszn�lat
			case "12":
				Player p12 = new Eskimo();
				Item i12 = new Shovel();
				i12.use(p12);			
				break;
				
			//Dani - �tel haszn�lat
			case "13":
				Player p13 = new Eskimo();
				Item i13 = new Food();
				i13.use(p13);
				break;
				
			//Dani - K�t�l haszn�lat
			case "14":
				Player p14 = new Eskimo();
				Item i14 = new Rope();
				i14.use(p14);
				break;	
				
			//Dani - B�v�rruha felv�tele
			case "15":
				Player p15 = new Eskimo();
				Item i15 = new DivingSuit();
				i15.use(p15);
				break;
				
			//Dani - Pisztoly els�t�s
			case "16":
				Player p16 = new Eskimo();
				Field f16 = p16.getField();
				Game g16 = new Game();
				g16.winGame(f16);
				break;
		
			//Zal�n - K�zzel �s�s
			case "17":
				break;
				
			default:
				break;
			}
		}
	}
}
