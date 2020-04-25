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
		
		if(characters.get(0).save(neighbours.get(dir)))
			return true;
		else
			return false;
	}
	
	//Lyukba került játékos fuldoklását beállítja.
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
	
	@Override
	public void Properties()
	{
		System.out.println("---------------------------");
		System.out.println(this.getClass());
		System.out.println("Limit: " + maxplayers);
		System.out.println("Snow layers: " + snowLayers);
		
		for(Character c:characters)
		{
			System.out.println("Character on field: " + c.getName());
		}
	}
}
