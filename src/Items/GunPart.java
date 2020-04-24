package Items;
import Core.Game;
import Core.Main;
import Map.Field;
import Player.Player;

public abstract class GunPart implements Item 
{
	/*
	 * T�rgy haszn�lat
	 * Az �s�nek haszn�l met�dus�t h�vja.
	 * 
	 * @param p j�t�kos a ki h�vta a met�dust.
	 */
	public void use(Player p) 
	{
	}
	
	/*
	 * T�rgy eldob�s
	 * Alap�rtelmezetten false �rt�kkel t�r vissza, mivel egy alkatr�sz nem eldobhat�.
	 * 
	 * @param f az a mez� akire dobjuk a t�rgyat.
	 */
	public boolean throwTo(Field f) 
	{
		return false;
	}
	
	/*
	 * T�rgy felv�tel.
	 * Amennyiben felveszik, akkor a sz�l a j�t�knak, hogy megtal�ltak egy alkatr�szt.
	 */
	public void pickUp() 
	{
	}
}
