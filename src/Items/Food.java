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
public class Food extends Throwable 
{
	/**
	 * Egy �lelem elfogyaszt�s�val eggyel n� a j�t�kos �lete.
	 * Ennek a f�ggv�nynek a megh�v�sa eset�n a t�rgy megn�veli a
	 * param�terk�nt kapott j�t�kos testh�j�t eggyel.
	 * @param p a j�t�kos aki haszn�lja az �telt.
	 * @author Norbi
	 */
	public void use(Player p) 
	{
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
	
	/**
	 * Visszaadja az alkatr�sz azon k�p�t, amelyre sz�ks�g van a kirajzol�shoz.
	 * @param form Lehets�ges form�k: befagyott, f�ld�n l�v�.
	 * @author Csonge Bence
	 */
	@Override
	public Image getImg(ImgType form) {
		if(form==ImgType.DROPPED) {
			return new ImageIcon("./assets/items_buildings/food.png").getImage();
		}else if(form==ImgType.FROZEN) {
			return new ImageIcon("./assets/items_buildings/food_frozen.png").getImage();
		}else{
			return null;
		}
	}
}
