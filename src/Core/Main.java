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
	 * Kezdetleges Main oszt�ly, a forgat�k�nyvek megjelen�t�s�hez, valamint azok v�grehajt�s�hoz van r� sz�ks�g.
	 * A k�s�bbiekben �talak�t�sra ker�l, �gy, hogy a j�t�k vez�rl�s�t v�gezze.
	 */
	
	public static int FORGATOKONYV_SZAMA; // T�rolja, hogy melyik forgat�k�nyv ker�l v�grehajt�sra.
	public static String tabok = ""; // Tabul�torokat tartalmaz a megfelel� indent�l�s �rdek�ben.

	public static void main(String[] args) throws IOException {
		Game game = new Game(); // A j�t�k, amin v�grehajtjuk a forgat�k�nyveket.
		
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

			scanner = new Scanner(new File(".\\\\Forgatokonyvek\\\\"+FORGATOKONYV_SZAMA+".txt"));
			while (scanner.hasNextLine()) {
				commands.add(scanner.nextLine());
			}
			scanner.close();
			
			//Lefutnak a parancsok
			for(String s:commands)
			{
				switch(s.split(" ")[0]) {
					case "polarbear":
						int jegtablasorszam1=Integer.parseInt(s.split(" ")[1]);
						//Some K�d
						//Some K�d
						//Some K�d
						break;
					case "eskimo":
						String nev1= s.split(" ")[1];
						int jegtablasorszam2=Integer.parseInt(s.split(" ")[2]);
						//Some K�d
						//Some K�d
						//Some K�d		
						break;
					case "scientist":
						String nev2= s.split(" ")[1];
						int jegtablasorszam3=Integer.parseInt(s.split(" ")[2]);
						//Some K�d
						//Some K�d
						//Some K�d				
						break;
					case "step":
						int jegtablasorszam4=Integer.parseInt(s.split(" ")[1]);
						//Some K�d
						//Some K�d
						//Some K�d
						break;
					case "setneighbours":
						
						
						break;
					case "createmap":
						
						
						
						break;
					case "setitem":
						String item=s.split(" ")[1];
						//Some K�d
						//Some K�d
						//Some K�d
						break;
					case "setmaxplayers":
						int jegtablasorszam5=Integer.parseInt(s.split(" ")[1]);
						int teherbiras=Integer.parseInt(s.split(" ")[2]);
						//Some K�d
						//Some K�d
						//Some K�d
						break;
					case "setsnow":
						int jegtablasorszam6=Integer.parseInt(s.split(" ")[1]);
						int homennyiseg=Integer.parseInt(s.split(" ")[2]);
						//Some K�d
						//Some K�d
						//Some K�d
						break;
					case "doblizzard":
						
						break;
					case "statplayer":
						int sorszam=Integer.parseInt(s.split(" ")[1]);
						//Some K�d
						//Some K�d
						//Some K�d
						break;
					case "statfield":
						int sorszam2=Integer.parseInt(s.split(" ")[1]);
						//Some K�d
						//Some K�d
						//Some K�d
						break;
				}
			}
			
		}
	}
}
