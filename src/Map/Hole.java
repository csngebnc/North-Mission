package Map;
import Core.Main;
import Player.Player;

public class Hole extends Field 
{
	//Lyukba ker�lt j�t�kos fuldokl�s�t be�ll�tja.
	public void acceptPlayer(Player p)
	{
		System.out.println(Main.tabok+"->[Hole].acceptPlayer(Player p)");
		System.out.println(Main.tabok+"<-[Hole].acceptPlayer(Player p)");
		p.setIsDrowning(true);
		p.setField(this);
	}
}
