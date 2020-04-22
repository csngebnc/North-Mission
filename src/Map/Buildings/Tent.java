package Map.Buildings;

import Items.Item;
import Map.Field;
import Player.Player;

public class Tent implements Item, Building{

	@Override
	public void use(Player p) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean tick() {
		return true;
	}

	@Override
	public boolean attack() {
		return true;
	}

	@Override
	public boolean throwTo(Field f) {
		f.acceptItem(this);
		return true;
	}

	@Override
	public void pickUp() {
		return;
	}


}
