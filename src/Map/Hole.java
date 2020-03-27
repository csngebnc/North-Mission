package Map;
import Player.Player;

public class Hole extends Field 
{
	public void acceptPlayer(Player p)
	{
		System.out.println("Hole.acceptPlayer");
		p.setIsDrowning(true);
		p.setField(this);
	}
}
