package Items;

import Player.Player;

/**
 * 
 * @author Norbi
 * Törékeny ásó Shovel osztály leszármazottja.
 */
public class LimitedShovel extends Shovel{
	
	/**
	 * Ásó további használatainak száma
	 */
	private int remainingUses;
	
	public LimitedShovel() {
		remainingUses = 3;
	}
	
	/**
	 * Amennyiben a remainingUses értéke nagyobb mint nulla, akkor 2
	 * egységnyi hóréteget eltávolít a játékos mezõjérõl, ha van rajta hó. Ezután a remainingUses
	 * értéke eggyel csökken.
	 *
	 * @author Norbi
	 * @param p a játékos aki használja a limitált ásót.
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
