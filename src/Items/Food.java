package Items;
import Core.Main;
import Player.Player;

public class Food extends Throwable 
{
	/* 
	 * Egy élelem elfogyasztásával eggyel nõ a játékos élete.
	 * Ennek a függvénynek a meghívása esetén a tárgy megnöveli a
	 * paraméterként kapott játékos testhõjét eggyel.
	 * 
	 * @author Norbi
	 * @param p a játékos aki használja az ételt.
	 */
	public void use(Player p) 
	{
		p.alterHealth(1);
		p.drainStamina();
		p.removeItem(this);
	}
}
