package Items;
import Core.Main;
import Player.Player;

public class Food extends Throwable 
{
	//Dani
	public void use(Player p) 
	{
		System.out.println(Main.tabok+"->[Food].use()");
		Main.tabok+="\t";
		p.alterHealth(1);
		
		p.drainStamina();
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Food].use()");
	}
}
