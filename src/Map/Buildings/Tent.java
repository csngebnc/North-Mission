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
	 * A tick() metódus jelen esetben true értékkel tér vissza, mivel egy sátor élettartama egy körre szól.
	 * @author Csonge Bence
	 */
	@Override
	public boolean tick() {
		return true;
	}

	/*
	 * Az attack() metódus jelen esetben true értékkel tér vissza, mivel egy olyan mezõn meg lehet játékosokat megtámadni,
	 * ahol sátor van felépítve.
	 * @author Csonge Bence
	 */
	@Override
	public boolean attack() {
		return true;
	}

	/*
	 * A sátor példány eldobása egy mezõre, mely átveszi a példányt.
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
	 * Teszteléshez
	 */
	@Override
	public void Properties() {
		System.out.println(this.getClass());
	}


}
