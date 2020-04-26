package Items;
import Core.Main;
import Map.Field;
import Player.Player;

/**
 * Egy tárgy, aminek segítségével a használó játékos két egységnyi hóréteget képes eltávolítani egy mezõrõl.
 * @author Norbi
 */
public class Shovel extends Throwable
{
	 
	/**
	 * Ásó használatával eltávolítható két egységnyi hóréteg a mezõrõl, amelyen a játékos áll,
	 * és ha a mezõn van hó. 
	 * @param p a játékos aki használja az ásót.
	 * @author Norbi
	 */
	public void use(Player p) 
	{
		if(p.getField().digSnow(2))
		{
			p.drainStamina();
		}
	}
	
}
