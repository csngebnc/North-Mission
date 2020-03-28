package Items;
import java.util.Scanner;

import Core.Main;
import Player.Player;

public class DivingSuit extends Throwable
{
	//Dani (Dominik)
	public void use(Player p) 
	{
		System.out.println(Main.tabok+"->[DivingSuit].use(Player p)");
		Main.tabok+="\t";
		//Ha nincs a p Playeren DivingSuit, akkor tud felhúzni egyet.
		if(p.changeSuit(this))
		{
			p.drainStamina();
		}
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[DivingSuit].use(Player p)");
	}
}
