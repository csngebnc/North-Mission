package Player;

import Core.Main;
import Items.Item;
import Map.Field;
import Map.IceField;
import Map.Buildings.Igloo;

public class Eskimo extends Player 
{
	private boolean builtIgloo;
	
	/*
 	 * Eszkimó karakter speciális képességének használata.
 	 * Iglut épít a mezõn, ha még korábban nem épített volna, és hogyha  a mezõre lehet iglut építeni.
 	 * Ekkor az eszkimó staminája 1-gyel csökken.
	 * @author Zalan
	 */
	public void doSkill() 
	{
		if (!builtIgloo) 
			if (field.buildBuilding(new Igloo())) {
				builtIgloo = true;
				drainStamina();
			}
	}
	
	/*
	 * Teszteléshez
	 */
	@Override
	public void Properties()
	{
		System.out.println(this.getClass());
		System.out.println("Name: " + getName());
		System.out.println("Health: " + health);
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
