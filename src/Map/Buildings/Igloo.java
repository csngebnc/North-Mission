package Map.Buildings;

import java.awt.Image;
import javax.swing.ImageIcon;
import Visual.ImgType;

/**
 * Iglut reprezentáló osztály
 * @author Csonge Bence
 */
public class Igloo implements Building {
	/**
	 * Mivel az iglu robosztus, nem fog tick-elés során tönkremenni, false-al tér vissza
	 * @author Csonge Bence
	 */
	@Override
	public boolean tick() {
		return false;
	}

	/**
	 * Mivel az iglu robosztus, nem lehet támadni, megvédi a játékosokat, false-al tér vissza
	 * @author Csonge Bence
	 */
	@Override
	public boolean attack() {
		return false;
	}

	/**
	 * Visszaadja az iglu kirajzolandó képét
	 * @author Csonge Bence
	 */
	@Override
	public Image getImg(ImgType form) {
		return new ImageIcon("./assets/items_buildings/igloo.png").getImage();
	}
}
