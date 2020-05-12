package Visual;
import Core.Game;
import Map.Field;
import Player.Player;

public class SaveDialog extends DirectionDialog {

	public SaveDialog(Player p) {
		super(p);
	}

	@Override
	protected void doActivity(Field target) {
		if(target.savePerson(centerField))
			player.drainStamina();
		Game.notifyView();
	}
}
