package Map;
import java.util.ArrayList;

import java.util.Scanner;

import Items.Item;
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
		
		System.out.println("Legyen a mez�n iglu? (Y - IGEN, N - NEM");
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
		neighbours.acceptPlayer(p);
		p.drainStamina();
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
	
	public boolean digSnow(int amount) 
	{
		
	}
	
	public void removeItemFromIce(Player p) 
	{
		
	}
	
	public boolean savePerson(Direction dir) 
	{
		
	}
	
	public boolean buildIgloo() 
	{
		
	}
}
