package Player;

import java.awt.Image;

import javax.swing.ImageIcon;

import Core.Main;
import Items.Item;
import Map.Field;
import Map.IceField;
import Map.Buildings.Igloo;
import Visual.View;

/**
 * Az eszkimó kasztú játékost reprezentáló osztály.
 * A Player osztály leszármazottja.
 * @author Zalan
 */
public class Eskimo extends Player 
{
	
	/**
	 * A builtIgloo attribútum igaz értéke jelzi, hogy az eszkimó épített-e már iglut.
	 * @author Zalan
	 */
	private boolean builtIgloo;
	
	public Eskimo() {
		super();
		img = new Image[4];
		img[0]= new ImageIcon("./assets/characters/eskimo_standing.png").getImage();
		img[1] = new ImageIcon("./assets/characters/eskimo_drowning.png").getImage();
		img[2] = new ImageIcon("./assets/characters/eskimo_standing_dsuit.png").getImage();
		img[3] = new ImageIcon("./assets/characters/eskimo_drowning_dsuit.png").getImage();
	}
	
	/**
 	 * Eszkimó karakter speciális képességének használata.
 	 * Iglut épít a mezõn, ha még korábban nem épített volna, és hogyha a mezõre lehet iglut építeni.
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
	
	/**
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
