package Items;

import java.awt.Image;

import javax.swing.ImageIcon;

import Player.Player;
import Visual.ImgType;

/**
 * Pisztolycsövet reprezentáló osztály
 * @author Norbi
 */
public class Barrel extends GunPart
{
	/**
	 * Az õsének használ metódusát fogja meghívni.
	 */
	public Barrel() {
		super();
	}
	
	public void use(Player p) {
	}

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
	
	@Override
	public String getName() {
		return "Gun Barrel";
	}
}
