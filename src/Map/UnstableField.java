package Map;
import java.util.ArrayList;

import Core.Game;
import Items.Item;
import Player.Character;

public class UnstableField extends IceField
{
	public UnstableField() {
		super();
		frozenItem = null;
		itemOnGround = new ArrayList<Item>();
		maxplayers = (int)Math.random()*(Game.getPlayerCount()-1);
	}
	
	// Jelenleg forgat�k�nyv alapj�n �tfordul� instabil mez�.
	public void acceptCharacter(Character c)
	{
		c.setField(this);
		characters.add(c);
		if(characters.size()>=maxplayers) {
			Game.loseGame();
			return;
		}else {
			if(building!=null){
				if(building.attack()) {
					for(Character ch : characters) {
						c.collideWith(ch);
					}
				}
			}else {
				for(Character ch : characters) {
					c.collideWith(ch);
				}
			}
		}
	}
	
	@Override
	public void setLimit(int limit) {
		maxplayers = limit;
	}
}
