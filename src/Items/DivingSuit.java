package Items;
import Player.Player;

public class DivingSuit extends Throwable
{
	//Dani (Dominik)
	public void use(Player p) 
	{
		System.out.println("DivingSuit.use(Player p)");
		//Ha nincs a p Playeren DivingSuit, akkor tud felhúzni egyet.
		
		if(p.changeSuit(this) == false)
		{
			p.drainStamina();
		}
	}
}
