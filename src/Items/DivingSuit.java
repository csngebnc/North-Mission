package Items;
import java.util.Scanner;

import Core.Main;
import Player.Player;

public class DivingSuit extends Throwable
{
	/*
	 *Ennek a függvénynek a segítségével tudjuk felvenni a búvárruhát magunkra.
	 *Ha már van rajtunk egy, akkor nem történik semmi, ha még nincs akkor eltávolítja magát a Player leltárából, 
	 *beállítja a dSuitOn attribútumát true-ra és levon egyet a staminájából.
	 * 
	 * @author Norbi
	 * @param p a játékos aki használja a búvárruhát.
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
