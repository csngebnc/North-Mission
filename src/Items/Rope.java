package Items;

import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;
import Visual.SaveDialog;

/**
 * Seg�ts�g�vel egy lyukba esett j�t�kos kimenthet�. 
 * Ha a ment�s sikeres, a j�t�kos stamin�j�t egy egys�ggel cs�kkenti
 * @author Norbi
 */
public class Rope extends Throwable{
	
	/**
	 * Konstruktor, be�llitja a k�peket
	 * @author Balczer Dominik
	 */
	public Rope() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/rope.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/rope_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/rope.png").getImage();
	}
	
	/**
	 *  Egy lyukba esett j�t�kos kiment�se.
	 *  @param p a j�t�kos aki haszn�lja a k�telet.
	 *  @author Norbi
	 */
	public void use(Player p) {
		new SaveDialog(p);
	}
	
	/**
	 * Visszaadja a t�rgy nev�t.
	 * @author Csonge Bence
	 */
	public String getName() {
		return "Rope";
	}
}
