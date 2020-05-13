package Player;

import java.awt.Image;

import javax.swing.ImageIcon;

import Visual.RevealDialog;

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
		health = 4;
		sprites = new Image[4];
		sprites[0]= new ImageIcon("./assets/characters/scientist_standing.png").getImage();
		sprites[1] = new ImageIcon("./assets/characters/scientist_drowning.png").getImage();
		sprites[2]= new ImageIcon("./assets/characters/scientist_standing_dsuit.png").getImage();
		sprites[3] = new ImageIcon("./assets/characters/scientist_drowning_dsuit.png").getImage();
	}
	
	/**
	 * Sarkkutató speciális képessége. Megjelenít egy irányválasztó ablakot, melyben a kiválasztott irányú szomszédra felfedi a teherbírást.
	 * @author Csonge Bence
	 */
	public void doSkill() 
	{
		new RevealDialog(this);
	}
	
}
