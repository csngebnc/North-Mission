package Map.Buildings;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Items.Item;
import Items.Throwable;
import Player.Player;
import Visual.ImgType;

/**
 * S�tort reprezent�l� oszt�ly
 * @author Csonge Bence
 */
public class Tent extends Throwable implements Building{
	/**
	 * Konstruktor, bet�lti a s�torhoz tartoz� k�peket
	 * @author Csonge Bence
	 */
	public Tent() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/tent_item.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/tent_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/tent.png").getImage();
	}
	/**
	 * T�rgyk�nt lehet haszn�lni, haszn�latra megpr�b�ljuk fel�llitani a j�t�kos mezej�n
	 * @author Csonge Bence
	 */
	public void use(Player p) {
		if(p.getField().buildBuilding(this)) {
			p.removeItem(this);
			p.drainStamina();
		}
	}

	/**
	 * Mivel a s�tor nem robosztus, tick-el�s sor�n t�nkre fog menni, true-val t�r vissza
	 * @author Csonge Bence
	 */
	@Override
	public boolean tick() {
		return true;
	}

	/**
	 * Mivel a s�tor nem robosztus, lehet t�madni, nem megv�di a j�t�kosokat, false-al t�r vissza
	 * @author Csonge Bence
	 */
	@Override
	public boolean attack() {
		return true;
	}
	
	/**
	 * Visszaadja a s�tor nev�t
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Tent";
	}
	
	/**
	 * Megadott sz�m� p�ld�nyt �ll�t el� az oszt�lyb�l.
	 * @author Csonge Bence
	 */
	public ArrayList<Item> generateInstances(int count) throws IllegalAccessException, InstantiationException {
        ArrayList<Item> array = new ArrayList<Item>();
        for (int i = 0; i < count; i++) {
            array.add(this.getClass().newInstance());
        }
        return array;
    }
}
