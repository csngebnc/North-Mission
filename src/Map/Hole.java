package Map;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
		super(x, y);
		sprites[0] = new ImageIcon("./assets/fields/hole.png").getImage();
		maxplayers = 0;
	}
	
	/**
	 * Amennyiben legalabb egy karakter van a mezon, akkor onnan valasztunk egyet, es megprobaljuk kimenteni a save() metodusaval.
	 * Visszater a mentes sikeressegevel.
	 * @param safeField: a mezo ahova kihuzzuk.
	 * @author Csonge Bence
	 */
	@Override
	public boolean savePerson(Field safeField) {
		JComboBox<String> cb = new JComboBox<String>();
		for(Character c : characters)
			cb.addItem(c.getName());
		JOptionPane.showMessageDialog(null, cb);
		return characters.get(cb.getSelectedIndex()).save(safeField);
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
		super.draw(v);
		for(Character c : characters) {
			c.draw(v);
		}
		if(limitRevealed) {
			v.drawThing(x + 5, y + 20, Integer.toString(maxplayers));
		}
	}
}
