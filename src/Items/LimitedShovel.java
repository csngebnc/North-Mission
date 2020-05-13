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
	
	public LimitedShovel() {
		remainingUses = 3;
	}
	
	/**
	 * Amennyiben a remainingUses értéke nagyobb mint nulla, akkor 2
	 * egységnyi hóréteget eltávolít a játékos mezõjérõl, ha van rajta hó. Ezután a remainingUses
	 * értéke eggyel csökken.
	 * @param p a játékos aki használja a limitált ásót.
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
	 * Visszaadja a tárgy nevét.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Copper Shovel (" + remainingUses + " uses left)";
	}
	
	/**
	 * Visszaadja az alkatrész azon képét, amelyre szükség van a kirajzoláshoz.
	 * @param form Lehetséges formák: befagyott, földön lévõ.
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
