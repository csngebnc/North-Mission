package Items;

import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;
import Visual.SaveDialog;

/**
 * Segítségével egy lyukba esett játékos kimenthetõ. 
 * Ha a mentés sikeres, a játékos stamináját egy egységgel csökkenti
 * @author Norbi
 */
public class Rope extends Throwable{
	
	/**
	 * Konstruktor, beállitja a képeket
	 * @author Balczer Dominik
	 */
	public Rope() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/rope.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/rope_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/rope.png").getImage();
	}
	
	/**
	 *  Egy lyukba esett játékos kimentése.
	 *  @param p a játékos aki használja a kötelet.
	 *  @author Norbi
	 */
	public void use(Player p) {
		new SaveDialog(p);
	}
	
	/**
	 * Visszaadja a tárgy nevét.
	 * @author Csonge Bence
	 */
	public String getName() {
		return "Rope";
	}
}
