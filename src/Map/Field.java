package Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Scanner;

import Core.Game;
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
	
	public Field() {
		snowLayers = (int)Math.random()*6;
		characters = new ArrayList<Character>();
		neighbours = new ArrayList<Field>();
		maxplayers = Game.characters.size();
		building = null;
	}
	
	// H�vihar gener�l�sa a mez�n.
	public void generateBlizzard() 
	{
		snowLayers += Math.random()*5;
	}
	
	//J�t�kos elmozd�t�sa egy mez�re az adott mez�r�l egy kapott ir�nyba.
	public void moveMeTo(Character c, int next) 
	{
		neighbours.get(next).acceptCharacter(c);		
		c.drainStamina();
	}
	
	// Sarkkutat� j�t�kos h�vhatja a mez�t, ezzel felvedve mekkora a teherb�r�sa.
	public void revealLimit() 
	{
		System.out.println("The field's can hold "+maxplayers+" characters at the time.");
	}
	
	// A lesz�rmazottak maguk val�s�tj�k meg.
	public abstract void acceptCharacter(Character c);
	
	// A lesz�rmazottak maguk val�s�tj�k meg.
	public void acceptItem(Item i) {}
	
	//Alapimplement�ci�ja nem ad vissza t�rgyat..
	public Item pickUpItem(Player p) 
	{
		return null;
	}
	
	// Mez�n t�rt�n� �s�s, param�terk�nt kapott �rt�kkel cs�kkenti a h�r�teget, ha van h�.
	// Jelen esetben felt�telezz�k, hogy van elt�vol�that� h�.
	public boolean digSnow(int amount) 
	{
		return false;
	}

	// T�rgy kiszabad�t�sa j�gb�l. K�s�bb a mez�n tal�lhat� t�rgyak k�z� ker�l a kiszabad�tott t�rgy.
	public void removeItemFromIce(Player p) {}
	
	// J�t�kos ment�se adott ir�nyba.
	public boolean savePerson(int dir) 
	{
		return false;
	}
	
	
	// Iglu elhelyez�se a mez�n.
	public boolean buildBuilding(Building b) 
	{
		return false;
	}
	
	public void tickBuilding() {}
	
	
	// Visszaadja a szomsz�dot adott ir�nyb�l. V�ltozik m�g, jelenleg csak a forgat�k�nyvh�z lett be�ll�tva..
	public Field getNeighbour(int num)
	{
		return neighbours.get(num);
	}
	
	public void addNeighbour(Field f) {
		neighbours.add(f);
	}
	
	public void setFrozenItem(Item i) {
		
	}
	
	//Visszaadja a mez�n tal�lhat� j�t�kosokat.
	public ArrayList<Character> getCharacters()
	{
		return characters;
	}
	
	public void setLimit(int limit) {
		
	}
}
