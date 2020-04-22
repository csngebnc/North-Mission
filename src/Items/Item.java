package Items;
import Core.Main;
import Map.Field;
import Player.Player;

public interface Item 
{
	// Tárgy felvétele
	public void use(Player p);
	
	// Leszármazottak saját maguk valósítják meg.
	public abstract boolean throwTo(Field f);
	
	// Leszármazottak saját maguk valósítják meg.
	public abstract void pickUp();
}
