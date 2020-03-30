package Items;
import Core.Main;
import Map.Field;
import Player.Player;

public abstract class Item 
{
	// Tárgy felvétele
	public void use(Player p) 
	{
		System.out.println(Main.tabok+"->[Item].use()");
		System.out.println(Main.tabok+"<-[Item].use()");
		
	}
	
	// Leszármazottak saját maguk valósítják meg.
	public abstract boolean throwTo(Field f);
	
	// Leszármazottak saját maguk valósítják meg.
	public abstract void pickUp();
}
