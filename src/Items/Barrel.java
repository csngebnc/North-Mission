package Items;

import java.awt.Image;

import javax.swing.ImageIcon;

import Core.Game;
import Player.Player;
import Visual.ImgType;

/**
 * Pisztolycsövet reprezentáló osztály
 * @author Norbi
 */
public class Barrel extends GunPart
{
	/**
	 * Visszaadja az alkatrész azon képét, amelyre szükség van a kirajzoláshoz.
	 * @param form Lehetséges formák: befagyott, földön lévõ.
	 * @author Csonge Bence
	 */
	@Override
	public Image getImg(ImgType form) {
		if(form==ImgType.DROPPED) {
			return new ImageIcon("./assets/items_buildings/barrel.png").getImage();
		}else if(form==ImgType.FROZEN) {
			return new ImageIcon("./assets/items_buildings/barrel_frozen.png").getImage();
		}else{
			return null;
		}
	}
	
	/**
	 * Visszaadja a tárgy nevét.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Gun Barrel";
	}
}