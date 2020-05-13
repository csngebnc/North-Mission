package Items;

import java.awt.Image;

import javax.swing.ImageIcon;

import Visual.ImgType;

/**
 * Pisztoly markolatot reprezentáló osztály.
 * @author Norbi
 */
public class Grip extends GunPart 
{
	/**
	 * Visszaadja a tárgy nevét.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Grip";
	}
	
	/**
	 * Visszaadja az alkatrész azon képét, amelyre szükség van a kirajzoláshoz.
	 * @param form Lehetséges formák: befagyott, földön lévõ.
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
