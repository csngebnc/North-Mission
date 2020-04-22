package Map;
import Core.Game;
import Player.Character;

public class Hole extends Field 
{
	public Hole() {
		super();
		maxplayers = (int)Math.random()*Game.characters.size()+1;
	}
	
	@Override
	public boolean savePerson(int dir) {
		if(characters.isEmpty()){
			return false;
		}
		
		characters.get(0).save(neighbours.get(dir));
		return true;
	}
	
	//Lyukba ker�lt j�t�kos fuldokl�s�t be�ll�tja.
	public void acceptCharacter(Character c)
	{
		c.setField(this);
		c.drown();
		characters.add(c);
		for(Character ch : characters) {
			if(!ch.equals(c))
				c.collideWith(ch);
		}
	}
}
