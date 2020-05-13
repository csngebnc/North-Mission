package Items;

import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;

/**
 * Egy t�rgy, aminek seg�ts�g�vel a haszn�l� j�t�kos k�t egys�gnyi h�r�teget k�pes elt�vol�tani egy mez�r�l.
 * @author Norbi
 */
public class Shovel extends Throwable{
	
	/**
	 * Konstruktor, be�llitja a k�peket
	 * @author Balczer Dominik
	 */
	public Shovel() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/shovel.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/shovel_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/shovel.png").getImage();
	} 
	
	/**
	 * �s� haszn�lat�val elt�vol�that� k�t egys�gnyi h�r�teg a mez�r�l, amelyen a j�t�kos �ll,
	 * �s ha a mez�n van h�. 
	 * @param p a j�t�kos aki haszn�lja az �s�t.
	 * @author Norbi
	 */
	public void use(Player p) {
		if(p.getField().digSnow(2))
			p.drainStamina();
	}
	
	/**
	 * Visszaadja a t�rgy nev�t.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Iron Shovel";
	}
}
