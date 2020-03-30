package Items;
import Core.Main;
import Map.Field;
import Player.Player;


public class Shovel extends Throwable
{
	// �s� haszn�lat�val elt�vol�that� k�t egys�gnyi h�r�teg a mez�r�l, amelyen a j�t�kos �ll,
	// ha a mez�n van h�.
	public void use(Player p) 
	{
		System.out.println(Main.tabok+"->[Shovel].use()");
		Main.tabok+="\t";
		Field f = p.getField();
		f.digSnow(2);
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Shovel].use()");
	}
	
}
