package Items;
import Core.Game;
import Core.Main;
import Map.Field;
import Player.Player;

public abstract class GunPart implements Item 
{
	// Az õsének használ metódusát hívja.
	public void use(Player p) 
	{
	}
	
	//Alapértelmezetten false értékkel tér vissza, mivel egy alkatrész nem eldobható.
	public boolean throwTo(Field f) 
	{
		return false;
	}
	
	// Amennyiben felveszik, akkor a szól a játéknak, hogy megtaláltak egy alkatrészt.
	public void pickUp() 
	{
	}
}
