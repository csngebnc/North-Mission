package Map.Buildings;

import Items.Item;
import Map.Field;
import Player.Player;

public class Tent implements Item, Building{
	
	public Tent() {}

	@Override
	public void use(Player p) {
		if(p.getField().buildBuilding(this)) {
			p.removeItem(this);
			p.drainStamina();
		}
	}

	/*
	 * A tick() metodus jelen esetben true ertekkel ter vissza, mivel egy sator elettartama egy korre szol.
	 * @author Csonge Bence
	 */
	@Override
	public boolean tick() {
		return true;
	}

	/*
	 * Az attack() metodus jelen esetben true ertekkel ter vissza, mivel egy olyan mezon meg lehet jatekosokat megtamadni,
	 * ahol sator van felepítve.
	 * @author Csonge Bence
	 */
	@Override
	public boolean attack() {
		return true;
	}

	/*
	 * A sator peldany eldobasa egy mezore, mely atveszi a peldanyt.
	 * @author Csonge Bence
	 */
	@Override
	public boolean throwTo(Field f) {
		f.acceptItem(this);
		return true;
	}

	@Override
	public void pickUp() {
		return;
	}

	/*
	 * Teszteleshez
	 */
	@Override
	public void Properties() {
		System.out.println(this.getClass());
	}


}
