package Items;

import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;

/**
 * T�r�keny �s� Shovel oszt�ly lesz�rmazottja.
 * @author Norbi
 */
public class LimitedShovel extends Shovel{
	
	/**
	 * �s� tov�bbi haszn�latainak sz�ma
	 */
	private int remainingUses;
	
	/**
	 * Konstruktor, be�llitja a k�peket
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
	 * Amennyiben a remainingUses �rt�ke nagyobb mint nulla, akkor 2
	 * egys�gnyi h�r�teget elt�vol�t a j�t�kos mez�j�r�l, ha van rajta h�. Ezut�n a remainingUses
	 * �rt�ke eggyel cs�kken.
	 * @param p a j�t�kos aki haszn�lja a limit�lt �s�t.
	 * @author Norbi
	 */
	public void use(Player p) {
		if(remainingUses > 0 && p.getField().digSnow(2)){
				p.drainStamina();
				remainingUses--;
		}
	}
	
	/**
	 * Visszaadja a t�rgy nev�t.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Copper Shovel (" + remainingUses + " uses left)";
	}
}