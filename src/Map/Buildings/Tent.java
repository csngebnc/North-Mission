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
	 * A tick() met�dus jelen esetben true �rt�kkel t�r vissza, mivel egy s�tor �lettartama egy k�rre sz�l.
	 * @author Csonge Bence
	 */
	@Override
	public boolean tick() {
		return true;
	}

	/*
	 * Az attack() met�dus jelen esetben true �rt�kkel t�r vissza, mivel egy olyan mez�n meg lehet j�t�kosokat megt�madni,
	 * ahol s�tor van fel�p�tve.
	 * @author Csonge Bence
	 */
	@Override
	public boolean attack() {
		return true;
	}

	/*
	 * A s�tor p�ld�ny eldob�sa egy mez�re, mely �tveszi a p�ld�nyt.
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
	 * Tesztel�shez
	 */
	@Override
	public void Properties() {
		System.out.println(this.getClass());
	}


}
