package Items;
import java.util.Scanner;

import Core.Main;
import Player.Player;

public class DivingSuit extends Throwable
{
	/*
	 *Ennek a f�ggv�nynek a seg�ts�g�vel tudjuk felvenni a b�v�rruh�t magunkra.
	 *Ha m�r van rajtunk egy, akkor nem t�rt�nik semmi, ha m�g nincs akkor elt�vol�tja mag�t a Player lelt�r�b�l, 
	 *be�ll�tja a dSuitOn attrib�tum�t true-ra �s levon egyet a stamin�j�b�l.
	 * 
	 * @author Norbi
	 * @param p a j�t�kos aki haszn�lja a b�v�rruh�t.
	 */
	public void use(Player p) 
	{
		if(!p.getdSuitOn())
		{
			p.changeSuit(this);
			p.setdSuitOn(true);
			p.drainStamina();
		}
	}
}
