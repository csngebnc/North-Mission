package Player;

import java.awt.Image;

import javax.swing.ImageIcon;

import Visual.RevealDialog;

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
		health = 4;
		sprites = new Image[4];
		sprites[0]= new ImageIcon("./assets/characters/scientist_standing.png").getImage();
		sprites[1] = new ImageIcon("./assets/characters/scientist_drowning.png").getImage();
		sprites[2]= new ImageIcon("./assets/characters/scientist_standing_dsuit.png").getImage();
		sprites[3] = new ImageIcon("./assets/characters/scientist_drowning_dsuit.png").getImage();
	}
	
	/**
	 * Sarkkutat� speci�lis k�pess�ge. Megjelen�t egy ir�nyv�laszt� ablakot, melyben a kiv�lasztott ir�ny� szomsz�dra felfedi a teherb�r�st.
	 * @author Csonge Bence
	 */
	public void doSkill() 
	{
		new RevealDialog(this);
	}
	
}
