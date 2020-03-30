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
	
	// Hóvihar generálása a mezõn.
	public void generateBlizzard() 
	{
		System.out.println(Main.tabok+"->[Field].generateBlizzard()");
		Main.tabok+="\t";
		
		//Iglu eldï¿½ntï¿½se input alapjï¿½n
		boolean loop = true;
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.print(Main.tabok+"Legyen a mezï¿½n iglu? (Y - IGEN, N - NEM)\n"+Main.tabok);
		
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
		
		//Nincs iglu a mezï¿½n -> Rajta levï¿½ jï¿½tï¿½kosok HP-ja 1-el csï¿½kken
		if(iglooOnField == false) {
			Player p = new Eskimo();
			p.alterHealth(-1);
		}
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Field].generateBlizzard()");
	}
	
	//Játékos elmozdítása egy mezõre az adott mezõrõl egy kapott irányba.
	public void moveMeTo(Player p, Direction dir) 
	{
		System.out.println(Main.tabok+"->[Field].moveMeTo(Player p, Direction dir)");
		Main.tabok+="\t";
		//Itt kï¿½sï¿½bb a neighbours attribï¿½tumot fogja hasznï¿½lni.
		Field neighbours;
		if(Main.FORGATOKONYV_SZAMA==2 || Main.FORGATOKONYV_SZAMA==14) neighbours = new IceField();
		else if(Main.FORGATOKONYV_SZAMA==3) neighbours = new UnstableField();
		
		else neighbours = new Hole();
		
		neighbours.acceptPlayer(p);
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Field].moveMeTo(Player p, Direction dir)");
		
	}
	
	// Sarkkutató játékos hívhatja a mezõt, ezzel felvedve mekkora a teherbírása.
	public void revealLimit() 
	{
		System.out.println(Main.tabok+"->[Field].revealLimit()");
		System.out.println(Main.tabok+"<-[Field].revealLimit()");
	}
	
	// A leszármazottak maguk valósítják meg.
	public abstract void acceptPlayer(Player p);
	
	// A leszármazottak maguk valósítják meg.
	public void acceptItem(Item i) {	}
	
	
	//Alapimplementációja nem ad vissza tárgyat..
	public Item pickUpItem(Player p) 
	{
		return null;
	}
	
	// Mezõn történõ ásás, paraméterként kapott értékkel csökkenti a hóréteget, ha van hó.
	// Jelen esetben feltételezzük, hogy van eltávolítható hó.
	public boolean digSnow(int amount) 
	{
		System.out.println(Main.tabok+"->[Field].digSnow(int amount)");
		System.out.println(Main.tabok+"<-[Field].digSnow(int amount)");
		
		//Lekérdezés: volt-e eltakarítható.
		
		return true;
	}

	
	// Tárgy kiszabadítása jégbõl. Késõbb a mezõn található tárgyak közé kerül a kiszabadított tárgy.
	public void removeItemFromIce(Player p) 
	{
		System.out.println(Main.tabok+"->[Field].removeItemFromIce(Player p) ");
		System.out.println(Main.tabok+"<-[Field].removeItemFromIce(Player p) ");
	}
	
	// Játékos mentése adott irányba.
	public boolean savePerson(Direction dir) 
	{
		//Itt késõbb az f2players helyett a players attribútum lesz használva.
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
	
	
	// Iglu elhelyezése a mezõn.
	public boolean buildIgloo() 
	{
		return true;
	}

	// Visszaadja a szomszédot adott irányból. Változik még, jelenleg csak a forgatókönyvhöz lett beállítva..
	public Field getNeighbours()
	{
		System.out.println("Field.getNeighbours");
		return neighbours;
	}
	
	//Visszaadja a mezõn található játékosokat.
	public ArrayList<Player> getPlayers()
	{
		System.out.println(Main.tabok+"->[Field].getPlayer()");
		System.out.println(Main.tabok+"<-[Field].getPlayer()");
		return players;
	}
}
