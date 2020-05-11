package Items;
import java.awt.Image;

import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;

/**
 * Egy tárgy, aminek segítségével a használó játékos két egységnyi hóréteget képes eltávolítani egy mezõrõl.
 * @author Norbi
 */
public class Shovel extends Throwable
{
	 
	/**
	 * Ásó használatával eltávolítható két egységnyi hóréteg a mezõrõl, amelyen a játékos áll,
	 * és ha a mezõn van hó. 
	 * @param p a játékos aki használja az ásót.
	 * @author Norbi
	 */
	public void use(Player p) 
	{
		if(p.getField().digSnow(2))
		{
			p.drainStamina();
		}
	}
	
	@Override
	public Image getImg(ImgType form) {
		if(form==ImgType.DROPPED) {
			return new ImageIcon("./assets/items_buildings/shovel.png").getImage();
		}else if(form==ImgType.FROZEN) {
			return new ImageIcon("./assets/items_buildings/shovel_frozen.png").getImage();
		}else{
			return null;
		}
	}
	
}
