package Items;
import Core.Main;
import Player.Player;

public class Food extends Throwable 
{
	/* Egy �lelem elfogyaszt�s�val eggyel n� a j�t�kos �lete.*/
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
