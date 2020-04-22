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
	}
	
	// Igluépítés beállítása.
	private void setbuiltIgloo(boolean expression) {
		System.out.println(Main.tabok+"->[Eskimo].setbuiltIgloo(true)");
		System.out.println(Main.tabok+"<-[Eskimo].setbuiltIgloo(true)");
	}

	@Override
	public void drown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean save(Field f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
