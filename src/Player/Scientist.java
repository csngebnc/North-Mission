package Player;

import Core.Main;
import Map.Field;
import Map.IceField;

/**
 * A sarkkutató kasztú játékost reprezentáló osztály.
 * A Player osztály leszármazottja.
 * @author Zalan
 */
public class Scientist extends Player 
{	
	/**
	 * Sarkkutató karakter speciális képességének használata. 
	 * Meghívja a mezõje revealLimit metódusát, és csökkenti a stamináját 1-gyel.
	 * @author Zalan
	 */
	public void doSkill() 
	{
		field.revealLimit();
		drainStamina();
	}
}
