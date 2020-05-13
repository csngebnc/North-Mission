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
	
	public LimitedShovel() {
		remainingUses = 3;
	}
	
	/**
	 * Amennyiben a remainingUses �rt�ke nagyobb mint nulla, akkor 2
	 * egys�gnyi h�r�teget elt�vol�t a j�t�kos mez�j�r�l, ha van rajta h�. Ezut�n a remainingUses
	 * �rt�ke eggyel cs�kken.
	 * @param p a j�t�kos aki haszn�lja a limit�lt �s�t.
	 * @author Norbi
	 */
	public void use(Player p) 
	{
		if(remainingUses > 0 && p.getField().digSnow(2))
		{
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
	
	/**
	 * Visszaadja az alkatr�sz azon k�p�t, amelyre sz�ks�g van a kirajzol�shoz.
	 * @param form Lehets�ges form�k: befagyott, f�ld�n l�v�.
	 * @author Csonge Bence
	 */
	@Override
	public Image getImg(ImgType form) {
		if(form==ImgType.DROPPED) {
			return new ImageIcon("./assets/items_buildings/limited_shovel.png").getImage();
		}else if(form==ImgType.FROZEN) {
			return new ImageIcon("./assets/items_buildings/limited_shovel_frozen.png").getImage();
		}else{
			return null;
		}
	}
}
