package Player;

import java.awt.Image;
import javax.swing.ImageIcon;
import Map.Buildings.Igloo;

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
		health = 5;
		sprites = new Image[4];
		sprites[0]= new ImageIcon("./assets/characters/eskimo_standing.png").getImage();
		sprites[1] = new ImageIcon("./assets/characters/eskimo_drowning.png").getImage();
		sprites[2]= new ImageIcon("./assets/characters/eskimo_standing_dsuit.png").getImage();
		sprites[3] = new ImageIcon("./assets/characters/eskimo_drowning_dsuit.png").getImage();
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
}
