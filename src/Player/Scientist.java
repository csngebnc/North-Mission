package Player;

import javax.swing.ImageIcon;

import Core.Main;
import Map.Field;
import Map.IceField;
import Visual.View;

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
