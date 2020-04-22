package Map;
import Core.Game;
import Player.Character;

public class UnstableField extends IceField
{
	// Jelenleg forgatókönyv alapján átforduló instabil mezõ.
	public void acceptCharacter(Character c)
	{
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
