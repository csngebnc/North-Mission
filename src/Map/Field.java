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
 * Absutrakt mez� oszt�lya
 * @author Csonge Bence
 */
public abstract class Field extends FieldView{
	
	/**
	 * Mez�n lev� h�r�teg nagys�ga
	 * @author Csonge Bence
	 */
	protected int snowLayers;
	
	/**
	 * Mez� teherbir�sa
	 * @author Csonge Bence
	 */
	protected int maxplayers;
	
	/**
	 * Mez�n tart�zkod� karakterek
	 * @author Csonge Bence
	 */
	protected ArrayList<Character> characters;
	
	/**
	 * Mez� szomsz�dai
	 * @author Csonge Bence
	 */
	protected ArrayList<Field> neighbours;
	
	/**
	 * Mez�n tal�lhat� �p�let
	 * @author Csonge Bence
	 */
	protected Building building;
	
	/**
	 * Jelzi ha a mez�n haszn�lt�k a revealLimetet.
	 * @author Norbi
	 */
	protected boolean limitRevealed = false;
	
	/**
	 * Konstruktor
	 * Inicializ�lja a mez� v�ltoz�it, felt�lti egyenl�re null-okkal a szomsz�djait t�rol� t�mbb�t.
	 * @param x : A mez� k�perny�n elfoglalt pozici�j�nak X koordin�t�ja
	 * @param y : A mez� k�perny�n elfoglalt pozici�j�nak Y koordin�t�ja
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
	 * H�vihar esem�ny kezel�se, gener�l havat a mez�re �s ha nincs rajta �p�let,
	 * sebzi a rajta tart�zkod� j�t�kosokat.
	 * @author Csonge Bence
	 */
	public void generateBlizzard() {
		snowLayers += Math.random()*5;
		if(building == null)
			for(Character c : characters)
				c.alterHealth(-1);
	}
	
	/**
	 * Mez�n tart�kod� j�t�kos mozgat�sa adott ir�nyban lev� szomsz�dos mez�re
	 * @param c: Mozditand� karakter
	 * @param DIR : Mozgat�s ir�nya
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
	 * Sarkkutat� felfedi a mez� teherbir�s�t, ha m�g nem fedt�k fel el�tte le von egy stamin�t is.
	 * @param p : A sarkkutat� aki a felfed�st v�gzi
	 * @author Csonge Bence
	 */
	public void revealLimit(Player p) {
		if(limitRevealed)
			return;
		
		limitRevealed = true;
		p.drainStamina();
	}
	
	/**
	 * 	Karakter fogad�sa
	 *  @param c: Fogadand� karakter
	 *  @author Csonge Bence
	 */
	public abstract void acceptCharacter(Character c);
	
	/**
	 *  T�rgy eldob�sa mez�re, alapesetben nem csin�l semmit, ahol van �rtelme ott fel�l van defini�lva.
	 *  @param i: Eldoband� t�rgy
	 *  @author Csonge Bence
	 */
	public void acceptItem(Item i) {}
	
	/**
	 *  T�rgy felv�tele mez�r�l, alapesetben nem csin�l semmit, ahol van �rtelme ott fel�l van defini�lva.
	 *  @param p: T�rgyat felvev� j�t�kos
	 *  @author Csonge Bence
	 */
	public Item pickUpItem(Player p) {
		return null;
	}
	
	/**
	 *  H� �s�sa a mez�n, visszat�r�si �rt�kben visszaadja siker�lt-e az �s�s
	 *  @param amount: H�ny r�teg havat �sunk
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
	 *  Visszaadja a mez� k�p�t att�l f�gg�en h�ny r�teg h� van rajta
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
	 *  T�rgy kiszabadit�sa a j�gb�l, alapesetben nem csin�l semmit, ahol van �rtelme ott fel�l van defini�lva.
	 *  @param p: J�t�kos aki v�gzi a cselekv�st
	 *  @author	Balczer Dominik
	 */
	public void removeItemFromIce(Player p) {}
	
	/**
	 *  J�t�kos kiment�se, alapesetben nem csin�l semmit, ahol van �rtelme ott fel�l van defini�lva, visszaadja siker�lt-e.
	 *  @param safeField: A mez� ahova mentj�k a j�t�kost
	 *  @author	Balczer Dominik
	 */
	public boolean savePerson(Field safeField){
		return false;
	}
	
	/**
	 *  �p�let �pit�se a mez�n, alapesetben nem csin�l semmit, ahol van �rtelme ott fel�l van defini�lva, visszaadja siker�lt-e.
	 *  @param b: �pitend� �p�let
	 *  @author	Balczer Dominik
	 */
	public boolean buildBuilding(Building b) {
		return false;
	}

	/**
	 *  Mezpn tal�lhat� �p�let tick-el�se, alapesetben nem csin�l semmit, ahol van �rtelme ott fel�l van defini�lva, visszaadja siker�lt-e.
	 *  @author	Balczer Dominik
	 */
	public void tickBuilding() {}
	
	/**
	 *  Megkeresi �s be�llitja a mez� a szomsz�djait
	 *  @param fields : A p�lya �sszes mezej�t tartalmaz� lista
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
	 *  Visszaadja adott ir�nyban a mez� szomsz�dj�t
	 *  @param DIR : Lek�rt szomsz�d ir�nya
	 *  @author	Balczer Dominik
	 */
	public Field getNeighbour(Direction DIR){
		return neighbours.get(DIR.VALUE);
	}
	
	/**
	 *  Visszaadja a mez� szomsz�djait
	 *  @author	Balczer Dominik
	 */
	public ArrayList<Field> getNeighbours(){
		return neighbours;
	}
	
	/**
	 *  T�rgyat ad a mez�n a j�gbe, visszaadja hogy volt-e m�r itt m�sik t�rgy
	 *  (teh�t siker�lt-e az elhelyez�s), alapesetben mindig false-al t�r vissza, ahol van �rtelme ott
	 *  fel�l van defini�lva.
	 *  @param i : A j�gba adand� t�rgy 
	 *  @author	Balczer Dominik
	 */
	public boolean addFrozenItem(Item i) {
		return false;
	}
	
	/**
	 *  Visszaadja hogy van-e a mez�n �p�let
	 *  @author	Balczer Dominik
	 */
	public boolean hasBuilding() {
		return building!=null;
	}

	/**
	 *  Visszaadja a mez�n tart�zkod� karaktereket
	 *  @author	Balczer Dominik
	 */
	public ArrayList<Character> getCharacters(){
		return characters;
	}
	
	/**
	 *  Kirajzolja a mez�t
	 *  @param view : A j�t�kpanel amelyre
	 *  @author	Balczer Dominik
	 */
	public void draw(View v) {
		v.drawThing(x, y, getSprite());
	}
}