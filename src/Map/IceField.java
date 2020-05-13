package Map;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import Map.Buildings.Building;
import Items.Item;
import Player.Player;
import Visual.ImgType;
import Visual.View;
import Player.Character;

/*
 * Stabil jégmezõt osztálya
 * @author Csonge Bence
 */
public class IceField extends Field {
	
	/**
	 * Mezõn jégbe fagyott tárgy
	 * @author Csonge Bence
	 */
	protected Item frozenItem;
	
	/**
	 * Mezõn a földön levõ tárgyak
	 * @author Csonge Bence
	 */
	protected ArrayList<Item> itemOnGround;
	
	/**
	 * Konstruktor, inicializálja a mezõ változóit és betölti a képét
	 * @param x : A mezõ képernyõn elfoglalt poziciójának X koordinátája
	 * @param y : A mezõ képernyõn elfoglalt poziciójának Y koordinátája
	 * @param playerCount : Játékban résztvevõ játékosok száma, a teherbitás beállitásához kell
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
	 * Karakter fogadás, átveszi a karaktert és ha nincs iglu rajta, ütközteti a mezõ többi karakterével
	 * @param c: Fogadott karakter
	 * @author Csonge Bence
	 */
	public void acceptCharacter(Character c) {
		c.setField(this);
		characters.add(c);
		c.setDrowning(false);
		
		if(building!=null) {
			if(building.attack()) 
				for(Character collider : characters) 
					c.collideWith(collider);	
		}
		else 
			for(Character collider : characters) 
				c.collideWith(collider);
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
	 *  Tárgy felvétele a mezõn a földrõl, mindig a 0-s indexû tárgyat adja vissza
	 *  @param p: Játékos aki felveszi a tárgyat
	 *  @author Csonge Bence
	 */
	public Item pickUpItem(Player p) 
	{
		if(itemOnGround.isEmpty()) 
			return null;
		
		p.drainStamina();
		Item i = itemOnGround.get(0);
		i.pickUp();
		itemOnGround.remove(0);
		return i;
	}
	
	/**
	 *  Tárgy kiszabaditása a mezõn a jégbõl
	 *  @param p: Kiszabaditó játékos
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
	 * Építés a mezõn, visszaadja hogy sikerült-e
	 * @param b: Épitendõ épület
	 * @author Csonge Bence
	 */
	@Override
	public boolean buildBuilding(Building b) {
		if(building != null) 
			return false;
		building = b;
		return true;
	}
	
	/**
	 * Mezõn található épület tick-elése
	 * @author Csonge Bence
	 */
	@Override
	public void tickBuilding() {
		if(building != null) 
			if(building.tick()) 
				building = null;
	}
	
	/**
	 * Jégbe tárgy helyezése, visszaadja sikerült-e
	 * @param Elhelyezendõ tárgy
	 * @author Csonge Bence
	 */
	@Override
	public boolean addFrozenItem(Item i) {
		if(frozenItem != null)
			return false;
		
		frozenItem = i;
		return true;
	}

	/**
	 * Mezõ és a a hozzátartozó objektumok kirajzolása (karakterek, épület, tárgyak)
	 * @author Csonge Bence
	 */
	@Override
	public void draw(View v) {
		//Ha beszakadt alattuk a jég nem rajzoljuk ki
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
}