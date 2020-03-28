package Player;

import Core.Main;
import Map.Field;
import Map.IceField;

public class Eskimo extends Player 
{
	private boolean builtIgloo;

	//Bence
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
	
	//Bence
	private void setbuiltIgloo(boolean expression) {
		System.out.println(Main.tabok+"->[Eskimo].setbuiltIgloo(true)");
		System.out.println(Main.tabok+"<-[Eskimo].setbuiltIgloo(true)");
	}
}
