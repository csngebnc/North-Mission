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
	
	//Dominik
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
	
	//Norbi + valaki kiegészítette 
	public void moveMeTo(Player p, Direction dir) 
	{
		System.out.println(Main.tabok+"->[Field].moveMeTo(Player p, Direction dir)");
		Main.tabok+="\t";
		//Itt k�s�bb a neighbours attrib�tumot fogja haszn�lni.
		Field neighbours;
		if(Main.FORGATOKONYV_SZAMA==2) neighbours = new IceField();
		else if(Main.FORGATOKONYV_SZAMA==3) neighbours = new UnstableField();
		else neighbours = new Hole();
		
		neighbours.acceptPlayer(p);
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Field].moveMeTo(Player p, Direction dir)");
		
	}
	
	public void revealLimit() 
	{
		System.out.println(Main.tabok+"->[Field].revealLimit()");
		System.out.println(Main.tabok+"<-[Field].revealLimit()");
	}
	
	public abstract void acceptPlayer(Player p);
	
	//Dominik 
	public void acceptItem(Item i) {	}
	
	//Dominik
	//Alapimplement�ci�ja nem ad vissza t�rgyat.
	public Item pickUpItem(Player p) 
	{
		return null;
	}
	
	//Dominik
	public boolean digSnow(int amount) 
	{
		System.out.println(Main.tabok+"->[Field].digSnow(int amount)");
		System.out.println(Main.tabok+"<-[Field].digSnow(int amount)");
		
		//Lek�rdez�s: volt-e eltakaritand� h�
		return true;
	}

	
	//Zal�n
	public void removeItemFromIce(Player p) 
	{
		System.out.println(Main.tabok+"->[Field].removeItemFromIce(Player p) ");
		System.out.println(Main.tabok+"<-[Field].removeItemFromIce(Player p) ");
	}
	
	//Dani
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
				System.out.println(Main.tabok+i+": J�t�kos"+i);
			}
			
			Scanner myObj = new Scanner(System.in);
			String name = myObj.nextLine();
			
			//Itt k�s�bb a kiv�laszott j�t�kos lesz p2 �rt�ke
			Player p2 = new Eskimo();
			moveMeTo(p2,dir);
			Field f1 = neighbours;
			p2.setField(f1);
			return true;
		}
		return false;
	}
	
	public boolean buildIgloo() 
	{
		return true;
	}
	//Dani
	public Field getNeighbours()
	{
		System.out.println("Field.getNeighbours");
		return neighbours;
	}
	
	//Dani
	public ArrayList<Player> getPlayers()
	{
		System.out.println(Main.tabok+"->[Field].getPlayer()");
		System.out.println(Main.tabok+"<-[Field].getPlayer()");
		return players;
	}
}
