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
				lista.add("17 \t J�t�kos k�zzel �ssa havat");				
		
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
//Zal�n p�rba push
	}

}
