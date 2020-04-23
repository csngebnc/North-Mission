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
	
	// Játékos inventory-jának megjelenítése.
	protected void openInventory() 
	{
	}
	
	// Játékos köre
	public void doTurn() 
	{
	}
	
	//Búvárruha használat
	public boolean changeSuit(DivingSuit dsuit) 
	{
		return false;
	}
	
	// Játékos életének változtatása fog itt történni.
	public void alterHealth(int n) 
	{
		System.out.println(Main.tabok+"->[Player].alterHealth()");
		System.out.println(Main.tabok+"<-[Player].alterHealth()");
	}
	
	// Játékos staminájának csökkentése fog itt történni.
	public void drainStamina() 
	{
		System.out.println(Main.tabok+"->[Player].drainStamina()");
		System.out.println(Main.tabok+"<-[Player].drainStamina()");
	}
	
	public void drown() {}
	public boolean save(Field f) { return false;}
	public void removeItem(Item i) {}
	
	// Játékos mezõjének beállítása fog itt történni.
	public void setField(Field f) 
	{
		System.out.println(Main.tabok+"->[Player].setField(Field f)");
		System.out.println(Main.tabok+"<-[Player].setField(Field f)");
		
	}
	
	// Játékos mezõjének lekérése
	public Field getField() 
	{
		System.out.println(Main.tabok+"->[Player].getField()");
		System.out.println(Main.tabok+"<-[Player].getField()");
		//Késõbb a 'field' tagváltozót fogja visszaadni
		return new IceField();
	}
	
	// Játékos fuldoklásának beállítás fog itt történni.
	public void setIsDrowning(boolean b)
	{
		System.out.println(Main.tabok+"->[Player].setIsDrowning(boolean b)");
		System.out.println(Main.tabok+"<-[Player].setIsDrowning(boolean b)");
	}
	
	//Játékos nevének visszaadása.
	public String getName()
	{
		System.out.println(Main.tabok+"->[Player].getName()");
		System.out.println(Main.tabok+"<-[Player].getName()");
		return name;
	}
	
	// Visszaadja, hogy van-e a játékoson búvárruha.
	public boolean getdSuitOn()
	{
		System.out.println(Main.tabok+"->[Player].getDSuitOn()");
		System.out.println(Main.tabok+"<-[Player].getDSuitOn()");
		return dSuitOn;
	}
	
	
	public void setdSuitOn(boolean b)
	{
		dSuitOn=b;
	}
	
	public Item getItem(int i) {
		return inventory.get(i);
	}
	
	public void setStamina(int s)
	{
		stamina=s;
	}
	
	public void setHealth(int h)
	{
		health=h;
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
	
}
