package Player;

import javax.swing.ImageIcon;

import Core.Main;
import Items.Item;
import Map.Field;
import Map.IceField;
import Map.Buildings.Igloo;
import Visual.View;

/**
 * Az eszkim� kaszt� j�t�kost reprezent�l� oszt�ly.
 * A Player oszt�ly lesz�rmazottja.
 * @author Zalan
 */
public class Eskimo extends Player 
{
	
	/**
	 * A builtIgloo attrib�tum igaz �rt�ke jelzi, hogy az eszkim� �p�tett-e m�r iglut.
	 * @author Zalan
	 */
	private boolean builtIgloo;
	
	/**
 	 * Eszkim� karakter speci�lis k�pess�g�nek haszn�lata.
 	 * Iglut �p�t a mez�n, ha m�g kor�bban nem �p�tett volna, �s hogyha a mez�re lehet iglut �p�teni.
 	 * Ekkor az eszkim� stamin�ja 1-gyel cs�kken.
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
	 * Tesztel�shez
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

	@Override
	public void draw(View v) {
		if(!field.hasBuilding()) {
			if(isDrowning) {
				v.drawThing(field.GetX()+40, field.GetY()+8, new ImageIcon("./assets/characters/eskimo_drowning.png").getImage());
			}else {
				v.drawThing(field.GetX()+36, field.GetY(), new ImageIcon("./assets/characters/eskimo_standing.png").getImage());
			}
		}
	}

}
