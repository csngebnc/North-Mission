package Player;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;

import Core.Game;
import Core.GameState;
import Core.Main;
import Items.Barrel;
import Items.DivingSuit;
import Items.Food;
import Items.Item;
import Items.Rope;
import Items.Shovel;
import Map.Field;
import Map.IceField;
import Map.Map;
import Visual.View;

/**
 * A játékosokat reprezentáló absztrakt osztály.
 * Leszármazottai az Eskimo és a Scientist.
 * @author Zalan
 */
public abstract class Player extends Character
{
	protected String name;
	protected int health;
	protected boolean dSuitOn;
	protected ArrayList<Item> inventory;
	public abstract void doSkill();
	protected Image currentPlayerImage;
	
	/**
	 * A Player konstruktora.
	 * Inicializáljuk az inventory, isDrowning, dSuitOn, health tulajdonságokat.
	 * @author Zalan
	 */
	public Player() {
		inventory = new ArrayList<Item>();
		isDrowning = false;
		dSuitOn = false;
		health = 3;
		currentPlayerImage = new ImageIcon("./assets/characters/current_player.png").getImage();
	}

	/**
	 * Játékos inventory-jának megjelenítése.
	 * @author Zalan
	 */
	protected void openInventory() 
	{
		for(Item i : inventory) {
			System.out.println(i.getClass());
		}
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		try {
			bemenet = reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!inventory.isEmpty()) {
			inventory.get(Integer.parseInt(bemenet)).use(this);
		}
	}
	
	/**
	 * A játékos köre.
	 * A játékos 3 staminával kezdi a körét. Ha fuldoklik, és nincs rajta búvárruha akkor meghalt, és a játékosok elvesztették a játékot.
	 * Ezután, ha van még staminája, akkor szándékainak megfelelõen cselekedhet.
	 * @author Zalan
	 */
	public boolean doTurn(Game g, KeyEvent e) 
	{		
		if(isDrowning && !dSuitOn) {
			Game.loseGame();
			return false;
		}
		
			move(e);
			g.notifyView();
			
			if(isDrowning)
				return true;
			
		return stamina == 0;
	}
	
	public void startTurn(Game g) {
		stamina = 3;
	}
	
