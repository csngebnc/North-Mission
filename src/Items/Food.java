package Items;
import Player.Player;

public class Food extends Throwable 
{
	//Dani
	public void use(Player p) 
	{
		System.out.println("Food.use");
		
		p.alterHealth(1);
		
		p.drainStamina();
	}
}
