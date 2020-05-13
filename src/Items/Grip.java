package Items;

import java.awt.Image;
import javax.swing.ImageIcon;

import Core.Game;
import Visual.ImgType;

/**
 * Pisztoly markolatot reprezentáló osztály.
 * @author Norbi
 */
public class Grip extends GunPart {
	
	/**
	 * Konstruktor, beállitja a képeket
	 * @author Balczer Dominik
	 */
	public Grip() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/grip.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/grip_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/grip.png").getImage();
	}
	
	/**
	 * Tárgy felvétel.
	 * Amennyiben felveszik, akkor a szól a játéknak, hogy megtalálták az alkatrészt.
	 */
	@Override
	public void pickUp() {
		Game.incGunParts(2);
	}
	
	/**
	 * Visszaadja a tárgy nevét.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Grip";
	}
}