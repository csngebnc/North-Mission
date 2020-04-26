package Map;
import java.util.ArrayList;
import Core.Game;
import Items.Item;
import Map.Buildings.Building;
import Player.Character;
import Player.Player;

/**
 * A Field, azaz az altalanos mezo osztalya.
 * @author Csonge Bence
 */
public abstract class Field
{
	/**
	 * A mezohoz tartozo horeteg szama.
	 * @author Csonge Bence
	 */
	protected int snowLayers;
	/**
	 * A mezohoz tartozo teherbiras.
	 * @author Csonge Bence
	 */
	protected int maxplayers;
	/**
	 * A mezohoz tartozo karakterek.
	 * @author Csonge Bence
	 */
	protected ArrayList<Character> characters;
	/**
	 * A mezo szomszedai
	 * @author Csonge Bence
	 */
	protected ArrayList<Field> neighbours;
	/**
	 * A mezon talalhato epulet
	 * @author Csonge Bence
	 */
	protected Building building;
	
	/**
	 * Az osztaly konstruktora. 
	 * Beallitja a horeteget egy veletlenszeru szamra, letrehozza az ures listakat, a buildinget null-ra allitja. 
	 * @author Csonge Bence
	 */
	public Field() {
		snowLayers = (int)Math.random()*6;
		characters = new ArrayList<Character>();
		neighbours = new ArrayList<Field>();
		building = null;
	}
	
	/**
	 * Hovihar generalasa a mezon, melynek hatasara a mezon levo horeteg megno egy veletlenszeru szammal, ami maximalizalva van.
	 * @author Csonge Bence
	 */
	public void generateBlizzard() 
	{
		snowLayers += Math.random()*5;
		
		if(building == null)
			for(Character c : characters)
				c.alterHealth(-1);
	}
	
	/**
	 * Egy jatekos elmozditasa a mezojerol a mezoje egy szomszedjara.
	 * @param c: mozditando karakter
	 * @param next: karakter mezojenek megadott sorszamu szomszedja
	 * @author Csonge Bence
	 */
	public void moveMeTo(Character c, int next) 
	{
		if(next >= neighbours.size())
			return;
		
		neighbours.get(next).acceptCharacter(c);
		characters.remove(c);
		c.drainStamina();
	}
	
	/**
	 * A sarkkutato karakter specialis kepessegevel ezt a metodust hivja, melynek hatasara
	 * kiirasra kerul a mezo teherbirasa.
	 * @author Csonge Bence
	 */
	public void revealLimit() 
	{
		System.out.println("Max players: " + Game.getPlayerCount());
	}
	
	/**
	 *  A leszarmazottak maguk valositjak meg.
	 *  Feladata: karakter atvetele
	 *  @param c: atvett karakter
	 *  @author Csonge Bence
	 */
	public abstract void acceptCharacter(Character c);
	
	/**
	 *  A leszarmazottak maguk valositjak meg.
	 *  Alapimplementacio pedig nem csinal semmit. lsd.: lyuk
	 *  Feladata: targy atvetele mezore (radobas)
	 *  @param i: mezore helyezett targy
	 *  @author Csonge Bence
	 */
	public void acceptItem(Item i) {}
	
	/**
	 *  A leszarmazottak maguk valositjak meg.
	 *  Alapimplementacio pedig null-t ad vissza. lsd.: lyuk
	 *  Feladata: targy felvetele mezorol
	 *  @param p: jatekos, aki felveszi a targyat
	 *  @author Csonge Bence
	 */
	public Item pickUpItem(Player p) 
	{
		return null;
	}
	
	/**
	 *  A leszarmazottak maguk valositjak meg. A mezon torteno hoasasert felel.
	 *  Alapimplementacio pedig false-t ad vissza. lsd.: lyuk
	 *  @param amount: asas mennyisege
	 *  @author Csonge Bence
	 */
	public boolean digSnow(int amount) 
	{
		return false;
	}

	/**
	 *  A leszarmazottak maguk valositjak meg.
	 *  Alapimplementacio pedig nem csinal semmit. lsd.: lyuk
	 *  Feladata: befagyott targy kiszedese jegbol, mezon elhelyezese
	 *  @param p: a jatekos, aki kiszabaditja a targyat a jegbol
	 *  @author Csonge Bence
	 */
	public void removeItemFromIce(Player p) {}
	
	/**
	 * A leszarmazottak valositjak meg.
	 * Alapimplementacio nem csinal semmit, mivel nem minden mezorol lehet jatekost menteni. lsd.: stabil mezo
	 * Feladata: jatekos mozditasa biztonsagos mezore.
	 * @param safeField: biztonsagos mezo, ahova mozditas tortenik
	 * @author Csonge Bence
	 */
	public boolean savePerson(Field safeField)
	{
		return false;
	}
	
	
	/**
	 * A leszarmazottak valositjak meg.
	 * Alapimplementacio nem csinal semmit, mivel nem minden mezore lehet epiteni. lsd.: lyuk
	 * Feladata: parameterkent kapott epulet elhelyezese a mezon.
	 * @param b: epulet, amit el kell helyezni a mezon
	 * @author Csonge Bence
	 */
	public boolean buildBuilding(Building b) 
	{
		return false;
	}
	
	/**
	 * A leszarmazottak valositjak meg.
	 * Alapimplementacio nem csinal semmit, mivel nem minden mezore lehet epiteni, emiatt az ottani epulet nem tick-elheto. lsd.: lyuk
	 * Feladata: mezo epuletenek tick-elese.
	 * @author Csonge Bence
	 */
	public void tickBuilding() {}
	
	/**
	 * A tovabbiakban getter/setter, valamint teszteleshez hasznalt metodusok talalhatok.
	 */
	
	public Field getNeighbour(int num)
	{
		return neighbours.get(num);
	}
	
	public ArrayList<Field> getNeighbours(){
		return neighbours;
	}
	
	public void addNeighbour(Field f) {
		neighbours.add(f);
	}
	
	public void setFrozenItem(Item i) {
		
	}
	

	public ArrayList<Character> getCharacters()
	{
		return characters;
	}
	
	public void setLimit(int limit) {
		
	}
	
	public void setSnowLayers(int n)
	{
		snowLayers=n;
	}
	
	public void setMaxPlayers(int n)
	{
		maxplayers=n;
	}
	
	public abstract void Properties();
}
