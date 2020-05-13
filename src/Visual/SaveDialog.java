package Visual;
import Core.Game;
import Map.Field;
import Player.Player;

/**
 * Játékos kimentésére használt DirectionDialog
 * @author Balczer Dominik
 */
public class SaveDialog extends DirectionDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor
	 * @author Balczer Dominik
	 */
	public SaveDialog(Player p) {
		super(p);
	}

	/**
	 * A kiválasztott mezõn savePerson()-t hiv
	 * @author Balczer Dominik
	 */
	@Override
	protected void doActivity(Field target) {
		dispose();
		if(target.savePerson(centerField))
			player.drainStamina();
		Game.notifyView();
		Game.getView().requestFocus();
	}
}