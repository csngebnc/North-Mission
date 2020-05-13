package Map;

import java.awt.Image;
import java.util.ArrayList;
import Items.Item;
import Map.Buildings.Building;
import Player.Character;
import Player.Direction;
import Player.Player;
import Visual.FieldView;
import Visual.View;

/**
 * Absutrakt mezõ osztálya
 * @author Csonge Bence
 */
public abstract class Field extends FieldView{
	
	/**
	 * Mezõn levõ hóréteg nagysága
	 * @author Csonge Bence
	 */
	protected int snowLayers;
	
	/**
	 * Mezõ teherbirása
	 * @author Csonge Bence
	 */
	protected int maxplayers;
	
	/**
	 * Mezõn tartózkodó karakterek
	 * @author Csonge Bence
	 */
	protected ArrayList<Character> characters;
	
	/**
	 * Mezõ szomszédai
	 * @author Csonge Bence
	 */
	protected ArrayList<Field> neighbours;
	
	/**
	 * Mezõn található épület
	 * @author Csonge Bence
	 */
	protected Building building;
	
	/**
	 * Jelzi ha a mezõn használták a revealLimetet.
	 * @author Norbi
	 */
	protected boolean limitRevealed = false;
	
	/**
	 * Konstruktor
	 * Inicializálja a mezõ változóit, feltölti egyenlõre null-okkal a szomszédjait tároló tömbböt.
	 * @param x : A mezõ képernyõn elfoglalt poziciójának X koordinátája
	 * @param y : A mezõ képernyõn elfoglalt poziciójának Y koordinátája
	 * @author Csonge Bence
	 */
	public Field(int x, int y) {
		super(x,y);
		snowLayers = (int)(Math.random()*2);
		characters = new ArrayList<Character>();
		neighbours = new ArrayList<Field>();
		
		for(int i = 0; i < 6; i++) 
			neighbours.add(null);
		
		building = null;
	}
	
	/**
	 * Hóvihar esemény kezelése, generál havat a mezõre és ha nincs rajta épület,
	 * sebzi a rajta tartózkodó játékosokat.
	 * @author Csonge Bence
	 */
	public void generateBlizzard() {
		snowLayers += Math.random()*5;
		if(building == null)
			for(Character c : characters)
				c.alterHealth(-1);
	}
	
	/**
	 * Mezõn tartókodó játékos mozgatása adott irányban levõ szomszédos mezõre
	 * @param c: Mozditandó karakter
	 * @param DIR : Mozgatás iránya
	 * @author Csonge Bence
	 */
	public void moveMeTo(Character c, Direction DIR) {
		if(DIR.VALUE >= neighbours.size())
			return;
		
		neighbours.get(DIR.VALUE).acceptCharacter(c);
		characters.remove(c);
		c.drainStamina();
	}
	
	/**
	 * Sarkkutató felfedi a mezõ teherbirását, ha még nem fedték fel elõtte le von egy staminát is.
	 * @param p : A sarkkutató aki a felfedést végzi
	 * @author Csonge Bence
	 */
	public void revealLimit(Player p) {
		if(limitRevealed)
			return;
		
		limitRevealed = true;
		p.drainStamina();
	}
	
	/**
	 * 	Karakter fogadása
	 *  @param c: Fogadandó karakter
	 *  @author Csonge Bence
	 */
	public abstract void acceptCharacter(Character c);
	
	/**
	 *  Tárgy eldobása mezõre, alapesetben nem csinál semmit, ahol van értelme ott felül van definiálva.
	 *  @param i: Eldobandó tárgy
	 *  @author Csonge Bence
	 */
	public void acceptItem(Item i) {}
	
	/**
	 *  Tárgy felvétele mezõrõl, alapesetben nem csinál semmit, ahol van értelme ott felül van definiálva.
	 *  @param p: Tárgyat felvevõ játékos
	 *  @author Csonge Bence
	 */
	public Item pickUpItem(Player p) {
		return null;
	}
	
	/**
	 *  Hó ásása a mezõn, visszatérési értékben visszaadja sikerült-e az ásás
	 *  @param amount: Hány réteg havat ásunk
	 *  @author Csonge Bence
	 */
	public boolean digSnow(int amount) {
		if(snowLayers==0) 
			return false;
		
		snowLayers-=amount;
		if(snowLayers < 0)
			snowLayers = 0;
		return true;
	}
	
