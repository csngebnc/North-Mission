package Player;

import Core.Main;
import Items.Item;
import Map.Field;
import Map.IceField;

public class Eskimo extends Player 
{
	private boolean builtIgloo;

	// Eszkim� j�t�kos iglut �p�t a mez�n, ha m�g kor�bban nem �p�tett volna.
	public void doSkill() 
	{
	}
	
	// Iglu�p�t�s be�ll�t�sa.
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
	public void collideWith(Character c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hitBy(PolarBear pb) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void Properties()
	{
		System.out.println(this.getClass());
		System.out.println("Helth: " + health);
		System.out.println("Stamina: " + stamina);
		System.out.println("Is drowning: " + isDrowning);
		System.out.println("Diving suit: " + dSuitOn);
		System.out.println("Built igloo: " + builtIgloo);
		System.out.println("Inventory:");
		for(Item i : inventory) {
			i.Properties();
		}
	}

}
