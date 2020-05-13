package Map.Buildings;

import java.awt.Image;
import javax.swing.ImageIcon;
import Visual.ImgType;

/**
 * Iglut reprezent�l� oszt�ly
 * @author Csonge Bence
 */
public class Igloo implements Building {
	/**
	 * Mivel az iglu robosztus, nem fog tick-el�s sor�n t�nkremenni, false-al t�r vissza
	 * @author Csonge Bence
	 */
	@Override
	public boolean tick() {
		return false;
	}

	/**
	 * Mivel az iglu robosztus, nem lehet t�madni, megv�di a j�t�kosokat, false-al t�r vissza
	 * @author Csonge Bence
	 */
	@Override
	public boolean attack() {
		return false;
	}

	/**
	 * Visszaadja az iglu kirajzoland� k�p�t
	 * @author Csonge Bence
	 */
	@Override
	public Image getImg(ImgType form) {
		return new ImageIcon("./assets/items_buildings/igloo.png").getImage();
	}
}
