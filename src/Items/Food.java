package Items;
import java.awt.Image;

import javax.swing.ImageIcon;

import Core.Main;
import Player.Player;
import Visual.ImgType;

/**
 * 
 * @author Norbi
 * Ételt reprezentáló osztály.
 */
public class Food extends Throwable 
{
	/**
	 * Egy élelem elfogyasztásával eggyel nõ a játékos élete.
	 * Ennek a függvénynek a meghívása esetén a tárgy megnöveli a
	 * paraméterként kapott játékos testhõjét eggyel.
	 * @param p a játékos aki használja az ételt.
	 * @author Norbi
	 */
	public void use(Player p) 
	{
		p.alterHealth(1);
		p.drainStamina();
		p.removeItem(this);
	}
	
	@Override
	public Image getImg(ImgType form) {
		if(form==ImgType.DROPPED) {
			return new ImageIcon("./assets/items_buildings/food_frozen.png").getImage();
		}else if(form==ImgType.FROZEN) {
			return new ImageIcon("./assets/items_buildings/food_frozen.png").getImage();
		}else{
			return null;
		}
	}
}
