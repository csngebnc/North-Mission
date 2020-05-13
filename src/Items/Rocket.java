package Items;

import java.awt.Image;
import javax.swing.ImageIcon;

import Core.Game;
import Visual.ImgType;

/**
 * Pisztoly rakétáját reprezentálja
 * @author Norbi
 */
public class Rocket extends GunPart{
	
	/**
	 * Konstruktor, beállitja a képeket
	 * @author Balczer Dominik
	 */
	public Rocket() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/rocket.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/rocket_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/rocket.png").getImage();
	}
	
	/**
	 * Visszaadja a tárgy nevét.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Flare";
	}

	/**
	 * Tárgy felvétel.
	 * Amennyiben felveszik, akkor a szól a játéknak, hogy megtalálták az alkatrészt.
	 */
	@Override
	public void pickUp() {
		Game.incGunParts(0);
	}
}
