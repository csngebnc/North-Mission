package Map;
import Core.Main;
import Player.Player;

public class UnstableField extends IceField
{
	// Jelenleg forgatókönyv alapján átforduló instabil mezõ.
	public void acceptPlayer(Player p) 
	{
		System.out.println(Main.tabok+"->[UnstableField].acceptPlayer(Player p)");
		// Késõbb itt ellenõrzés, hogy túllépte-e a teherbírást a játékosok száma a mezõn.
		p.alterHealth(-150);
		
		p.setField(this);

		System.out.println(Main.tabok+"<-[UnstableField].acceptPlayer(Player p)");
	}
}
