package Items;
import java.awt.Image;

import Core.Game;
import Map.Field;
import Player.Player;
import Visual.ImgType;

/**
 * A j�t�k sor�n �sszegy�jthet� t�rgyak melyek egy jelz�pisztoly darabjait reprezent�lj�k. 
 * Tudniuk kell a j�t�kot �rtesiteni ha felvett�k �ket �s nem szabad hogy eldobhat�k legyenek.
 * @author Norbi
 */
public abstract class GunPart implements Item {
	
	/**
	 * A t�rgyhoz tartoz� k�pek
	 * @author Balczer Dominik
	 */
	Image[] sprites;
	
	/**
	 * T�rgy haszn�lat.
	 * Az �s�nek haszn�l met�dus�t h�vja.
	 * @param p j�t�kos a ki h�vta a met�dust.
	 */
	public void use(Player p) {
		Game.winGame(p.getField());
	}
	
	/**
	 * T�rgy eldob�s.
	 * Alap�rtelmezetten false �rt�kkel t�r vissza, mivel egy alkatr�sz nem eldobhat�.
	 * 
	 * @param f az a mez� akire dobjuk a t�rgyat.
	 */
	public boolean throwTo(Field f) {
		return false;
	}
	
	/**
	 * T�rgy felv�tel.
	 * Amennyiben felveszik, akkor a sz�l a j�t�knak, hogy megtal�ltak egy alkatr�szt.
	 */
	public void pickUp() {
		Game.incGunParts();
	}
	
	/**
	 * Visszaadja a t�rgy k�p�t adott �llapotban
	 * @param form : A k�p tipusa
	 * @author Balczer Dominik
	 */
	@Override
	public Image getImg(ImgType form) {
		return sprites[form.VALUE];
	}
}
