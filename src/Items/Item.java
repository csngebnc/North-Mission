package Items;
import Core.Main;
import Map.Field;
import Player.Player;

public interface Item 
{
	/*
	 * T�rgy felv�tele.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * 
	 * @author Norbi?
	 * @param p j�t�kos a ki h�vta a met�dust.
	 */
	public void use(Player p);
	
	
	/*
	 * T�rgy eldob�sa.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * 
	 * @author Norbi?
	 * @param f az a mez� akire dobjuk a t�rgyat.
	 */
	public abstract boolean throwTo(Field f);
	
	
	/*
	 * T�rgy felv�tele.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * 
	 * @author Norbi?
	 */
	public abstract void pickUp();
	
	public void Properties();
}
