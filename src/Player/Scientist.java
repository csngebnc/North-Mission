package Player;

import java.awt.Image;

import javax.swing.ImageIcon;

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
	public Scientist() {
		super();
		img = new Image[2];
		img[0]= new ImageIcon("./assets/characters/scientist_standing.png").getImage();
		img[1] = new ImageIcon("./assets/characters/scientist_drowning.png").getImage();
	}
	
	public void doSkill() 
	{
		field.revealLimit(this);
	}
	
}
