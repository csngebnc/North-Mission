package Items;
import Core.Main;
import Map.Field;
import Player.Player;


public class Shovel extends Throwable
{
	 
	/*
	 * Ásó használatával eltávolítható két egységnyi hóréteg a mezõrõl, amelyen a játékos áll,
	 * és ha a mezõn van hó. 
	 * 
	 * @author Norbi
	 * @param p a játékos aki használja az ásót.
	 */
	public void use(Player p) 
	{
		if(p.getField().digSnow(2))
		{
			p.drainStamina();
		}
	}
	
}
