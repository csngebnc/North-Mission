package Player;

import java.awt.Image;
import java.awt.event.KeyEvent;
import Player.Direction;
import java.util.ArrayList;
import java.util.Collections;

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
	public PolarBear() {
		super();
		sprites = new Image[2];
		sprites[0]= new ImageIcon("./assets/characters/polar_standing.png").getImage();
		sprites[1] = new ImageIcon("./assets/characters/polar_drowning.png").getImage();
	}
	
	/**
	 * Jegesmedve körének végrehajtása. Lép, majd értesíti a játékot, hogy jöhet a következõ játékos.
	 * @author Csonge Bence
	 */
	@Override
	public void doTurn(KeyEvent e) {
		move(null);
		Game.getInstance().nextCharacter();
	}
	
	/**
	 * A jegesmedve elkezdi a körét.
	 * @author Csonge Bence
	 */
	public void startTurn() {
		doTurn(null);
	}
	
	/**
	 * Véletlenszerûen lép a mezõjének valamely szomszédos mezõjére.
	 * @author Csonge Bence
	 */
	public void move(KeyEvent e) {
		ArrayList<Field> neighbours = field.getNeighbours();
		ArrayList<Field> candidates = field.getNeighbours();
		candidates.removeAll(Collections.singleton(null));
		Direction dir = Direction.FromInt(neighbours.indexOf(candidates.get((int)(Math.random()*candidates.size()))));
		
		field.moveMeTo(this, dir);
	}

	/**
	 * Ez a metódus nem csinál semmit, a PolarBear-nek nem kell az életét állítani.
	 * @param n : Változás értéke
	 * @author Zalan
	 */
	@Override
	public void alterHealth(int n) {	}
	
	/**
	 * Ez a metódus nem csinál semmit, a PolarBear-nek nem kell a stamináját állítani.
	 * @author Zalan
	 */
	@Override
	public void drainStamina() {	}
	
	/**
	 * Ez a metódus false-szal tér vissza, hiszen egy Jegesmedvét nem kell kimentenünk ha lyukba esett.
	 * @param f : A mezõ amire mentenénk
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
		p.alterHealth(-p.getHealth());
		Game.loseGame();		
	}
	
	/**
	 * A jegesmedve nevének lekérdezése.
	 * @author Zalan
	 */
	public String getName() {
		return "Jegesmedve";
	}
	
	/**
	 * A jegesmedve aktuális állapotának megfelelõen visszaadja hozzá tartozó képet.
	 * @author Csonge Bence
	 */
	@Override
	public Image getAvatar() {
		if(isDrowning)
			return sprites[1];
		else return sprites[0];
	}

	/**
	 * Értesíti a paraméterként kapott megjelenítõt, hogy a megadott koordinátákra rajzolja ki a karakter avatárját.
	 * @author Csonge Bence
	 */
	@Override
	public void draw(View v) {
		if(isDrowning) 
			v.drawThing(field.GetX()+32, field.GetY()+14, getAvatar());
		else {
			if(field.hasBuilding())
				v.drawThing(field.GetX()+25, field.GetY()+10, getAvatar());	
			else
				v.drawThing(field.GetX()+25, field.GetY(), getAvatar());	
		}	
	}

}
