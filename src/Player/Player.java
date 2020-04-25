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
	
	public Player() {
		inventory = new ArrayList<Item>();
		isDrowning = false;
		dSuitOn = false;
	}
	public abstract void doSkill();
	
	// Játékos inventory-jának megjelenítése.
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
	
	// Játékos köre
	public void doTurn() 
	{
		stamina = 3;
		
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
				case "pickup":
					field.pickUpItem(this);
					break;
				case "drop":
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
				default:
					break;
			}
		}
	}
	
	//Búvárruha használat
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
	
	// Játékos életének változtatása 'n' egységgel
	public void alterHealth(int n) 
	{
		health += n;
	}
	
	// Játékos staminájának csökkentése 1-gyel
	public void drainStamina() 
	{
		stamina -= 1;
	}
	
	public void drown() {
		isDrowning = true;
	}
	
	
	public boolean save(Field f) { return false;}
	
	
	public void removeItem(Item i) {
		field.removeItemFromIce(this);
	}
	
	// Játékos mezõjének beállítása
	public void setField(Field f) 
	{
		field = f;
	}
	
	// Játékos mezõjének lekérése
	public Field getField() 
	{
		return field;
	}
	
	// Játékos fuldoklásának beállítása
	public void setIsDrowning(boolean b)
	{
		isDrowning = b;
	}
	
	//Játékos nevének visszaadása
	public String getName()
	{
		return name;
	}
	
	// Visszaadja, hogy van-e a játékoson búvárruha
	public boolean getdSuitOn()
	{
		return dSuitOn;
	}
	
	//Beállítja, hogy van-e a játékoson búvárruha
	public void setdSuitOn(boolean b)
	{
		dSuitOn=b;
	}
	
	//Az inventory i-edik elemét adja vissza
	public Item getItem(int i) {
		if(inventory.size() == 0 || i >= inventory.size())
			return null;
		return inventory.get(i);
	}
	
	//A játékos stamináját állítjuk be
	public void setStamina(int s)
	{
		stamina = s;
	}
	
	//A játékos életét állítjuk be
	public void setHealth(int h)
	{
		health = h;
	}
	
	//Új, üres inventory-t hozunk létre a játékosnak
	public void resetInventory()
	{
		inventory=new ArrayList<Item>();
	}
	
	//Visszatér a játékos inventoryjával
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	//Visszatér a játékos staminájával
	public int getStamina()
	{
		return stamina;
	}
	
	public void collideWith(Character c) {
		c.hitBy(this);
	}

	@Override
	public void hitBy(PolarBear pb) {
		Game.loseGame();
	}
	
	
	@Override
	public void Properties()
	{
		System.out.println(this.getClass());
		System.out.println("Helth: " + health);
		System.out.println("Stamina: " + stamina);
		System.out.println("Is drowning: " + isDrowning);
		System.out.println("Diving suit: " + dSuitOn);
		System.out.println("Inventory:");
		for(Item i : inventory) {
			i.Properties();
		}
	}
}
