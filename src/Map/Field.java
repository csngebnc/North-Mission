package Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Scanner;

import Core.Main;
import Items.Barrel;
import Items.Item;
import Items.Shovel;
import Map.Buildings.Building;
import Player.Eskimo;
import Player.Player;


public abstract class Field
{
	protected int snowLayers;
	protected int maxplayers;
	protected ArrayList<Character> characters;
	protected ArrayList<Field> neighbours;
	protected Building building;
	
	// Hóvihar generálása a mezõn.
	public void generateBlizzard() 
	{
	}
	
	//Játékos elmozdítása egy mezõre az adott mezõrõl egy kapott irányba.
	public void moveMeTo(Character c, int dir) 
	{
		
	}
	
	// Sarkkutató játékos hívhatja a mezõt, ezzel felvedve mekkora a teherbírása.
	public void revealLimit() 
	{
		System.out.println(Main.tabok+"->[Field].revealLimit()");
		System.out.println(Main.tabok+"<-[Field].revealLimit()");
	}
	
	// A leszármazottak maguk valósítják meg.
	public abstract void acceptCharacter(Character c);
	
	// A leszármazottak maguk valósítják meg.
	public void acceptItem(Item i) {	}
	
	
	//Alapimplementációja nem ad vissza tárgyat..
	public Item pickUpItem(Player p) 
	{
		return null;
	}
	
	// Mezõn történõ ásás, paraméterként kapott értékkel csökkenti a hóréteget, ha van hó.
	// Jelen esetben feltételezzük, hogy van eltávolítható hó.
	public boolean digSnow(int amount) 
	{
		System.out.println(Main.tabok+"->[Field].digSnow(int amount)");
		System.out.println(Main.tabok+"<-[Field].digSnow(int amount)");
		
		//Lekérdezés: volt-e eltakarítható.
		
		return true;
	}

	
	// Tárgy kiszabadítása jégbõl. Késõbb a mezõn található tárgyak közé kerül a kiszabadított tárgy.
	public void removeItemFromIce(Player p) 
	{
		System.out.println(Main.tabok+"->[Field].removeItemFromIce(Player p) ");
		System.out.println(Main.tabok+"<-[Field].removeItemFromIce(Player p) ");
	}
	
	// Játékos mentése adott irányba.
	public boolean savePerson(int dir) 
	{
		return false;
	}
	
	
	// Iglu elhelyezése a mezõn.
	public boolean buildBuilding(Building b) 
	{
		return true;
	}
	
	public void tickBuilding() {}
	
	
	public void attackBuilding() {}

	// Visszaadja a szomszédot adott irányból. Változik még, jelenleg csak a forgatókönyvhöz lett beállítva..
	public Field getNeighbour(int dir)
	{
		return neighbours.get(dir);
	}
	
	//Visszaadja a mezõn található játékosokat.
	public ArrayList<Character> getCharacters()
	{
		return characters;
	}
}
