package Map;
import Core.Main;
import Player.Player;

public class Hole extends Field 
{
	//Norbi
	public void acceptPlayer(Player p)
	{
		System.out.println(Main.tabok+"->[Hole].acceptItem(Player p)");
		System.out.println(Main.tabok+"<-[Hole].acceptItem(Player p)");
		p.setIsDrowning(true);
		p.setField(this);
	}
}
