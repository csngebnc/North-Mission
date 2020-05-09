package Player;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import Core.Game;
import Map.Field;
import Visual.View;

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
	public void doTurn(Game g) {
		
		ArrayList<Integer> nexts = new ArrayList<Integer>();
		for(int i=0; i< field.getNeighbours().size();i++) {
			if(field.getNeighbours().get(i)!=null) {
				nexts.add(i);
			}
		}
		int max = nexts.size()-1;
		int where = nexts.get((int)(Math.random()*max));
		System.out.println(where);
		field.moveMeTo(this, where);
		g.notifyView();
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
		isDrowning = true;
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
	 * @param c a karakter akivel a jegesmedve összeütközteti magát.
	 * @author Zalan
	 */
	@Override
	public void collideWith(Character c) {
		c.hitBy(this);
	}

	/**
	 * Ha a jegesmedve játékossal ütközött, akkor a játékot elveszítették a játékosok.
	 * @param p a játékos, akivel a jegesmedve összeütközött.
	 * @author Zalan
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

	@Override
	public void draw(View v) {
		if(isDrowning) {
			v.drawThing(field.GetX()+32, field.GetY()+14, new ImageIcon("./assets/characters/polar_drowning.png").getImage());
		}else {
			if(field.hasBuilding())
				v.drawThing(field.GetX()+25, field.GetY()+10, new ImageIcon("./assets/characters/polar_standing.png").getImage());	
			else
				v.drawThing(field.GetX()+25, field.GetY(), new ImageIcon("./assets/characters/polar_standing.png").getImage());	
		}	
	}

}
