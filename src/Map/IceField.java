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
 * Stabil j�gmez�t oszt�lya
 * @author Csonge Bence
 */
public class IceField extends Field {
	
	/**
	 * Mez�n j�gbe fagyott t�rgy
	 * @author Csonge Bence
	 */
	protected Item frozenItem;
	
	/**
	 * Mez�n a f�ld�n lev� t�rgyak
	 * @author Csonge Bence
	 */
	protected ArrayList<Item> itemOnGround;
	
	/**
	 * Konstruktor, inicializ�lja a mez� v�ltoz�it �s bet�lti a k�p�t
	 * @param x : A mez� k�perny�n elfoglalt pozici�j�nak X koordin�t�ja
	 * @param y : A mez� k�perny�n elfoglalt pozici�j�nak Y koordin�t�ja
	 * @param playerCount : J�t�kban r�sztvev� j�t�kosok sz�ma, a teherbit�s be�llit�s�hoz kell
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
	 * Karakter fogad�s, �tveszi a karaktert �s ha nincs iglu rajta, �tk�zteti a mez� t�bbi karakter�vel
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
	 *  T�rgy felv�tele a mez�n a f�ldr�l, mindig a 0-s index� t�rgyat adja vissza
	 *  @param p: J�t�kos aki felveszi a t�rgyat
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
	 *  T�rgy kiszabadit�sa a mez�n a j�gb�l
	 *  @param p: Kiszabadit� j�t�kos
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
	 * �p�t�s a mez�n, visszaadja hogy siker�lt-e
	 * @param b: �pitend� �p�let
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
	 * Mez�n tal�lhat� �p�let tick-el�se
	 * @author Csonge Bence
	 */
	@Override
	public void tickBuilding() {
		if(building != null) 
			if(building.tick()) 
				building = null;
	}
	
	/**
	 * J�gbe t�rgy helyez�se, visszaadja siker�lt-e
	 * @param Elhelyezend� t�rgy
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
	 * Mez� �s a a hozz�tartoz� objektumok kirajzol�sa (karakterek, �p�let, t�rgyak)
	 * @author Csonge Bence
	 */
	@Override
	public void draw(View v) {
		//Ha beszakadt alattuk a j�g nem rajzoljuk ki
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