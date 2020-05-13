package Items;

import java.awt.Image;

import javax.swing.ImageIcon;

import Visual.ImgType;

/**
 * Pisztoly markolatot reprezent�l� oszt�ly.
 * @author Norbi
 */
public class Grip extends GunPart 
{
	/**
	 * Visszaadja a t�rgy nev�t.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Grip";
	}
	
	/**
	 * Visszaadja az alkatr�sz azon k�p�t, amelyre sz�ks�g van a kirajzol�shoz.
	 * @param form Lehets�ges form�k: befagyott, f�ld�n l�v�.
	 * @author Csonge Bence
	 */
	@Override
	public Image getImg(ImgType form) {
		if(form==ImgType.DROPPED) {
			return new ImageIcon("./assets/items_buildings/grip.png").getImage();
		}else if(form==ImgType.FROZEN) {
			return new ImageIcon("./assets/items_buildings/grip_frozen.png").getImage();
		}else{
			return null;
		}
	}
}
