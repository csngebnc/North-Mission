package Map;
import Core.Main;
import Player.Player;

public class UnstableField extends IceField
{
	//Norbi
	public void acceptPlayer(Player p) 
	{
		System.out.println(Main.tabok+"->[UnstableField].acceptPlayer(Player p)");
		
		p.alterHealth(-150);
		
		p.setField(this);

		System.out.println(Main.tabok+"<-[UnstableField].acceptPlayer(Player p)");
	}
}
