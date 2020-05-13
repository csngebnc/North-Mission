package Map.Buildings;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Items.Item;
import Items.Throwable;
import Player.Player;
import Visual.ImgType;

/**
 * Sátort reprezentáló osztály
 * @author Csonge Bence
 */
public class Tent extends Throwable implements Building{
	/**
	 * Konstruktor, betölti a sátorhoz tartozó képeket
	 * @author Csonge Bence
	 */
	public Tent() {
		sprites = new Image[3];
		sprites[ImgType.DROPPED.VALUE] = new ImageIcon("./assets/items_buildings/tent_item.png").getImage();
		sprites[ImgType.FROZEN.VALUE] = new ImageIcon("./assets/items_buildings/tent_frozen.png").getImage();
		sprites[ImgType.BUILT.VALUE] = new ImageIcon("./assets/items_buildings/tent.png").getImage();
	}
	/**
	 * Tárgyként lehet használni, használatra megpróbáljuk felállitani a játékos mezején
	 * @author Csonge Bence
	 */
	public void use(Player p) {
		if(p.getField().buildBuilding(this)) {
			p.removeItem(this);
			p.drainStamina();
		}
	}

	/**
	 * Mivel a sátor nem robosztus, tick-elés során tönkre fog menni, true-val tér vissza
	 * @author Csonge Bence
	 */
	@Override
	public boolean tick() {
		return true;
	}

	/**
	 * Mivel a sátor nem robosztus, lehet támadni, nem megvédi a játékosokat, false-al tér vissza
	 * @author Csonge Bence
	 */
	@Override
	public boolean attack() {
		return true;
	}
	
	/**
	 * Visszaadja a sátor nevét
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Tent";
	}
	
	/**
	 * Megadott számú példányt állít elõ az osztályból.
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
