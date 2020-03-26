package Map;
import Player.Player;

public class Hole extends Field 
{
	
//Nem elég egyszer ?	
//	public void acceptPlayer(Player p)
//	{
		
//	}
	
	public void acceptPlayer(Player p)
	{
		System.out.println("Hole.acceptPlayer");
		p.setIsDrowning(true);
		p.setField(this);
	}
}
