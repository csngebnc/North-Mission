package Visual;

import Map.Field;
import Player.Player;

/**
 * Mez� teherbit�s�nak felfed�s�re haszn�lt DirectionDialog
 * @author Balczer Dominik
 */
public class RevealDialog extends DirectionDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor
	 * @param p : A j�t�kos aki a felfed�st v�gzi
	 * @author Balczer Dominik
	 */
	public RevealDialog(Player p) {
		super(p);
	}

	/**
	 * A kiv�lasztott mez�nek felfedi a teherbir�s�t
	 * @param target : A kiv�lasztott mez�
	 * @author Balczer Dominik
	 */
	@Override
	protected void doActivity(Field target) {
		target.revealLimit(player);		
	}
}