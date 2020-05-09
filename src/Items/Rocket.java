package Items;

import java.awt.Image;

import javax.swing.ImageIcon;

import Visual.ImgType;

/**
 * Pisztoly rakétáját reprezentálja
 * @author Norbi
 */
public class Rocket extends GunPart
{
	@Override
	public Image getImg(ImgType form) {
		if(form==ImgType.DROPPED) {
			return new ImageIcon("./assets/items_buildings/rocket.png").getImage();
		}else if(form==ImgType.FROZEN) {
			return new ImageIcon("./assets/items_buildings/rocket_frozen.png").getImage();
		}else{
			return null;
		}
	}
}
