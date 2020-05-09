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
