package Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import Core.Game;
import Player.Character;

public class Hole extends Field 
{
	public Hole() {
		super();
		maxplayers = (int)Math.random()*Game.characters.size()+1;
	}
	
	@Override
	public boolean savePerson(Field safeField) {
		if(characters.isEmpty()){
			return false;
		}
		
		System.out.println("Which character?");
		
		int answer = -1;
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		try {
			bemenet = reader.readLine();
			answer = Integer.parseInt(bemenet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(answer >= 1 && answer <= characters.size()) {
			if(characters.get(answer-1).save(safeField))
				return true;
			else
				return false;
		}

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
