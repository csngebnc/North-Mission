package Items;

import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;

/**
 * 
 * @author Norbi
 * �telt reprezent�l� oszt�ly.
 */
public class Food extends Throwable {
	
	/**
	 * Konstruktor, be�llitja a k�peket
	 * @author Balczer Dominik
	 */
	public Food() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/food.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/food_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/food.png").getImage();
	}
	
	/**
	 * Egy �lelem elfogyaszt�s�val eggyel n� a j�t�kos �lete.
	 * Ennek a f�ggv�nynek a megh�v�sa eset�n a t�rgy megn�veli a
	 * param�terk�nt kapott j�t�kos testh�j�t eggyel.
	 * @param p a j�t�kos aki haszn�lja az �telt.
	 * @author Norbi
	 */
	public void use(Player p) {
		p.alterHealth(1);
		p.drainStamina();
		p.removeItem(this);
	}
	
	/**
	 * Visszaadja a t�rgy nev�t.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Food Ration";
	}
}