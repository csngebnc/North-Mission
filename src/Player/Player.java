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
	
	// J�t�kos inventory-j�nak megjelen�t�se.
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
	
	// J�t�kos k�re
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
	
	//B�v�rruha haszn�lat
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
	
	// J�t�kos �let�nek v�ltoztat�sa 'n' egys�ggel
	public void alterHealth(int n) 
	{
		health += n;
	}
	
	// J�t�kos stamin�j�nak cs�kkent�se 1-gyel
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
	
	// J�t�kos mez�j�nek be�ll�t�sa
	public void setField(Field f) 
	{
		field = f;
	}
	
	// J�t�kos mez�j�nek lek�r�se
	public Field getField() 
	{
		return field;
	}
	
	// J�t�kos fuldokl�s�nak be�ll�t�sa
	public void setIsDrowning(boolean b)
	{
		isDrowning = b;
	}
	
	//J�t�kos nev�nek visszaad�sa
	public String getName()
	{
		return name;
	}
	
	// Visszaadja, hogy van-e a j�t�koson b�v�rruha
	public boolean getdSuitOn()
	{
		return dSuitOn;
	}
	
	//Be�ll�tja, hogy van-e a j�t�koson b�v�rruha
	public void setdSuitOn(boolean b)
	{
		dSuitOn=b;
	}
	
	//Az inventory i-edik elem�t adja vissza
	public Item getItem(int i) {
		if(inventory.size() == 0 || i >= inventory.size())
			return null;
		return inventory.get(i);
	}
	
	//A j�t�kos stamin�j�t �ll�tjuk be
	public void setStamina(int s)
	{
		stamina = s;
	}
	
	//A j�t�kos �let�t �ll�tjuk be
	public void setHealth(int h)
	{
		health = h;
	}
	
	//�j, �res inventory-t hozunk l�tre a j�t�kosnak
	public void resetInventory()
	{
		inventory=new ArrayList<Item>();
	}
	
	//Visszat�r a j�t�kos inventoryj�val
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	//Visszat�r a j�t�kos stamin�j�val
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
