package Items;
import Map.Field;
import Player.Player;

public abstract class GunPart extends Item {
	
	public void use(Player p) {
	}
	
	public boolean throwTo(Field f) {
		return false;
	}
	
	public void pickUp() {
	}
}
