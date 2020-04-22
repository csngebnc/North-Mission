package Map;
import Core.Game;
import Player.Character;

public class UnstableField extends IceField
{
	// Jelenleg forgat�k�nyv alapj�n �tfordul� instabil mez�.
	public void acceptCharacter(Character c)
	{
		c.drainStamina();
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
}
