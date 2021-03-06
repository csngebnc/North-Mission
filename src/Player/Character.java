package Player;

import java.awt.Image;
import java.awt.event.KeyEvent;
import Map.Field;
import Visual.Viewable;

/**
 * A j�t�kban r�sztvev� karaktereket reprezent�l� oszt�ly.
 * Lesz�rmazottai a Player �s a PolarBear
 * @author Zalan
 */
public abstract class Character implements Viewable{
	/**
	 * A field amin a karakter aktu�lisan tart�zkodik
	 * @author Zalan
	 */
	protected Field field;
	
	/**
	 * T�rolja, hogy a karakter �pp fuldoklik-e
	 * @author Csonge Bence
	 */
	protected boolean isDrowning;
	
	/**
	 * A karakter stamin�ja
	 * @author Csonge Bence
	 */
	protected int stamina;
	
	/**
	 * A karakterhez tartoz�, megjelen�t�shez sz�ks�ges k�pek t�rol�ja
	 * @author Csonge Bence
	 */
	protected Image[] sprites;
	
	/**
	 * Be�ll�tja a j�t�kos fullad�s�t.
	 * @param b j�t�kos fullad�s�nak �rt�ke, true ha fullad, false ha nem
	 * @author Csonge Bence
	 */
	public void setDrowning(boolean b) { 
		isDrowning = b;
		if(isDrowning)
			stamina = 0;
	}
	
	/**
	 * Visszaadja, hogy a j�t�kos �p fuldoklik-e
	 */
	public boolean getDrowning() {
		return isDrowning;
	}

	/**
	 * Karakter k�re
	 * @author Zalan
	 */
	public abstract void doTurn(KeyEvent e);
	
	/**
	 * A megnyomott billenty� �ltal kiv�ltott esem�nyt dolgozza fel, annak megfelel�en cselekszik.
	 * Karaktert�pusonk�nt m�s megval�s�t�s lehet (player vs. polarbear)
	 * @param e A megnyomott billenty�h�z tartoz� esem�ny.
	 * @author Csonge Bence
	 */
	public abstract void move(KeyEvent e);
	
	/**
	 * A karakter �rtes�t�se, hogy kezd�dik a k�r.
	 * A sz�ks�ges �rt�keket be�ll�tja a k�rkezd�shez.
	 * @author Csonge Bence
	 */
	public abstract void startTurn();
	
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
	public void hitBy(PolarBear pb) {	}
	
	/**
	 * Karakter �tk�z�se j�t�kossal.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @param pl a j�t�kos, akivel �tk�z�tt.
	 * @author Zalan
	 */
	public void hitBy(Player pl) {	}
	
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
	 * Visszaadja a karakter �llapot�nak megfelel� k�pet, ami kirajzol�sra ker�l.
	 * @author Csonge Bence
	 */
	public abstract Image getAvatar();
	
	/**
	 * Karakter nev�nek lek�rdez�se.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 */
	public abstract String getName();
}