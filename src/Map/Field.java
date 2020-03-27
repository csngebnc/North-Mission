package Map;
import java.util.ArrayList;

import java.util.Scanner;

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
		System.out.println("Field.generateBlizzard()");

		//Iglu eld�nt�se input alapj�n
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Legyen a mez�n iglu? (Y - IGEN, N - NEM)");
		while(loop) {
			if(scanner.nextLine() == "Y") {
				iglooOnField = true;
				loop = false;
			} else if (scanner.nextLine() == "N") {
				iglooOnField = false;
				loop = false;
			}
		}
		scanner.close();
		
		//Nincs iglu a mez�n -> Rajta lev� j�t�kosok HP-ja 1-el cs�kken
		if(iglooOnField == false)
			for(Player p : players)
				p.alterHealth(-1);
	}
	
	public void moveMeTo(Player p, Direction dir) 
	{
		System.out.println("Field.moveMeTo");
		Field neighbours = new IceField();
		neighbours.acceptPlayer(p);
		
	}
	
	public void revealLimit() 
	{
		
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
		System.out.println("Field.digSnow(int amount)");
		
		//Lek�rdez�s: volt-e eltakaritand� h�
		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.println("Volt h� a mez�n? (Y - IGEN, N - NEM)");
			if(scanner.nextLine() == "Y") {
				scanner.close();
				return true;
			} else if (scanner.nextLine() == "N") {
				scanner.close();
				return false;
			}
		}
	}
	
	public void removeItemFromIce(Player p) 
	{
		
	}
	
	//Dani
	public boolean savePerson(Direction dir) 
	{
		//Itt k�s�bb az f2players helyett a players lesz haszn�lva.
		ArrayList<Player>f2players = new ArrayList<Player>();
		f2players.add(new Eskimo());
		f2players.add(new Eskimo());
		f2players.add(new Eskimo());
		
		if(f2players.size()>0)
		{
			System.out.println("Field.savePerson");
			System.out.println("Kit?");
			for(int i=0; i<f2players.size();i++)
			{
				System.out.println(i+": J�t�kos"+i);
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
	public Field getNeighbours(Direction dir)
	{
		System.out.println("Field.getNeighbours");
		return neighbours;
	}
	
	//Dani
	public ArrayList<Player> getPlayers()
	{
		System.out.println("Field.getPlayer()");
		return players;
	}
}
