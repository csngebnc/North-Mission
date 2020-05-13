package Items;

import java.awt.Image;
import javax.swing.ImageIcon;

import Core.Game;
import Visual.ImgType;

/**
 * Pisztolycsövet reprezentáló osztály
 * @author Norbi
 */
public class Barrel extends GunPart{
	
	/**
	 * Konstruktor, beállitja a képeket
	 * @author Balczer Dominik
	 */
	public Barrel() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/barrel.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/barrel_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/barrel.png").getImage();
	}
	
	/**
	 * Tárgy felvétel.
	 * Amennyiben felveszik, akkor a szól a játéknak, hogy megtalálták az alkatrészt.
	 */
	@Override
	public void pickUp() {
		Game.incGunParts(1);
	}
	
	/**
	 * Visszaadja a tárgy nevét.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Gun Barrel";
	}
}