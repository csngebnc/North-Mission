package Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;

import Core.Game;
import Player.Character;
import Player.Direction;
import Visual.View;

/**
 * A lyuk mezo osztalya.
 * @author Csonge Bence
 */
public class Hole extends Field 
{
	/**
	 * Lyuk konstruktora, alapertelmezett ertekek beallitasa.
	 * @author Csonge Bence
	 */
	public Hole(int x, int y) {
		super(x,y);
		maxplayers = (int)Math.random()*Game.getPlayerCount();
	}
	
	
	/**
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
	
	/**
	 * Jatekos fogadasa a mezore, valamint a fulladas (drown()) metodus hivasa.
	 * @param c: atvett karakter
	 * @author Csonge Bence
	 */
	public void acceptCharacter(Character c)
	{
		snowLayers = 0;
		c.setField(this);
		c.setDrowning(true);
		characters.add(c);
		for(Character ch : characters) {
			if(!ch.equals(c))
				c.collideWith(ch);
		}
	}
	
	@Override
	public void moveMeTo(Character c, Direction DIR) 
	{
		super.moveMeTo(c, DIR);
		c.setDrowning(false);
	} 

	@Override
	public void generateBlizzard() 
	{
		if(characters.isEmpty())
			snowLayers += Math.random()*5;
		
		if(building == null)
			for(Character c : characters)
				c.alterHealth(-1);
	}

	@Override
	public void draw(View v) {
		if(snowLayers==0) {
			v.drawThing(x, y, new ImageIcon("./assets/fields/lyuk.png").getImage());
		}else if(snowLayers>0 && snowLayers <5) {
			v.drawThing(x, y, new ImageIcon("./assets/fields/snow1.png").getImage());
		}else if(snowLayers>=5) {
			v.drawThing(x, y, new ImageIcon("./assets/fields/snow2.png").getImage());
		}
		
		for(Character c : characters) {
			c.draw(v);
		}
		
	}
}
