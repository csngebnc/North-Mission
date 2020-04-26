package Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import Core.Game;
import Player.Character;

public class Hole extends Field 
{
	/*
	 * Lyuk konstruktora, alapertelmezett ertekek beallitasa.
	 * @author Csonge Bence
	 */
	public Hole() {
		super();
		maxplayers = (int)Math.random()*Game.characters.size()+1;
	}
	
	
	/*
	 * Amennyiben legalabb egy karakter van a mezon, akkor onnan valasztunk egyet, es megprobaljuk kimenteni a save() metodusaval.
	 * Visszater a mentes sikeressegevel.
	 * @param safeField: a mezo ahova kihuzzuk.
	 * @author Csonge Bence
	 */
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
	
	/*
	 * Jatekos fogadasa a mezore, valamint a fulladas (drown()) metodus hivasa.
	 * @param c: atvett karakter
	 * @author Csonge Bence
	 */
	public void acceptCharacter(Character c)
	{
		snowLayers = 0;
		c.setField(this);
		c.drown();
		characters.add(c);
		for(Character ch : characters) {
			if(!ch.equals(c))
				c.collideWith(ch);
		}
	}
	
	/*
	 * A tovabbi metodusok getter/setter, valamint a teszteleshez hasznalt metodusok.
	 */
	
	@Override
	public void Properties()
	{
		System.out.println("---------------------------");
		System.out.println(this.getClass());
		System.out.println("Snow layers: " + snowLayers);
		
		for(Character c:characters)
		{
			System.out.println("Character on field: " + c.getName());
		}
	}
}
