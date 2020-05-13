package Items;

import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;

/**
 * Egy tárgy, aminek segítségével a használó játékos két egységnyi hóréteget képes eltávolítani egy mezõrõl.
 * @author Norbi
 */
public class Shovel extends Throwable{
	
	/**
	 * Konstruktor, beállitja a képeket
	 * @author Balczer Dominik
	 */
	public Shovel() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/shovel.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/shovel_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/shovel.png").getImage();
	} 
	
	/**
	 * Ásó használatával eltávolítható két egységnyi hóréteg a mezõrõl, amelyen a játékos áll,
	 * és ha a mezõn van hó. 
	 * @param p a játékos aki használja az ásót.
	 * @author Norbi
	 */
	public void use(Player p) {
		if(p.getField().digSnow(2))
			p.drainStamina();
	}
	
	/**
	 * Visszaadja a tárgy nevét.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Iron Shovel";
	}
}
