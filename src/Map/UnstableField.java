package Map;
import Core.Main;
import Player.Player;

public class UnstableField extends IceField
{
	// Jelenleg forgat�k�nyv alapj�n �tfordul� instabil mez�.
	public void acceptPlayer(Player p) 
	{
		System.out.println(Main.tabok+"->[UnstableField].acceptPlayer(Player p)");
		// K�s�bb itt ellen�rz�s, hogy t�ll�pte-e a teherb�r�st a j�t�kosok sz�ma a mez�n.
		p.alterHealth(-150);
		
		p.setField(this);

		System.out.println(Main.tabok+"<-[UnstableField].acceptPlayer(Player p)");
	}
}
