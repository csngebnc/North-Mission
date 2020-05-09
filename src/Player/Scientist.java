package Player;

import javax.swing.ImageIcon;

import Core.Main;
import Map.Field;
import Map.IceField;
import Visual.View;

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
	public void doSkill() 
	{
		field.revealLimit();
		drainStamina();
	}

	@Override
	public void draw(View v) {
		int mennyit = (52/field.getCharacters().size()) * 
				(int)Math.pow(-1, field.getCharacters().indexOf(this)) *
				(int)(Math.ceil(((double)field.getCharacters().indexOf(this))/2));
		if(!field.hasBuilding()) {
			if(isDrowning) {
				v.drawThing(field.GetX()+40+mennyit, field.GetY()+8, new ImageIcon("./assets/characters/eskimo_drowning.png").getImage());
			}else {
				v.drawThing(field.GetX()+36+mennyit, field.GetY(), new ImageIcon("./assets/characters/eskimo_standing.png").getImage());
			}
		}
	}
	
}
