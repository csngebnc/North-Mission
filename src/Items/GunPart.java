package Items;
import Core.Game;
import Core.Main;
import Map.Field;
import Player.Player;

public abstract class GunPart implements Item 
{
	/*
	 * Tárgy használat
	 * Az õsének használ metódusát hívja.
	 * 
	 * @param p játékos a ki hívta a metódust.
	 */
	public void use(Player p) 
	{
	}
	
	/*
	 * Tárgy eldobás
	 * Alapértelmezetten false értékkel tér vissza, mivel egy alkatrész nem eldobható.
	 * 
	 * @param f az a mezõ akire dobjuk a tárgyat.
	 */
	public boolean throwTo(Field f) 
	{
		return false;
	}
	
	/*
	 * Tárgy felvétel.
	 * Amennyiben felveszik, akkor a szól a játéknak, hogy megtaláltak egy alkatrészt.
	 */
	public void pickUp() 
	{
	}
}
