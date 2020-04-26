package Player;

import Map.Field;

public abstract class Character {
	
	protected Field field;

	/*
	 * A karakter k�re.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 */
	public abstract void doTurn();
	
	/*
	 * A karakter �let�nek v�ltoztat�sa.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 * @param n a health v�ltoz�sa.
	 */
	public abstract void alterHealth(int n);
	
	/*
	 * A karakter stamin�j�nak cs�kkent�se.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 */
	public abstract void drainStamina();
	
	/*
	 * A karakter fuldokl�s�nak be�ll�t�sa.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 */
	public abstract void drown();
	
	/*
	 * A karakter megment�sre ker�l fuldokl� helyzetb�l.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 * @param f erre a fieldre ker�l a megmentett karakter.
	 */
	public abstract boolean save(Field f);
	
	/*
	 * A karakter a param�terk�nt kapott karaktert �ssze�tk�zteti saj�t mag�val.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 * @param c ezen karaktert �ssze�tk�zteti mag�val.
	 */
	public abstract void collideWith(Character c);
	
	
	/*
	 * Karakter �tk�z�se jegesmedv�vel.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 * @param pb a jegesmedve, akivel �tk�z�tt.
	 */
	public void hitBy(PolarBear pb) {}
	
	/*
	 * Karakter �tk�z�se j�t�kossal.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 * @param pl a j�t�kos, akivel �tk�z�tt.
	 */
	public void hitBy(Player pl) {}
	
	
	/*
	 * Karakter mez�j�nek be�ll�t�sa.
	 * @author Zalan
	 * @param f a field �j �rt�ke.
	 */
	public void setField(Field f) {
		field = f;
	}
	
	/*
	 * Karakter mez�j�nek lek�rdez�se.
	 * @author Zalan
	 */
	public Field getField() {
		return field;
	}
	
	/*
	 * Karakter nev�nek lek�rdez�se.
	 * Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	 * @author Zalan
	 */
	public abstract String getName();
	
	
	/*
	 * Tesztel�shez
	 */
	public void Properties()
	{
	}
}
