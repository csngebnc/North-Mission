package Map;
import Core.Main;
import Player.Player;

public class Hole extends Field 
{
	//Lyukba került játékos fuldoklását beállítja.
	public void acceptPlayer(Player p)
	{
		System.out.println(Main.tabok+"->[Hole].acceptPlayer(Player p)");
		System.out.println(Main.tabok+"<-[Hole].acceptPlayer(Player p)");
		p.setIsDrowning(true);
		p.setField(this);
	}
}
