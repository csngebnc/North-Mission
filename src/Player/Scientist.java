package Player;

import Core.Main;
import Map.Field;
import Map.IceField;

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
}
