package Player;

import java.util.Random;

import Core.Game;
import Map.Field;

/**
 * A jegesmedv�t reprezent�l� oszt�ly, ami a Character lesz�rmazottja.
 * @author Zalan
 */
public class PolarBear extends Character{
	/**
	 * A jegesmedve karakter egy random szomsz�dos mez�re l�p a k�r�ben.
	 * @author Zalan
	 */
	@Override
	public void doTurn() {
		int max = field.getNeighbours().size()-1;
		field.moveMeTo(this, (int)(Math.random()*max));
	}

	/**
	 * Ez a met�dus nem csin�l semmit, a PolarBear-nek nem kell az �let�t �ll�tani.
	 * @author Zalan
	 */
	@Override
	public void alterHealth(int n) {
	}
	
	/**
	 * Ez a met�dus nem csin�l semmit, a PolarBear-nek nem kell a stamin�j�t �ll�tani.
	 * @author Zalan
	 */
	@Override
	public void drainStamina() {		
	}

	/**
	 * Ez a met�dus nem csin�l semmit, a PolarBear-nek be�ll�tani, hogy fuldoklik-e.
	 * @author Zalan
	 */
	@Override
	public void drown() {	
	}
	
	/**
	 * Ez a met�dus false-szal t�r vissza, hiszen egy Jegesmedv�t nem kell kimenten�nk ha lyukba esett.
	 * @author Zalan
	 */
	@Override
	public boolean save(Field f) {
		return false;
	}

	/**
	 * A jegesmedve a param�terk�nt kapott karaktert �ssze�tk�zteti saj�t mag�val.
	 * @author Zalan
	 * @param c a karakter akivel a jegesmedve �ssze�tk�zteti mag�t.
	 */
	@Override
	public void collideWith(Character c) {
		c.hitBy(this);
	}

	/**
	 * Ha a jegesmedve j�t�kossal �tk�z�tt, akkor a j�t�kot elvesz�tett�k a j�t�kosok.
	 * @author Zalan
	 * @param p a j�t�kos, akivel a jegesmedve �ssze�tk�z�tt.
	 */
	@Override
	public void hitBy(Player p) {
		Game.loseGame();		
	}
	
	/**
	 * Tesztel�shez
	 */
	@Override
	public void Properties()
	{
		System.out.println("Jegesmedve");
	}
	
	/**
	 * A jegesmedve nev�nek lek�rdez�se.
	 * @author Zalan
	 */
	public String getName() {
		return "Jegesmedve";
	}

}
