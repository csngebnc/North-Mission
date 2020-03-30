package Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Scanner;

import Core.Main;
import Items.Barrel;
import Items.Item;
import Items.Shovel;
import Player.Eskimo;
import Player.Player;


public abstract class Field
{
	protected int snowLayers;
	protected int maxplayers;
	protected ArrayList<Player> players;
	protected Field neighbours;
	private boolean iglooOnField;
	
	// H�vihar gener�l�sa a mez�n.
	public void generateBlizzard() 
	{
		System.out.println(Main.tabok+"->[Field].generateBlizzard()");
		Main.tabok+="\t";
		
		//Iglu eld�nt�se input alapj�n
		boolean loop = true;
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.print(Main.tabok+"Legyen a mez�n iglu? (Y - IGEN, N - NEM)\n"+Main.tabok);
		
		while(loop) {
			try {
				bemenet = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(bemenet.equals("Y")) {
				iglooOnField = true;
				loop = false;
			} else if (bemenet.equals("N")) {
				iglooOnField = false;
				loop = false;
			}
		}
		
		//Nincs iglu a mez�n -> Rajta lev� j�t�kosok HP-ja 1-el cs�kken
		if(iglooOnField == false) {
			Player p = new Eskimo();
			p.alterHealth(-1);
		}
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Field].generateBlizzard()");
	}
	
	//J�t�kos elmozd�t�sa egy mez�re az adott mez�r�l egy kapott ir�nyba.
	public void moveMeTo(Player p, Direction dir) 
	{
		System.out.println(Main.tabok+"->[Field].moveMeTo(Player p, Direction dir)");
		Main.tabok+="\t";
		//Itt k�s�bb a neighbours attrib�tumot fogja haszn�lni.
		Field neighbours;
		if(Main.FORGATOKONYV_SZAMA==2 || Main.FORGATOKONYV_SZAMA==14) neighbours = new IceField();
		else if(Main.FORGATOKONYV_SZAMA==3) neighbours = new UnstableField();
		
		else neighbours = new Hole();
		
		neighbours.acceptPlayer(p);
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Field].moveMeTo(Player p, Direction dir)");
		
	}
	
	// Sarkkutat� j�t�kos h�vhatja a mez�t, ezzel felvedve mekkora a teherb�r�sa.
	public void revealLimit() 
	{
		System.out.println(Main.tabok+"->[Field].revealLimit()");
		System.out.println(Main.tabok+"<-[Field].revealLimit()");
	}
	
	// A lesz�rmazottak maguk val�s�tj�k meg.
	public abstract void acceptPlayer(Player p);
	
	// A lesz�rmazottak maguk val�s�tj�k meg.
	public void acceptItem(Item i) {	}
	
	
	//Alapimplement�ci�ja nem ad vissza t�rgyat..
	public Item pickUpItem(Player p) 
	{
		return null;
	}
	
	// Mez�n t�rt�n� �s�s, param�terk�nt kapott �rt�kkel cs�kkenti a h�r�teget, ha van h�.
	// Jelen esetben felt�telezz�k, hogy van elt�vol�that� h�.
	public boolean digSnow(int amount) 
	{
		System.out.println(Main.tabok+"->[Field].digSnow(int amount)");
		System.out.println(Main.tabok+"<-[Field].digSnow(int amount)");
		
		//Lek�rdez�s: volt-e eltakar�that�.
		
		return true;
	}

	
	// T�rgy kiszabad�t�sa j�gb�l. K�s�bb a mez�n tal�lhat� t�rgyak k�z� ker�l a kiszabad�tott t�rgy.
	public void removeItemFromIce(Player p) 
	{
		System.out.println(Main.tabok+"->[Field].removeItemFromIce(Player p) ");
		System.out.println(Main.tabok+"<-[Field].removeItemFromIce(Player p) ");
	}
	
	// J�t�kos ment�se adott ir�nyba.
	public boolean savePerson(Direction dir) 
	{
		//Itt k�s�bb az f2players helyett a players attrib�tum lesz haszn�lva.
		ArrayList<Player>f2players = new ArrayList<Player>();
		f2players.add(new Eskimo());
		f2players.add(new Eskimo());
		f2players.add(new Eskimo());
		
		if(f2players.size()>0)
		{
			System.out.println(Main.tabok+"->[Field].savePerson()");
			System.out.println(Main.tabok+"Kit?");
			for(int i=0; i<f2players.size();i++)
			{
				System.out.println(Main.tabok+i+": Jatekos"+i);
			}
			
			Scanner myObj = new Scanner(System.in);
			String name = myObj.nextLine();
			
			//Itt kesobb a kivalasztott jatekos lesz p2 erteke
			Player p2 = new Eskimo();
			moveMeTo(p2,dir);
			return true;
		}
		return false;
	}
	
	
	// Iglu elhelyez�se a mez�n.
	public boolean buildIgloo() 
	{
		return true;
	}

	// Visszaadja a szomsz�dot adott ir�nyb�l. V�ltozik m�g, jelenleg csak a forgat�k�nyvh�z lett be�ll�tva..
	public Field getNeighbours()
	{
		System.out.println("Field.getNeighbours");
		return neighbours;
	}
	
	//Visszaadja a mez�n tal�lhat� j�t�kosokat.
	public ArrayList<Player> getPlayers()
	{
		System.out.println(Main.tabok+"->[Field].getPlayer()");
		System.out.println(Main.tabok+"<-[Field].getPlayer()");
		return players;
	}
}
