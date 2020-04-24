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
	
	// J�t�kos inventory-j�nak megjelen�t�se.
	protected void openInventory() 
	{
	}
	
	// J�t�kos k�re
	public void doTurn() 
	{
	}
	
	//B�v�rruha haszn�lat
	public boolean changeSuit(DivingSuit dsuit) 
	{
		return false;
	}
	
	// J�t�kos �let�nek v�ltoztat�sa fog itt t�rt�nni.
	public void alterHealth(int n) 
	{
		System.out.println(Main.tabok+"->[Player].alterHealth()");
		System.out.println(Main.tabok+"<-[Player].alterHealth()");
	}
	
	// J�t�kos stamin�j�nak cs�kkent�se fog itt t�rt�nni.
	public void drainStamina() 
	{
		System.out.println(Main.tabok+"->[Player].drainStamina()");
		System.out.println(Main.tabok+"<-[Player].drainStamina()");
	}
	
	public void drown() {}
	public boolean save(Field f) { return false;}
	public void removeItem(Item i) {}
	
	// J�t�kos mez�j�nek be�ll�t�sa fog itt t�rt�nni.
	public void setField(Field f) 
	{
		
	}
	
	// J�t�kos mez�j�nek lek�r�se
	public Field getField() 
	{
		//K�s�bb a 'field' tagv�ltoz�t fogja visszaadni
		return new IceField();
	}
	
	// J�t�kos fuldokl�s�nak be�ll�t�s fog itt t�rt�nni.
	public void setIsDrowning(boolean b)
	{
		
	}
	
	//J�t�kos nev�nek visszaad�sa.
	public String getName()
	{
		return name;
	}
	
	// Visszaadja, hogy van-e a j�t�koson b�v�rruha.
	public boolean getdSuitOn()
	{
		return dSuitOn;
	}
	
	
	public void setdSuitOn(boolean b)
	{
		dSuitOn=b;
	}
	
	public Item getItem(int i) {
		if(inventory.size() == 0)
			return null;
		return inventory.get(i);
	}
	
	public void setStamina(int s)
	{
		stamina = s;
	}
	
	public void setHealth(int h)
	{
		health = h;
	}
	
	public void resetInventory()
	{
		inventory=new ArrayList<Item>();
	}
	
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}
	
	public int getStamina()
	{
		return stamina;
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
