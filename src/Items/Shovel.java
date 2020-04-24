package Items;
import Core.Main;
import Map.Field;
import Player.Player;


public class Shovel extends Throwable
{
	 
	/*
	 * �s� haszn�lat�val elt�vol�that� k�t egys�gnyi h�r�teg a mez�r�l, amelyen a j�t�kos �ll,
	 * �s ha a mez�n van h�. 
	 * 
	 * @author Norbi
	 * @param p a j�t�kos aki haszn�lja az �s�t.
	 */
	public void use(Player p) 
	{
		if(p.getField().digSnow(2))
		{
			p.drainStamina();
		}
	}
	
}
