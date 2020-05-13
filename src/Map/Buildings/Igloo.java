package Map.Buildings;

import java.awt.Image;

import javax.swing.ImageIcon;

import Visual.ImgType;

/**
 * Az iglu epuletet megvalosito osztaly.
 * @author Csonge Bence
 */
public class Igloo implements Building{

	public Igloo() {}
	
	/**
	 * A tick() metodus jelen esetben false ertekkel ter vissza, mivel egy iglu elettartama egy jatekra szol.
	 * @author Csonge Bence
	 */
	@Override
	public boolean tick() {
		return false;
	}

	/**
	 * Az attack() metodus jelen esetben false ertekkel ter vissza, mivel egy olyan mezon nem lehet jatekosokat megtamadni,
	 * ahol iglu van felepitve.
	 * @author Csonge Bence
	 */
	@Override
	public boolean attack() {
		return false;
	}

	/**
	 * Visszaadja az iglu kirajzolandó képét.
	 * @author Csonge Bence
	 */
	@Override
	public Image getImg(ImgType form) {
		
		return new ImageIcon("./assets/items_buildings/igloo.png").getImage();
	}

}
