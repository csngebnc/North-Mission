package Player;

import java.util.Random;

import Core.Game;
import Map.Field;

/**
 * A jegesmedvét reprezentáló osztály, ami a Character leszármazottja.
 * @author Zalan
 */
public class PolarBear extends Character{
	/**
	 * A jegesmedve karakter egy random szomszédos mezõre lép a körében.
	 * @author Zalan
	 */
	@Override
	public void doTurn() {
		int max = field.getNeighbours().size()-1;
		field.moveMeTo(this, (int)(Math.random()*max));
	}

	/**
	 * Ez a metódus nem csinál semmit, a PolarBear-nek nem kell az életét állítani.
	 * @author Zalan
	 */
	@Override
	public void alterHealth(int n) {
	}
	
	/**
	 * Ez a metódus nem csinál semmit, a PolarBear-nek nem kell a stamináját állítani.
	 * @author Zalan
	 */
	@Override
	public void drainStamina() {		
	}

	/**
	 * Ez a metódus nem csinál semmit, a PolarBear-nek beállítani, hogy fuldoklik-e.
	 * @author Zalan
	 */
	@Override
	public void drown() {	
	}
	
	/**
	 * Ez a metódus false-szal tér vissza, hiszen egy Jegesmedvét nem kell kimentenünk ha lyukba esett.
	 * @author Zalan
	 */
	@Override
	public boolean save(Field f) {
		return false;
	}

	/**
	 * A jegesmedve a paraméterként kapott karaktert összeütközteti saját magával.
	 * @author Zalan
	 * @param c a karakter akivel a jegesmedve összeütközteti magát.
	 */
	@Override
	public void collideWith(Character c) {
		c.hitBy(this);
	}

	/**
	 * Ha a jegesmedve játékossal ütközött, akkor a játékot elveszítették a játékosok.
	 * @author Zalan
	 * @param p a játékos, akivel a jegesmedve összeütközött.
	 */
	@Override
	public void hitBy(Player p) {
		Game.loseGame();		
	}
	
	/**
	 * Teszteléshez
	 */
	@Override
	public void Properties()
	{
		System.out.println("Jegesmedve");
	}
	
	/**
	 * A jegesmedve nevének lekérdezése.
	 * @author Zalan
	 */
	public String getName() {
		return "Jegesmedve";
	}

}
