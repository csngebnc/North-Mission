package Items;

import Player.Player;

/**
 * 
 * @author Norbi
 * T�r�keny �s� Shovel oszt�ly lesz�rmazottja.
 */
public class LimitedShovel extends Shovel{
	
	/**
	 * �s� tov�bbi haszn�latainak sz�ma
	 */
	private int remainingUses;
	
	public LimitedShovel() {
		remainingUses = 3;
	}
	
	/**
	 * Amennyiben a remainingUses �rt�ke nagyobb mint nulla, akkor 2
	 * egys�gnyi h�r�teget elt�vol�t a j�t�kos mez�j�r�l, ha van rajta h�. Ezut�n a remainingUses
	 * �rt�ke eggyel cs�kken.
	 *
	 * @author Norbi
	 * @param p a j�t�kos aki haszn�lja a limit�lt �s�t.
	 */
	public void use(Player p) 
	{
		if(remainingUses > 0 && p.getField().digSnow(2))
		{
				p.drainStamina();
				remainingUses--;
		}
	}
}
