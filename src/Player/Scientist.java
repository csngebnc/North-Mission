package Player;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * A sarkkutat� kaszt� j�t�kost reprezent�l� oszt�ly.
 * A Player oszt�ly lesz�rmazottja.
 * @author Zalan
 */
public class Scientist extends Player 
{	
	/**
	 * Sarkkutat� karakter speci�lis k�pess�g�nek haszn�lata. 
	 * Megh�vja a mez�je revealLimit met�dus�t, �s cs�kkenti a stamin�j�t 1-gyel.
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
