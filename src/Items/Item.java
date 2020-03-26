package Items;
import Map.Field;
import Player.Player;

public abstract class Item {
	
	public void use(Player p) {
	}
	
	public abstract boolean throwTo(Field f);
	
	public void pickUp() {
	}
}
