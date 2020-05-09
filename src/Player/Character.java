package Player;

import Core.Game;
import Map.Field;
import Visual.Viewable;
/**
 * A karaktereket reprezentáló osztály.
 * Leszármazottai a Player és a PolarBear
 * @author Zalan
 */
public abstract class Character implements Viewable{
	
	/**
	 * A field amin a karakter aktuálisan tartózkodik.
	 * @author Zalan
	 */
	protected Field field;
	protected boolean isDrowning;
	
	public void setDrowning(boolean b) { isDrowning = b; }

	/**
	 * A karakter köre.
	 * Leszármazottak saját maguk valósítják meg.
	 * @author Zalan
	 */
	public abstract void doTurn(Game g);
	
	/**
	 * A karakter életének változtatása.
	 * Leszármazottak saját maguk valósítják meg.
	 * @param n a health változása.
	 * @author Zalan
	 */
	public abstract void alterHealth(int n);
	
	/**
	 * A karakter staminájának csökkentése.
	 * Leszármazottak saját maguk valósítják meg.
	 * @author Zalan
	 */
	public abstract void drainStamina();
	
	/**
	 * A karakter fuldoklásának beállítása.
	 * Leszármazottak saját maguk valósítják meg.
	 * @author Zalan
	 */
	public abstract void drown();
	
	/**
	 * A karakter megmentésre kerül fuldokló helyzetbõl.
	 * Leszármazottak saját maguk valósítják meg.
	 * @param f erre a fieldre kerül a megmentett karakter.
	 * @author Zalan
	 */
	public abstract boolean save(Field f);
	
	/**
	 * A karakter a paraméterként kapott karaktert összeütközteti saját magával.
	 * Leszármazottak saját maguk valósítják meg.
	 * @param c ezen karaktert ütközteti össze magával.
	 * @author Zalan
	 */
	public abstract void collideWith(Character c);
	
	
	/**
	 * Karakter ütközése jegesmedvével.
	 * Leszármazottak saját maguk valósítják meg.
	 * @param pb a jegesmedve, akivel ütközött.
	 * @author Zalan
	 */
	public void hitBy(PolarBear pb) {}
	
	/**
	 * Karakter ütközése játékossal.
	 * Leszármazottak saját maguk valósítják meg.
	 * @param pl a játékos, akivel ütközött.
	 * @author Zalan
	 */
	public void hitBy(Player pl) {}
	
	
	/**
	 * Karakter mezõjének beállítása.
	 * @param f a field új értéke.
	 * @author Zalan
	 */
	public void setField(Field f) {
		field = f;
	}
	
	/**
	 * Karakter mezõjének lekérdezése.
	 * @author Zalan
	 */
	public Field getField() {
		return field;
	}
	
	/**
	 * Karakter nevének lekérdezése.
	 * Leszármazottak saját maguk valósítják meg.
	 * @author Zalan
	 */
	public abstract String getName();
	
	
	/**
	 * Teszteléshez
	 */
	public void Properties()
	{
	}
}
