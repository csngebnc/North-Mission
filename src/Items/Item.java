package Items;
import Core.Main;
import Map.Field;
import Player.Player;

/**
 * 
 * @author Norbi
 * Egy interfész, ami alapul szolgál a játékban található tárgyakhoz. 
 * Kötelezõvé teszi olyan metódusok megvalósítását, melyek egy tárgy esetén létfontosságúak.
 */
public interface Item 
{
	/**
	 * Tárgy felvétele.
	 * Leszármazottak saját maguk valósítják meg.
	 * 
	 * @author Norbi?
	 * @param p játékos a ki hívta a metódust.
	 */
	public void use(Player p);
	
	
	/**
	 * Tárgy eldobása.
	 * Leszármazottak saját maguk valósítják meg.
	 * 
	 * @author Norbi?
	 * @param f az a mezõ akire dobjuk a tárgyat.
	 */
	public abstract boolean throwTo(Field f);
	
	
	/**
	 * Tárgy felvétele.
	 * Leszármazottak saját maguk valósítják meg.
	 * 
	 * @author Norbi?
	 */
	public abstract void pickUp();
	
	public void Properties();
}
