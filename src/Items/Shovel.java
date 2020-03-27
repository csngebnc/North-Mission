package Items;
import Player.Player;


public class Shovel extends Throwable
{
	//Dominik
	public void use(Player p) 
	{
		System.out.println("Shovel.use()");
		p.getField().digSnow(2);
	}
	
}
