package Items;

import java.awt.Image;

import javax.swing.ImageIcon;

import Core.Game;
import Player.Player;
import Visual.ImgType;

/**
 * Pisztolycs�vet reprezent�l� oszt�ly
 * @author Norbi
 */
public class Barrel extends GunPart
{
	/**
	 * Visszaadja az alkatr�sz azon k�p�t, amelyre sz�ks�g van a kirajzol�shoz.
	 * @param form Lehets�ges form�k: befagyott, f�ld�n l�v�.
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
	 * Visszaadja a t�rgy nev�t.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Gun Barrel";
	}
}