	/**
	 *  Visszaadja a mezõ képét attól függõen hány réteg hó van rajta
	 *  @author Balczer Dominik
	 */
	public Image getSprite() {
		if(snowLayers==0) 
			return sprites[0];
		else if(snowLayers>0 && snowLayers <5)
			return sprites[1];
		else
			return sprites[2];
	}

	/**
	 *  Tárgy kiszabaditása a jégbõl, alapesetben nem csinál semmit, ahol van értelme ott felül van definiálva.
	 *  @param p: Játékos aki végzi a cselekvést
	 *  @author	Balczer Dominik
	 */
	public void removeItemFromIce(Player p) {}
	
	/**
	 *  Játékos kimentése, alapesetben nem csinál semmit, ahol van értelme ott felül van definiálva, visszaadja sikerült-e.
	 *  @param safeField: A mezõ ahova mentjük a játékost
	 *  @author	Balczer Dominik
	 */
	public boolean savePerson(Field safeField){
		return false;
	}
	
	/**
	 *  Épület épitése a mezõn, alapesetben nem csinál semmit, ahol van értelme ott felül van definiálva, visszaadja sikerült-e.
	 *  @param b: Épitendõ épület
	 *  @author	Balczer Dominik
	 */
	public boolean buildBuilding(Building b) {
		return false;
	}

	/**
	 *  Mezpn található épület tick-elése, alapesetben nem csinál semmit, ahol van értelme ott felül van definiálva, visszaadja sikerült-e.
	 *  @author	Balczer Dominik
	 */
	public void tickBuilding() {}
	
	/**
	 *  Megkeresi és beállitja a mezõ a szomszédjait
	 *  @param fields : A pálya összes mezejét tartalmazó lista
	 *  @author	Balczer Dominik
	 */
	public void discoverNeighbours(ArrayList<Field> fields) {
		for(Field candidate : fields) {
			int candX = candidate.GetX();
			int candY = candidate.GetY();
			if(x + 48 == candX || x + 47 == candX) {
				if(y - 30 == candY)
					neighbours.set(Direction.UPPER_RIGHT.VALUE, candidate);
				else if(y + 30 == candY)
					neighbours.set(Direction.BOTTOM_RIGHT.VALUE, candidate);
			}
			else if(x - 48 == candX || x - 47 == candX) {
				if(y - 30 == candY)
					neighbours.set(Direction.UPPER_LEFT.VALUE, candidate);
				else if(y + 30 == candY)
					neighbours.set(Direction.BOTTOM_LEFT.VALUE, candidate);
			}
			else if(x + 95 == candX && y == candY) 
				neighbours.set(Direction.RIGHT.VALUE, candidate);
			else if(x - 95 == candX && y == candY) 
				neighbours.set(Direction.LEFT.VALUE, candidate);
		}
	}
	
	/**
	 *  Visszaadja adott irányban a mezõ szomszédját
	 *  @param DIR : Lekért szomszéd iránya
	 *  @author	Balczer Dominik
	 */
	public Field getNeighbour(Direction DIR){
		return neighbours.get(DIR.VALUE);
	}
	
	/**
	 *  Visszaadja a mezõ szomszédjait
	 *  @author	Balczer Dominik
	 */
	public ArrayList<Field> getNeighbours(){
		return neighbours;
	}
	
	/**
	 *  Tárgyat ad a mezõn a jégbe, visszaadja hogy volt-e már itt másik tárgy
	 *  (tehát sikerült-e az elhelyezés), alapesetben mindig false-al tér vissza, ahol van értelme ott
	 *  felül van definiálva.
	 *  @param i : A jégba adandó tárgy 
	 *  @author	Balczer Dominik
	 */
	public boolean addFrozenItem(Item i) {
		return false;
	}
	
	/**
	 *  Visszaadja hogy van-e a mezõn épület
	 *  @author	Balczer Dominik
	 */
	public boolean hasBuilding() {
		return building!=null;
	}

	/**
	 *  Visszaadja a mezõn tartózkodó karaktereket
	 *  @author	Balczer Dominik
	 */
	public ArrayList<Character> getCharacters(){
		return characters;
	}
	
	/**
	 *  Kirajzolja a mezõt
	 *  @param view : A játékpanel amelyre
	 *  @author	Balczer Dominik
	 */
	public void draw(View v) {
		v.drawThing(x, y, getSprite());
	}
}