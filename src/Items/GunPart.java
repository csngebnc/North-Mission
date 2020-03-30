package Items;
import Core.Game;
import Core.Main;
import Map.Field;
import Player.Player;

public abstract class GunPart extends Item 
{
	// Az �s�nek haszn�l met�dus�t h�vja.
	public void use(Player p) 
	{
		super.use(p);;
	}
	
	//Alap�rtelmezetten false �rt�kkel t�r vissza, mivel egy alkatr�sz nem eldobhat�.
	public boolean throwTo(Field f) 
	{
		return false;
	}
	
	// Amennyiben felveszik, akkor a sz�l a j�t�knak, hogy megtal�ltak egy alkatr�szt.
	public void pickUp() 
	{
		System.out.println(Main.tabok+"->[GunPart].pickUp()");
		Main.tabok+="\t";
		Game.incGunParts();
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[GunPart].pickUp()");
	}
}
