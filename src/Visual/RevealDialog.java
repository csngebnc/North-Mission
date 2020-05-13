package Visual;

import Map.Field;
import Player.Player;

/**
 * Mezõ teherbitásának felfedésére használt DirectionDialog
 * @author Balczer Dominik
 */
public class RevealDialog extends DirectionDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor
	 * @param p : A játékos aki a felfedést végzi
	 * @author Balczer Dominik
	 */
	public RevealDialog(Player p) {
		super(p);
	}

	/**
	 * A kiválasztott mezõnek felfedi a teherbirását
	 * @param target : A kiválasztott mezõ
	 * @author Balczer Dominik
	 */
	@Override
	protected void doActivity(Field target) {
		target.revealLimit(player);		
	}
}