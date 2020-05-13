package Map;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Core.Game;
import Map.Buildings.Building;
import Items.Item;
import Player.Player;
import Visual.ImgType;
import Visual.View;
import Player.Character;

/*
 * A normalis jegmezo osztalya.
 * @author Csonge Bence
 */
public class IceField extends Field 
{
	/**
	 * A mezobe befagyott targy
	 * @author Csonge Bence
	 */
	protected Item frozenItem;
	/**
	 * A mezon levo targyak
	 * @author Csonge Bence
	 */
	protected ArrayList<Item> itemOnGround;
	
	/**
	 * Normal jegtabla konstruktora, alapertelmezett ertekek beallitasa.
	 * Jelenleg tesztek miatt alapertelmezetten nem tartalmaz targyat, paranccsal allithato be egy targy a mezore.
	 * @author Csonge Bence
	 */
	public IceField(int x, int y, int playerCount) {
		super(x, y);
		sprites[0] = new ImageIcon("./assets/fields/ice.png").getImage();
		frozenItem = null;
		itemOnGround = new ArrayList<Item>();
		maxplayers = playerCount;
	}
	
	/**
	 * Karakter atvetele egy masik mezotol.
	 * @param c: atvett karakter
	 * @author Csonge Bence
	 */
	public void acceptCharacter(Character c)
	{
		c.setField(this);
		c.setDrowning(false);
		characters.add(c);
		if(building!=null){
			if(building.attack()) {
				for(Character ch : characters) {
					if(!ch.equals(c))
						c.collideWith(ch);
				}
			}
		}else {
			for(Character ch : characters) {
				if(!ch.equals(c))
					c.collideWith(ch);
			}
		}
	}
	
	/**
 	 *  Eldobott targy mezon torteno elhelyezese
	 *  @param i: mezore helyezett targy
	 *  @author Csonge Bence
	 */
	public void acceptItem(Item i) 
	{
		itemOnGround.add(i);
	}
	
	/**
	 *  Teszteles miatt nem teljes implementacio.
	 *  Visszaadja a mezon talalhato targyat, melyet a jatekos eltarol az inventoryjaban.
	 *  @param p: jatekos, aki felveszi a targyat
	 *  @author Csonge Bence
	 */
	public Item pickUpItem(Player p) 
	{
		if(itemOnGround.isEmpty()) {
			return null;
		}
		p.drainStamina();
		Item i = itemOnGround.get(0);
		i.pickUp();
		itemOnGround.remove(0);
		return i;
	}
	
	/**
	 *  Befagyott targy kiszabaditasa jegbol, mezon torteno elhelyezese
	 *  @param p: a jatekos, aki kiszabaditja a targyat a jegbol
	 *  @author Csonge Bence
	 */
	public void removeItemFromIce(Player p) 
	{
		if(snowLayers > 0 || frozenItem == null)
			return;
		
		itemOnGround.add(frozenItem);
		frozenItem = null;
		p.drainStamina();
	}
	
	/**
	 *  Asas a mezon, horeteg csokkentese
	 *  @param amount: asas mennyisege
	 *  @author Csonge Bence
	 */
	public boolean digSnow(int amount) {
		if(snowLayers>0) {
			snowLayers-=amount;
			if(snowLayers < 0)
				snowLayers = 0;
			return true;
		}
		return false;
	}
	
	/**
	 * �p�t�s, parameterkent kapott epulet elhelyezese a mezon.
	 * @param b: epulet, amit el kell helyezni a mezon
	 * @author Csonge Bence
	 */
	@Override
	public boolean buildBuilding(Building b) {
		if(building == null) {
			building = b;
			return true;
		}
		return false;
	}
	
	/**
	 * A mezo epuletenek tick-elese, szukseg eseten mezorol torteno eltavolitasa.
	 * @author Csonge Bence
	 */
	@Override
	public void tickBuilding() {
		if(building != null) {
			if(building.tick()) {
				building = null;
			}
		}
	}
	
	/**
	 * A tovabbiakban getter/setter, valamint teszteleshez hasznalt metodusok talalhatok.
	 */
	
	@Override
	public boolean addFrozenItem(Item i) {
		if(frozenItem != null)
			return false;
		
		frozenItem = i;
		return true;
	}

	@Override
	public void draw(View v) {
		if(characters.size() > maxplayers)
			return;
		
		super.draw(v);
		
		if(snowLayers==0 && frozenItem!=null) {
			v.drawThing(x+25, y+5, frozenItem.getImg(ImgType.FROZEN));
		}

		for(Item i : itemOnGround) {
			v.drawThing(x+25, y+5, i.getImg(ImgType.DROPPED));
		}
		
		if(hasBuilding())
			v.drawThing(x, y-20, building.getImg(ImgType.BUILT));
		
		for(Character c : characters) {
			c.draw(v);
		}
		
		if(limitRevealed) {
			v.drawThing(x + 85, y + 20, Integer.toString(maxplayers));
		}
	}
	
	public void setBuilding(Building b) {
		this.building = b;
	}
	
	public void addItem(Item i) {
		itemOnGround.add(i);
	}
}
