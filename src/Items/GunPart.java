package Items;
import Core.Game;
import Core.Main;
import Map.Field;
import Player.Player;

public abstract class GunPart extends Item 
{
	public void use(Player p) 
	{
		super.use(p);;
	}
	
	public boolean throwTo(Field f) 
	{
		return false;
	}
	
	public void pickUp() 
	{
		System.out.println(Main.tabok+"->[GunPart].pickUp()");
		Main.tabok+="\t";
		Game.incGunParts();
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[GunPart].pickUp()");
	}
}
