package Items;

import java.awt.Image;
import javax.swing.ImageIcon;
import Visual.ImgType;

/**
 * Pisztoly markolatot reprezent�l� oszt�ly.
 * @author Norbi
 */
public class Grip extends GunPart {
	
	/**
	 * Konstruktor, be�llitja a k�peket
	 * @author Balczer Dominik
	 */
	public Grip() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/grip.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/grip_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/grip.png").getImage();
	}
	
	/**
	 * Visszaadja a t�rgy nev�t.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Grip";
	}
}