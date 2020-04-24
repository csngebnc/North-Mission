package Player;

import Core.Main;
import Items.Item;
import Map.Field;
import Map.IceField;
import Map.Buildings.Igloo;

public class Eskimo extends Player 
{
	private boolean builtIgloo;

	// Eszkimó játékos iglut épít a mezõn, ha még korábban nem épített volna, és a mezõre lehet iglut építeni
	public void doSkill() 
	{
		if (!builtIgloo) {
			boolean ok = field.buildBuilding(new Igloo());
			if (ok) {
				builtIgloo = true;
				drainStamina();
			}
		}
	}
	
/*	nincs osztálydiagramban és nem is kell amúgy 
 * * // Igluépítés beállítása.
	private void setbuiltIgloo(boolean expression) {
		System.out.println(Main.tabok+"->[Eskimo].setbuiltIgloo(true)");
		System.out.println(Main.tabok+"<-[Eskimo].setbuiltIgloo(true)");
	}
*/

	
	//Player osztályon belül a helyük
/*
 * 	@Override
	public void drown() {
		// TODO Auto-generated method stub
		
	}
 * 
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
	*/
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
