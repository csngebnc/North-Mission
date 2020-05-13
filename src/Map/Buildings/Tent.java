package Map.Buildings;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Items.Item;
import Items.Throwable;
import Player.Player;
import Visual.ImgType;

/**
 * A sator epuletet es targyat megvalosito osztaly.
 * @author Csonge Bence
 *
 */
public class Tent extends Throwable implements Building{
	
	public Tent() {}

	/**
	 * Sator hasznalata, azaz megepitese
	 * @author Csonge Bence
	 */
	public void use(Player p) {
		if(p.getField().buildBuilding(this)) {
			p.removeItem(this);
			p.drainStamina();
		}
	}

	/**
	 * A tick() metodus jelen esetben true ertekkel ter vissza, mivel egy sator elettartama egy korre szol.
	 * @author Csonge Bence
	 */
	@Override
	public boolean tick() {
		return true;
	}

	/**
	 * Az attack() metodus jelen esetben true ertekkel ter vissza, mivel egy olyan mezon meg lehet jatekosokat megtamadni,
	 * ahol sator van felep�tve.
	 * @author Csonge Bence
	 */
	@Override
	public boolean attack() {
		return true;
	}
	
	/**
	 * Visszaadja a p�ld�ny nev�t, ami s�tor.
	 * @author Csonge Bence
	 */
	@Override
	public String getName() {
		return "Tent";
	}
	
	/**
	 * Visszaadja a s�tor azon k�p�t, amelyre sz�ks�g van a kirajzol�shoz.
	 * @param form Lehets�ges eldobott, befagyott, vagy egy�bk�nt meg�p�tett s�tor.
	 * @author Csonge Bence
	 */
	@Override
	public Image getImg(ImgType form) {
		if(form==ImgType.DROPPED) {
			return new ImageIcon("./assets/items_buildings/tent_item.png").getImage();
		}else if(form==ImgType.FROZEN) {
			return new ImageIcon("./assets/items_buildings/tent_frozen.png").getImage();
		}else{
			return new ImageIcon("./assets/items_buildings/tent.png").getImage();
		}
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
