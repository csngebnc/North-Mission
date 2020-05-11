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
	
	public Eskimo() {
		super();
		img = new Image[4];
		img[0]= new ImageIcon("./assets/characters/eskimo_standing.png").getImage();
		img[1] = new ImageIcon("./assets/characters/eskimo_drowning.png").getImage();
		img[2] = new ImageIcon("./assets/characters/eskimo_standing_dsuit.png").getImage();
		img[3] = new ImageIcon("./assets/characters/eskimo_drowning_dsuit.png").getImage();
	}
	
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


}
