package Items;
import Map.Field;
import Player.Player;

public abstract class Item 
{
	// Bence
	public void use(Player p) 
	{
		System.out.println("->[Item].use()");
		System.out.println("<-[Item].use()");
		
	}
	
	public abstract boolean throwTo(Field f);
	
	//Dominik, ez abasztakt lett
	public abstract void pickUp();
}
