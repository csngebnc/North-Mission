package Map;
import Player.Player;

public class UnstableField extends IceField
{
	public void acceptPlayer(Player p) 
	{
		System.out.println("UnstableField.acceptPlayer");
		if(maxplayers < players.size()) 
		{
			p.alterHealth(-150);
		}
		
		p.setField(this);
		
	}
}
