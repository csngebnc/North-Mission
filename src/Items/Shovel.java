package Items;
import Core.Main;
import Map.Field;
import Player.Player;

/**
 * 
 * @author Norbi
 * Egy t�rgy, aminek seg�ts�g�vel a haszn�l� j�t�kos k�t egys�gnyi h�r�teget k�pes elt�vol�tani egy mez�r�l.
 */
public class Shovel extends Throwable
{
	 
	/**
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
