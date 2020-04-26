package Items;
import Core.Main;
import Map.Field;
import Player.Player;

/**
 * 
 * @author Norbi
 * Egy interf�sz, ami alapul szolg�l a j�t�kban tal�lhat� t�rgyakhoz. 
 * K�telez�v� teszi olyan met�dusok megval�s�t�s�t, melyek egy t�rgy eset�n l�tfontoss�g�ak.
 */
public interface Item 
{
	/**
	 * T�rgy felv�tele.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * 
	 * @author Norbi?
	 * @param p j�t�kos a ki h�vta a met�dust.
	 */
	public void use(Player p);
	
	
	/**
	 * T�rgy eldob�sa.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * 
	 * @author Norbi?
	 * @param f az a mez� akire dobjuk a t�rgyat.
	 */
	public abstract boolean throwTo(Field f);
	
	
	/**
	 * T�rgy felv�tele.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * 
	 * @author Norbi?
	 */
	public abstract void pickUp();
	
	public void Properties();
}
