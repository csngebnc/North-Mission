package Items;
import Core.Main;
import Player.Player;

public class Food extends Throwable 
{
	/* 
	 * Egy �lelem elfogyaszt�s�val eggyel n� a j�t�kos �lete.
	 * Ennek a f�ggv�nynek a megh�v�sa eset�n a t�rgy megn�veli a
	 * param�terk�nt kapott j�t�kos testh�j�t eggyel.
	 * 
	 * @author Norbi
	 * @param p a j�t�kos aki haszn�lja az �telt.
	 */
	public void use(Player p) 
	{
		p.alterHealth(1);
		p.drainStamina();
		p.removeItem(this);
	}
}
