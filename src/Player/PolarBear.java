package Player;

import java.util.Random;

import Core.Game;
import Map.Field;

public class PolarBear extends Character{

	
	/*
	 * A jegesmedve karakter egy random szomsz�dos mez�re l�p a k�r�ben.
	 * @author Zalan
	 */
	@Override
	public void doTurn() {
		int max = field.getNeighbours().size()-1;
		field.moveMeTo(this, (int)(Math.random()*max));
	}

	@Override
	public void alterHealth(int n) {
	}

	@Override
	public void drainStamina() {		
	}

	@Override
	public void drown() {	
	}
	
	@Override
	public boolean save(Field f) {
		return false;
	}

	/*
	 * A jegesmedve a param�terk�nt kapott karaktert �ssze�tk�zteti saj�t mag�val.
	 * @author Zalan
	 * @param c a karakter akivel a jegesmedve �ssze�tk�zteti mag�t.
	 */
	@Override
	public void collideWith(Character c) {
		c.hitBy(this);
	}

	/*
	 * Ha a jegesmedve j�t�kossal �tk�z�tt, akkor a j�t�kot elvesz�tett�k a j�t�kosok.
	 * @author Zalan
	 * @param p a j�t�kos, akivel a jegesmedve �ssze�tk�z�tt.
	 */
	@Override
	public void hitBy(Player p) {
		Game.loseGame();		
	}
	
	/*
	 * Tesztel�shez
	 */
	@Override
	public void Properties()
	{
		System.out.println("Jegesmedve");
	}
	
	public String getName() {
		return "Jegesmedve";
	}

}
