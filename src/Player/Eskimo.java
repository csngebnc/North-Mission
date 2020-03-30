package Player;

import Core.Main;
import Map.Field;
import Map.IceField;

public class Eskimo extends Player 
{
	private boolean builtIgloo;

	// Eszkimó játékos iglut épít a mezõn, ha még korábban nem épített volna.
	public void doSkill() 
	{
		System.out.println(Main.tabok+"->[Eskimo].doSkill()");
		Main.tabok+="\t";
		
		Field f = new IceField();
		f.buildIgloo();
		this.drainStamina();
		this.setbuiltIgloo(true);
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Eskimo].doSkill()");
	}
	
	// Igluépítés beállítása.
	private void setbuiltIgloo(boolean expression) {
		System.out.println(Main.tabok+"->[Eskimo].setbuiltIgloo(true)");
		System.out.println(Main.tabok+"<-[Eskimo].setbuiltIgloo(true)");
	}
}
