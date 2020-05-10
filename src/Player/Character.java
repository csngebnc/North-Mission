package Player;

import java.awt.Image;
import java.awt.event.KeyEvent;

import Core.Game;
import Map.Field;
import Visual.Viewable;
/**
 * A karaktereket reprezent�l� oszt�ly.
 * Lesz�rmazottai a Player �s a PolarBear
 * @author Zalan
 */
public abstract class Character implements Viewable{
	
	/**
	 * A field amin a karakter aktu�lisan tart�zkodik.
	 * @author Zalan
	 */
	protected Field field;
	protected boolean isDrowning;
	protected int stamina;
	protected Image[] img;
	
	public void setDrowning(boolean b) { isDrowning = b; }

	/**
	 * A karakter k�re.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 */
	public abstract boolean doTurn(Game g, KeyEvent e);
	
	public abstract void move(KeyEvent e);
	public abstract void startTurn(Game g);
	/**
	 * A karakter �let�nek v�ltoztat�sa.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @param n a health v�ltoz�sa.
	 * @author Zalan
	 */
	public abstract void alterHealth(int n);
	
	/**
	 * A karakter stamin�j�nak cs�kkent�se.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 */
	public abstract void drainStamina();
	
	/**
	 * A karakter fuldokl�s�nak be�ll�t�sa.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 */
	public abstract void drown();
	
	/**
	 * A karakter megment�sre ker�l fuldokl� helyzetb�l.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @param f erre a fieldre ker�l a megmentett karakter.
	 * @author Zalan
	 */
	public abstract boolean save(Field f);
	
	/**
	 * A karakter a param�terk�nt kapott karaktert �ssze�tk�zteti saj�t mag�val.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @param c ezen karaktert �tk�zteti �ssze mag�val.
	 * @author Zalan
	 */
	public abstract void collideWith(Character c);
	
	
	/**
	 * Karakter �tk�z�se jegesmedv�vel.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @param pb a jegesmedve, akivel �tk�z�tt.
	 * @author Zalan
	 */
	public void hitBy(PolarBear pb) {}
	
	/**
	 * Karakter �tk�z�se j�t�kossal.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @param pl a j�t�kos, akivel �tk�z�tt.
	 * @author Zalan
	 */
	public void hitBy(Player pl) {}
	
	
	/**
	 * Karakter mez�j�nek be�ll�t�sa.
	 * @param f a field �j �rt�ke.
	 * @author Zalan
	 */
	public void setField(Field f) {
		field = f;
	}
	
	/**
	 * Karakter mez�j�nek lek�rdez�se.
	 * @author Zalan
	 */
	public Field getField() {
		return field;
	}
	
	/**
	 * Karakter nev�nek lek�rdez�se.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 */
	public abstract String getName();
	
	
	/**
	 * Tesztel�shez
	 */
	public void Properties()
	{
	}
}
