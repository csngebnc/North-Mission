package Items;

import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;

/**
 * Törékeny ásó Shovel osztály leszármazottja.
 * @author Norbi
 */
public class LimitedShovel extends Shovel{
	
	/**
	 * Ásó további használatainak száma
	 */
	private int remainingUses;
	
	/**
	 * Konstruktor, beállitja a képeket
	 * @author Balczer Dominik
	 */
	public LimitedShovel() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/limited_shovel.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/limited_shovel_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/limited_shovel.png").getImage();
		remainingUses = 3;
	}
	
	/**
	 * Amennyiben a remainingUses értéke nagyobb mint nulla, akkor 2
	 * egységnyi hóréteget eltávolít a játékos mezõjérõl, ha van rajta hó. Ezután a remainingUses
	 * értéke eggyel csökken.
	 * @param p a játékos aki használja a limitált ásót.
	 * @author Norbi
	 */
	public void use(Player p) {
		if(remainingUses > 0 && p.getField().digSnow(2)){
				p.drainStamina();
				remainingUses--;
		}
	}
	
	/**
	 * Visszaadja a tárgy nevét.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Copper Shovel (" + remainingUses + " uses left)";
	}
}