package Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import Core.Game;
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

public abstract class Player extends Character
{
	protected String name;
	protected int health;
	protected int stamina;
	protected boolean isDrowning;
	protected boolean dSuitOn;
	protected ArrayList<Item> inventory;
	public abstract void doSkill();
	
	/*
	 * A Player konstruktora.
	 * Inicializáljuk az inventory, isDrowning, dSuitOn, health tulajdonságokat.
	 * @author Zalan
	 */
	public Player() {
		inventory = new ArrayList<Item>();
		isDrowning = false;
		dSuitOn = false;
		health = 3;
	}

	/*
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
	
	/*
	 * A játékos köre.
	 * A játékos 3 staminával kezdi a körét. Ha fuldoklik, és nincs rajta búvárruha akkor meghalt, és a játékosok elvesztették a játékot.
	 * Ezután, ha van még staminája, akkor szándékainak megfelelõen cselekedhet.
	 * @author Zalan
	 */
	public void doTurn() 
	{
		stamina = 3;
		
		if(isDrowning && !dSuitOn)
			Game.loseGame();
		
		while(stamina > 0) {
			String bemenet = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			
			try {
				bemenet = reader.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String[] command = bemenet.split(" ");
			
			switch(command[0]) {
				case "useitem":
					openInventory();
					break;
				case "step":
					field.moveMeTo(this, Integer.parseInt(command[1]));
					break;
				case "skill":
					doSkill();
					break;
				case "dig":
					if(field.digSnow(1))
						drainStamina();
					break;
				case "unequip":
					if(changeSuit(null))
						drainStamina();
					break;
				case "freeitem":
					field.removeItemFromIce(this);
					break;
				case "pickupitem":
					field.pickUpItem(this);
					break;
				case "dropitem":
					int dropItemIndex = Integer.parseInt(command[1])-1;
					if(inventory.size() <= dropItemIndex)
						break;
					Item dropItem = inventory.get(dropItemIndex);
					if(dropItem.throwTo(field)) {
						inventory.remove(dropItemIndex);
						drainStamina();				
					}
					break;
				case "assemble":
					Game.winGame(field);
					break;
				case "pass":
					stamina = 0;
					break;
				default:
					break;
			}
		}
	}
	
	/*
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
	
	/*
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
	
	/*
	 * Játékos staminájának csökkentése 1-gyel.
	 * @author Zalan
	 */
	public void drainStamina() 
	{
		stamina -= 1;
	}
	
	
	/*
	 * A játékos fuldoklásának beállítása.
	 * @author Zalan
	 */
	public void drown() {
		isDrowning = true;
	}
	
	/*
	 * A játékos megmentésre kerül fuldokló helyzetbõl.
	 * A játékos a paraméterként kapott field-re helyezõdik, és az isDrowning értéke false lesz.
	 * @author Zalan
	 * @param safeField a biztonságos mezõ, amire a játékos kerül.
	 */
	public boolean save(Field safeField) {
		isDrowning = false;
		field.moveMeTo(this, field.getNeighbours().indexOf(safeField));
		return true;
	}
	
	/*
	 * Egy tárgy eltávolítása a játékos inventory-jából.
	 * @author Zalan
	 * @param i ezen a sorszámú Item-et távolítjuk el az inventory-ból
	 */
	public void removeItem(Item i) {
		inventory.remove(i);
	}
		
	/*
	 * Játékos mezõjének beállítása.
	 * @author Zalan
	 * @param f a field új értéke
	 */
	public void setField(Field f) 
	{
		field = f;
	}
	
	/*
	 * Játékos mezõjének lekérdezése.
	 * @author Zalan
	 */
	public Field getField() 
	{
		return field;
	}
	
	/*
	 * Játékos fuldoklásának beállítása a kapott paraméterre.
	 * @author Zalan
	 * @param b az isDrowning értéke
	 */
	public void setIsDrowning(boolean b)
	{
		isDrowning = b;
	}
	
	/*
	 * Játékos nevének lekérdezése.
	 * @author Zalan
	 */
	public String getName()
	{
		return name;
	}
	
	/*
	 * Játékos nevének beállítása.
	 * @author Zalan
	 * @param n az új név
	 */
	public void setName(String n) {
		name = n;
	}
	
	/*
	 * A metódus visszaadja, hogy van-e a játékoson búvárruha.
	 * @author Zalan
	 */
	public boolean getdSuitOn()
	{
		return dSuitOn;
	}
	
	/*
	 * A metódus beállítja, hogy van-e a játékoson búvárruha.
	 * @author Zalan
	 * @param b a dSuitOn új értéke
	 */
	public void setdSuitOn(boolean b)
	{
		dSuitOn=b;
	}

	/*
	 * A metódus visszaadja a játékos inventory-jának i-edik elemét.
	 * @author Zalan
	 * @param i ezen sorszámú elemet adjuk vissza
	 */
	public Item getItem(int i) {
		if(inventory.size() == 0 || i >= inventory.size())
			return null;
		return inventory.get(i);
	}
	
	/*
	 * A játékos staminájának beállítása.
	 * @author Zalan
	 * @param s stamina új értéke
	 */
	public void setStamina(int s)
	{
		stamina = s;
	}
	
	/*
	 * A játékos életének beállítása beállítása.
	 * @author Zalan
	 * @param h health új értéke
	 */
	public void setHealth(int h)
	{
		health = h;
	}
	
	/*
	 * A metódus új, üres inventory-t hoz létre a játékosnak.
	 * @author Zalan
	 */
	public void resetInventory()
	{
		inventory=new ArrayList<Item>();
	}
	
	/*
	 * A metódus visszatér a játékos inventory-jával.
	 * @author Zalan
	 */
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	/*
	 * A metódus visszatér a játékos staminájával.
	 * @author Zalan
	 */
	public int getStamina()
	{
		return stamina;
	}
	
	/*
	 * A játékos a paraméterként kapott karaktert összeütközteti saját magával.
	 * @author Zalan
	 * @param c a karakter akivel összeütköztetjük magunkat
	 */
	public void collideWith(Character c) {
		c.hitBy(this);
	}

	/*
	 * Ha a játékos jegesmedvével ütközött, akkor a játékot elveszítették a játékosok.
	 * @author Zalan
	 * @param pb a jegesmedve amivel a játékos összeütközött
	 */
	@Override
	public void hitBy(PolarBear pb) {
		Game.loseGame();
	}
	
	/*
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
