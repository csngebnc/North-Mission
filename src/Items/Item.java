package Items;
import Core.Main;
import Map.Field;
import Player.Player;

public abstract class Item 
{
	// Bence
	public void use(Player p) 
	{
		System.out.println(Main.tabok+"->[Item].use()");
		System.out.println(Main.tabok+"<-[Item].use()");
		
	}
	
	public abstract boolean throwTo(Field f);
	
	//Dominik, ez abasztakt lett
	public abstract void pickUp();
}
