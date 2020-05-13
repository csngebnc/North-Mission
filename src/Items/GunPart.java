package Items;
import java.awt.Image;

import Core.Game;
import Map.Field;
import Player.Player;
import Visual.ImgType;

/**
 * A játék során összegyûjthetõ tárgyak melyek egy jelzõpisztoly darabjait reprezentálják. 
 * Tudniuk kell a játékot értesiteni ha felvették õket és nem szabad hogy eldobhatók legyenek.
 * @author Norbi
 */
public abstract class GunPart implements Item {
	
	/**
	 * A tárgyhoz tartozó képek
	 * @author Balczer Dominik
	 */
	Image[] sprites;
	
	/**
	 * Tárgy használat.
	 * Az õsének használ metódusát hívja.
	 * @param p játékos a ki hívta a metódust.
	 */
	public void use(Player p) {
		Game.winGame(p.getField());
	}
	
	/**
	 * Tárgy eldobás.
	 * Alapértelmezetten false értékkel tér vissza, mivel egy alkatrész nem eldobható.
	 * 
	 * @param f az a mezõ akire dobjuk a tárgyat.
	 */
	public boolean throwTo(Field f) {
		return false;
	}
	
	/**
	 * Tárgy felvétel.
	 * Amennyiben felveszik, akkor a szól a játéknak, hogy megtaláltak egy alkatrészt.
	 */
	public void pickUp() {
		Game.incGunParts();
	}
	
	/**
	 * Visszaadja a tárgy képét adott állapotban
	 * @param form : A kép tipusa
	 * @author Balczer Dominik
	 */
	@Override
	public Image getImg(ImgType form) {
		return sprites[form.VALUE];
	}
}
