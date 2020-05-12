package Visual;

import Map.Field;
import Player.Player;

public class RevealDialog extends DirectionDialog {

	public RevealDialog(Player p) {
		super(p);
	}

	@Override
	protected void doActivity(Field target) {
		target.revealLimit(player);		
	}

}
