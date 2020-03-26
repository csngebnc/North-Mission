package Map;
import java.util.ArrayList;

import Items.Item;
import Player.Player;


public abstract class Field
{
	protected int snowLayers;
	protected int maxplayers;
	protected ArrayList<Player> players;
	protected Field neighbours;
	
	public void generateBlizzard() 
	{
	
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
	
	public void acceptItem(Item i) 
	{
		
	}
	
	public Item pickUpItem(Player p) 
	{
		
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