	public void move(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_Q:
				if(field.getNeighbour(Direction.UPPER_LEFT)!=null) {
					field.moveMeTo(this, Direction.UPPER_LEFT);
				}
				break;
			case KeyEvent.VK_E:
				if(field.getNeighbour(Direction.UPPER_RIGHT)!=null) {
					field.moveMeTo(this, Direction.UPPER_RIGHT);
				}
				break;
			case KeyEvent.VK_A:
				if(field.getNeighbour(Direction.LEFT)!=null) {
					field.moveMeTo(this, Direction.LEFT);
				}
				break;
			case KeyEvent.VK_D:
				if(field.getNeighbour(Direction.RIGHT)!=null) {
					field.moveMeTo(this, Direction.RIGHT);
				}
				break;
			case KeyEvent.VK_Y:
				if(field.getNeighbour(Direction.BOTTOM_LEFT)!=null) {
					field.moveMeTo(this, Direction.BOTTOM_LEFT);
				}
				break;
			case KeyEvent.VK_X:
				if(field.getNeighbour(Direction.BOTTOM_RIGHT)!=null) {
					field.moveMeTo(this, Direction.BOTTOM_RIGHT);
				}
				break;
			case KeyEvent.VK_S:
				//skill használat
				doSkill();
				break;
			case KeyEvent.VK_H:
				//kézzel ásás
				field.digSnow(1);
				break;
			case KeyEvent.VK_I:
				//Itt jön felugró ablakkal az inventory
				break;
			case KeyEvent.VK_P:
				return;
		}
	}
	
	/**
	 * Búvárruha használat.
	 * Ha a játékoson volt már búvárruha, akkor azt leveszi és az inventory-jába teszi, ha nem volt még rajta akkor felveszi.
	 * @author Zalan
	 * @param dsuit a a búvárruha amit felveszünk. Null értékû, ha le kell vennünk magunkról a búvárruhát.
	 */
	public boolean changeSuit(DivingSuit dsuit) 
	{
		if (dsuit == null) {
			if(dSuitOn) {
				dSuitOn = false;
				inventory.add(new DivingSuit());
				return true;
			}
			else
				return false;
		}
		else if (!dSuitOn) {
			dSuitOn = true;
			inventory.remove(dsuit);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Játékos életének változtatása 'n' egységgel
	 * @author Zalan
	 * @param n ennyivel változik a játékos élete
	 */
	public void alterHealth(int n) 
	{
		health += n;
		
		if(health <= 0)
			Game.loseGame();
	}
	
	/**
	 * Játékos staminájának csökkentése 1-gyel.
	 * @author Zalan
	 */
	public void drainStamina() 
	{
		stamina -= 1;
	}
	
	/**
	 * A játékos megmentésre kerül fuldokló helyzetbõl.
	 * A játékos a paraméterként kapott field-re helyezõdik, és az isDrowning értéke false lesz.
	 * @author Zalan
	 * @param safeField a biztonságos mezõ, amire a játékos kerül.
	 */
	public boolean save(Field safeField) {
		field.moveMeTo(this, Direction.FromInt(field.getNeighbours().indexOf(safeField)));
		return true;
	}
	
	/**
	 * Egy tárgy eltávolítása a játékos inventory-jából.
	 * @param i ezen a sorszámú Item-et távolítjuk el az inventory-ból
	 * @author Zalan
	 */
	public void removeItem(Item i) {
		inventory.remove(i);
	}
	
	@Override
	public void draw(View v) {
		int charPos = (52/field.getCharacters().size()) * 
				(int)Math.pow(-1, field.getCharacters().indexOf(this)) *
				(int)(Math.ceil(((double)field.getCharacters().indexOf(this))/2));
		if(!field.hasBuilding()) {
			if(isDrowning) {
				v.drawThing(field.GetX()+40+charPos, field.GetY()+8, img[1]);
			}else {
				v.drawThing(field.GetX()+36+charPos, field.GetY(), img[0]);
			}
		}
		if(stamina > 0) {
			if(field.hasBuilding())
				v.drawThing(field.GetX()+45, field.GetY()-30, currentPlayerImage);
			else
				v.drawThing(field.GetX()+39+charPos, field.GetY()-15, currentPlayerImage);
		}
	}
		
	/**
	 * Játékos mezõjének beállítása.
	 * @param f a field új értéke
	 * @author Zalan
	 */
	public void setField(Field f) 
	{
		field = f;
	}
	
	/**
	 * Játékos mezõjének lekérdezése.
	 * @author Zalan
	 */
	public Field getField() 
	{
		return field;
	}
	
	/**
	 * Játékos nevének lekérdezése.
	 * @author Zalan
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Játékos nevének beállítása.
	 * @param n az új név
	 * @author Zalan
	 */
	public void setName(String n) {
		name = n;
	}
	
	/**
	 * A metódus visszaadja, hogy van-e a játékoson búvárruha.
	 * @author Zalan
	 */
	public boolean getdSuitOn()
	{
		return dSuitOn;
	}
	
	/**
	 * A metódus beállítja, hogy van-e a játékoson búvárruha.
	 * @param b a dSuitOn új értéke
	 * @author Zalan
	 */
	public void setdSuitOn(boolean b)
	{
		dSuitOn=b;
	}

	/**
	 * A metódus visszaadja a játékos inventory-jának i-edik elemét.
	 * @param i ezen sorszámú elemet adjuk vissza
	 * @author Zalan
	 */
	public Item getItem(int i) {
		if(inventory.size() == 0 || i >= inventory.size())
			return null;
		return inventory.get(i);
	}
	
	/**
	 * A játékos staminájának beállítása.
	 * @param s stamina új értéke
	 * @author Zalan
	 */
	public void setStamina(int s)
	{
		stamina = s;
	}
	
	/**
	 * A játékos életének beállítása beállítása.
	 * @param h health új értéke
	 * @author Zalan
	 */
	public void setHealth(int h)
	{
		health = h;
	}
	
	/**
	 * A metódus új, üres inventory-t hoz létre a játékosnak.
	 * @author Zalan
	 */
	public void resetInventory()
	{
		inventory=new ArrayList<Item>();
	}
	
	/**
	 * A metódus visszatér a játékos inventory-jával.
	 * @author Zalan
	 */
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	/**
	 * A metódus visszatér a játékos staminájával.
	 * @author Zalan
	 */
	public int getStamina()
	{
		return stamina;
	}
	
	/**
	 * A játékos a paraméterként kapott karaktert összeütközteti saját magával.
	 * @param c a karakter akivel összeütköztetjük magunkat
	 * @author Zalan
	 */
	public void collideWith(Character c) {
		c.hitBy(this);
	}

	/**
	 * Ha a játékos jegesmedvével ütközött, akkor a játékot elveszítették a játékosok.
	 * @param pb a jegesmedve amivel a játékos összeütközött
	 * @author Zalan
	 */
	@Override
	public void hitBy(PolarBear pb) {
		Game.loseGame();
	}
	
	/**
	 * Teszteléshez
	 */
	@Override
	public void Properties()
	{
		System.out.println(this.getClass());
		System.out.println("Name: " + getName());
		System.out.println("Health: " + health);
		System.out.println("Stamina: " + stamina);
		System.out.println("Is drowning: " + isDrowning);
		System.out.println("Diving suit: " + dSuitOn);
		System.out.println("Inventory:");
		for(Item i : inventory) {
			i.Properties();
		}
	}
}
