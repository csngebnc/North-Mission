package Items;
import Core.Main;
import Map.Field;
import Player.Player;

public interface Item 
{
	// T�rgy felv�tele
	public void use(Player p);
	
	// Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	public abstract boolean throwTo(Field f);
	
	// Lesz�rmazottak saj�t maguk val�s�tj�k meg.
	public abstract void pickUp();
}
