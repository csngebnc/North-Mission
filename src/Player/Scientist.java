package Player;

import Core.Main;
import Map.Field;
import Map.IceField;

public class Scientist extends Player 
{
	// Sarkkutat� karakter speci�lis k�pess�g�nek haszn�lata.
	public void doSkill() 
	{
		System.out.println(Main.tabok+"->[Scientist].doSkill()");
		Main.tabok+="\t";
		
		Field f = new IceField();
		f.getNeighbours();
		f.revealLimit();
		this.drainStamina();
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Scientist].doSkill()");
	}
}
