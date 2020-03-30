package Player;

import Core.Main;
import Map.Field;
import Map.IceField;

public class Eskimo extends Player 
{
	private boolean builtIgloo;

	// Eszkim� j�t�kos iglut �p�t a mez�n, ha m�g kor�bban nem �p�tett volna.
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
	
	// Iglu�p�t�s be�ll�t�sa.
	private void setbuiltIgloo(boolean expression) {
		System.out.println(Main.tabok+"->[Eskimo].setbuiltIgloo(true)");
		System.out.println(Main.tabok+"<-[Eskimo].setbuiltIgloo(true)");
	}
}
