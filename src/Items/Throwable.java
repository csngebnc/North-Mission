package Items;

import java.awt.Image;
import java.util.ArrayList;
import Map.Field;
import Visual.ImgType;

/**
 * Egy absztrakt osztály, az eldobható tárgyak õse. 
 * Mivel a játék során a tárgyak átadás céljából felvétel után ismét eldobhatóak, 
 * így ennek az osztálynak a bevezetése szükséges.
 * @author Norbi 
 */
public abstract class Throwable implements Item {
	
	/**
	 * A tárgyhoz tartozó képek
	 * @author Balczer Dominik
	 */
	Image[] sprites;
	
	/**
	 * Tárgy eldobása egy mezõre. Eldobható tárgy esete.
	 * @param f az a mezõ akire dobjuk a tárgyat.
	 */
	public boolean throwTo(Field f) {
		f.acceptItem(this);
		return true;
	}
	
	/**
	 * Eldobható, nem alkatrész tárgy felvétele.
	 */
	public void pickUp() {	}
	
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
	
	/**
	 * Visszaadja a tárgy képét adott állapotban
	 * @param form : A kép tipusa
	 * @author Balczer Dominik
	 */
	@Override
	public Image getImg(ImgType form) {
		return sprites[form.VALUE];
	}
}