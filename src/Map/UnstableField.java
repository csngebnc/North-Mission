package Map;
import java.util.ArrayList;

import Core.Game;
import Items.Item;
import Player.Character;

/**
 * Az instabil mezo osztalya.
 * @author Csonge Bence
 */
public class UnstableField extends IceField
{
	/**
	 * Instabil mezo konstruktora, alapertelmezett ertek beallitasa.
	 * Jelenleg tesztek miatt alapertelmezetten nem tartalmaz targyat, paranccsal allithato be egy targy a mezore.
	 * @author Csonge Bence
	 */
	public UnstableField(int x, int y) {
		super(x,y);
		frozenItem = null;
		itemOnGround = new ArrayList<Item>();
		maxplayers = (int)(Math.random()*(Game.getPlayerCount()-1))+1;
	}
	
	/**
	 * Karakter atvetele egy masik mezotol. Amennyiben az atvetel utan a mezon tobb karakter tartozkodik,
	 * mint a teherbirasa, akkor atfordul, a jatek pedig vegeter.
	 * @param c: atvett karakter
	 * @author Csonge Bence
	 */
	public void acceptCharacter(Character c)
	{
		c.setField(this);
		c.setDrowning(false);
		characters.add(c);
		if(characters.size()>maxplayers) {
			for(Character ci : characters)
				ci.alterHealth(-150);
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
	
	/**
	 * A tovabbi metodusok getter/setter, valamint a teszteleshez hasznalt metodusok.
	 */
	
	@Override
	public void setLimit(int limit) {
		maxplayers = limit;
	}
}
