package Items;

import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;

/**
 * 
 * @author Norbi
 * Ételt reprezentáló osztály.
 */
public class Food extends Throwable {
	
	/**
	 * Konstruktor, beállitja a képeket
	 * @author Balczer Dominik
	 */
	public Food() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/food.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/food_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/food.png").getImage();
	}
	
	/**
	 * Egy élelem elfogyasztásával eggyel nõ a játékos élete.
	 * Ennek a függvénynek a meghívása esetén a tárgy megnöveli a
	 * paraméterként kapott játékos testhõjét eggyel.
	 * @param p a játékos aki használja az ételt.
	 * @author Norbi
	 */
	public void use(Player p) {
		p.alterHealth(1);
		p.drainStamina();
		p.removeItem(this);
	}
	
	/**
	 * Visszaadja a tárgy nevét.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Food Ration";
	}
}