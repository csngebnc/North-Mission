package Items;
import java.awt.Image;
import Map.Field;
import Player.Player;
import Visual.ImgType;

/**
 * Egy interf�sz, ami alapul szolg�l a j�t�kban tal�lhat� t�rgyakhoz. 
 * K�telez�v� teszi olyan met�dusok megval�s�t�s�t, melyek egy t�rgy eset�n l�tfontoss�g�ak.
 * @author Norbi
 */
public interface Item
{
	/**
	 * T�rgy felv�tele.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @param p j�t�kos a ki h�vta a met�dust.
	 * @author Norbi?
	 */
	public void use(Player p);
	
	
	/**
	 * T�rgy eldob�sa.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @param f az a mez� akire dobjuk a t�rgyat.
	 * @author Norbi?
	 */
	public abstract boolean throwTo(Field f);
	
	
	/**
	 * T�rgy felv�tele.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Norbi
	 */
	public abstract void pickUp();
	
	public Image getImg(ImgType form);
	
	public abstract String getName();
}
