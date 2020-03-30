package Items;
import Core.Main;
import Map.Field;
import Player.Player;


public class Shovel extends Throwable
{
	// Ásó használatával eltávolítható két egységnyi hóréteg a mezõrõl, amelyen a játékos áll,
	// ha a mezõn van hó.
	public void use(Player p) 
	{
		System.out.println(Main.tabok+"->[Shovel].use()");
		Main.tabok+="\t";
		Field f = p.getField();
		f.digSnow(2);
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Shovel].use()");
	}
	
}
