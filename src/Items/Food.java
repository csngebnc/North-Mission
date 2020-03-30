package Items;
import Core.Main;
import Player.Player;

public class Food extends Throwable 
{
	/* Egy élelem elfogyasztásával eggyel nõ a játékos élete.*/
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
