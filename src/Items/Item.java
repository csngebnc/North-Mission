package Items;
import java.awt.Image;
import Map.Field;
import Player.Player;
import Visual.ImgType;

/**
 * Egy interfész, ami alapul szolgál a játékban található tárgyakhoz. 
 * Kötelezõvé teszi olyan metódusok megvalósítását, melyek egy tárgy esetén létfontosságúak.
 * @author Norbi
 */
public interface Item
{
	/**
	 * Tárgy felvétele.
	 * Leszármazottak saját maguk valósítják meg.
	 * @param p játékos a ki hívta a metódust.
	 * @author Norbi?
	 */
	public void use(Player p);
	
	
	/**
	 * Tárgy eldobása.
	 * Leszármazottak saját maguk valósítják meg.
	 * @param f az a mezõ akire dobjuk a tárgyat.
	 * @author Norbi?
	 */
	public abstract boolean throwTo(Field f);
	
	
	/**
	 * Tárgy felvétele.
	 * Leszármazottak saját maguk valósítják meg.
	 * @author Norbi
	 */
	public abstract void pickUp();
	
	public Image getImg(ImgType form);
	
	public abstract String getName();
}
