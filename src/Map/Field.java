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
import Player.Character;
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
		snowLayers += Math.random()*5;
	}
	
	//Játékos elmozdítása egy mezõre az adott mezõrõl egy kapott irányba.
	public void moveMeTo(Character c, int dir) 
	{
		neighbours.get(dir).acceptCharacter(c);		
	}
	
	// Sarkkutató játékos hívhatja a mezõt, ezzel felvedve mekkora a teherbírása.
	public void revealLimit() 
	{
		System.out.println("The field's can hold "+maxplayers+" characters at the time.");
	}
	
	// A leszármazottak maguk valósítják meg.
	public abstract void acceptCharacter(Character c);
	
	// A leszármazottak maguk valósítják meg.
	public void acceptItem(Item i) {}
	
	//Alapimplementációja nem ad vissza tárgyat..
	public Item pickUpItem(Player p) 
	{
		return null;
	}
	
	// Mezõn történõ ásás, paraméterként kapott értékkel csökkenti a hóréteget, ha van hó.
	// Jelen esetben feltételezzük, hogy van eltávolítható hó.
	public boolean digSnow(int amount) 
	{
		return false;
	}

	// Tárgy kiszabadítása jégbõl. Késõbb a mezõn található tárgyak közé kerül a kiszabadított tárgy.
	public void removeItemFromIce(Player p) {}
	
	// Játékos mentése adott irányba.
	public boolean savePerson(int dir) 
	{
		return false;
	}
	
	
	// Iglu elhelyezése a mezõn.
	public boolean buildBuilding(Building b) 
	{
		return false;
	}
	
	public void tickBuilding() {}
	
	
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
