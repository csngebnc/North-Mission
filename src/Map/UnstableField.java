package Map;
import Core.Game;
import Core.Main;
import Player.Character;
import Player.Player;

public class UnstableField extends IceField
{
	// Jelenleg forgat�k�nyv alapj�n �tfordul� instabil mez�.
	public void acceptCharacter(Character c)
	{
		if(characters.size()>=maxplayers) {
			Game.loseGame();
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
