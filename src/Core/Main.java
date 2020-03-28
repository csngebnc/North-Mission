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
				lista.add("Valaszthato forgatokonyvek:"); // AMI K�SZ, AHHOZ // K�SZ
				lista.add("1 \t J�t�k k�r kezel�se");			// K�SZ
				lista.add("2 \t J�t�kos stabil j�gmez�re l�p");
				lista.add("3 \t J�t�kos instabil j�gmez�re l�p �s a mez� �tfordul");
				lista.add("4 \t J�t�kos lyukba l�p");
				lista.add("5 \t H�vihar k�vetkezik be"); 		// K�SZ
				lista.add("6 \t Eszkim� haszn�lja a k�pess�g�t"); // K�SZ
				lista.add("7 \t Kutat� haszn�lja a k�pess�g�t"); // K�SZ
				lista.add("8 \t J�t�kos kiszabadit egy t�rgyat a j�gb�l");// K�SZ
				lista.add("9 \t J�t�kos felvesz egy t�rgyat"); // K�SZ
				lista.add("10 \t J�t�kos eldob egy t�rgyat"); // K�SZ
				lista.add("11 \t J�t�kos haszn�l egy t�rgyat"); // K�SZ
				lista.add("12 \t J�t�kos haszn�l egy �s�t"); // K�SZ
				lista.add("13 \t J�t�kos eszik"); 				// K�SZ
				lista.add("14 \t J�t�kos haszn�lja a k�telet"); // K�SZ
				lista.add("15 \t J�t�kos felveszi a b�v�rruh�t"); // K�SZ
				lista.add("16 \t J�t�k megnyer�s�nek kezdem�nyez�se (Jelz�pisztollyal)"); // K�SZ
				lista.add("17 \t J�t�kos k�zzel �ssa havat\n");	// K�SZ
		
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		while(!bemenet.equals("kilep")) {
			
			for(String s : lista)
				System.out.println(s);
			
			bemenet = reader.readLine();
			
			switch(bemenet) {
			
			//Zal�n - K�r kezel�s
			case "1":
				FORGATOKONYV_SZAMA = 1;
				game.doRound();
				break;
			
			//Norbi - Stabilra l�p�s
			case "2":
				FORGATOKONYV_SZAMA = 2;
				game.doRound();
				break;
			
			//Norbi - Instabilra l�p�s
			case "3":
				FORGATOKONYV_SZAMA = 3;
				game.doRound();
				break;
			
			//Norbi - Lyukba l�p�s
			case "4":
				FORGATOKONYV_SZAMA = 4;
				game.doRound();
				break;
				
			//Dominik - h�vihar
			case "5":
				FORGATOKONYV_SZAMA = 5;
				game.doRound();
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
				FORGATOKONYV_SZAMA = 8;
				game.doRound();
				break;
			
			//Dominik - item felv�tel
			case "9":
				FORGATOKONYV_SZAMA = 9;
				game.doRound();
				break;
			
			//Dominik - t�rgy eldob�s
			case "10":	
				FORGATOKONYV_SZAMA = 10;
				game.doRound();
				break;
				
			//Bence - T�rgyhaszn�lat
			case "11":
				FORGATOKONYV_SZAMA = 11;
				game.doRound();
				break;
				
			//Dominik - �s� haszn�lat
			case "12":
				FORGATOKONYV_SZAMA = 12;
				Player p12 = new Eskimo();
				Item i12 = new Shovel();
				i12.use(p12);
				break;
				
			//Dani - �tel haszn�lat
			case "13":
				FORGATOKONYV_SZAMA = 13;
				game.doRound();
				break;
				
			//Dani - K�t�l haszn�lat
			case "14":
				FORGATOKONYV_SZAMA = 14;
				game.doRound();
				break;	
				
			//Dani - B�v�rruha felv�tele
			case "15":
				FORGATOKONYV_SZAMA = 15;
				game.doRound();
				break;
				
			//Dani - Pisztoly els�t�s
			case "16":
				FORGATOKONYV_SZAMA = 16;
				game.doRound();
				break;
		
			//Zal�n - K�zzel �s�s
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
