package Items;

import Player.Player;

public class LimitedShovel extends Shovel{

	private int remainingUses;
	
	/*
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
