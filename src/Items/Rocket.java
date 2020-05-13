package Items;

import java.awt.Image;
import javax.swing.ImageIcon;
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
}
