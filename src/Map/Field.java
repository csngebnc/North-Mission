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
	
	// H�vihar gener�l�sa a mez�n.
	public void generateBlizzard() 
	{
	}
	
	//J�t�kos elmozd�t�sa egy mez�re az adott mez�r�l egy kapott ir�nyba.
	public void moveMeTo(Character c, int dir) 
	{
		
	}
	
	// Sarkkutat� j�t�kos h�vhatja a mez�t, ezzel felvedve mekkora a teherb�r�sa.
	public void revealLimit() 
	{
		System.out.println(Main.tabok+"->[Field].revealLimit()");
		System.out.println(Main.tabok+"<-[Field].revealLimit()");
	}
	
	// A lesz�rmazottak maguk val�s�tj�k meg.
	public abstract void acceptCharacter(Character c);
	
	// A lesz�rmazottak maguk val�s�tj�k meg.
	public void acceptItem(Item i) {	}
	
	
	//Alapimplement�ci�ja nem ad vissza t�rgyat..
	public Item pickUpItem(Player p) 
	{
		return null;
	}
	
	// Mez�n t�rt�n� �s�s, param�terk�nt kapott �rt�kkel cs�kkenti a h�r�teget, ha van h�.
	// Jelen esetben felt�telezz�k, hogy van elt�vol�that� h�.
	public boolean digSnow(int amount) 
	{
		System.out.println(Main.tabok+"->[Field].digSnow(int amount)");
		System.out.println(Main.tabok+"<-[Field].digSnow(int amount)");
		
		//Lek�rdez�s: volt-e eltakar�that�.
		
		return true;
	}

	
	// T�rgy kiszabad�t�sa j�gb�l. K�s�bb a mez�n tal�lhat� t�rgyak k�z� ker�l a kiszabad�tott t�rgy.
	public void removeItemFromIce(Player p) 
	{
		System.out.println(Main.tabok+"->[Field].removeItemFromIce(Player p) ");
		System.out.println(Main.tabok+"<-[Field].removeItemFromIce(Player p) ");
	}
	
	// J�t�kos ment�se adott ir�nyba.
	public boolean savePerson(int dir) 
	{
		return false;
	}
	
	
	// Iglu elhelyez�se a mez�n.
	public boolean buildBuilding(Building b) 
	{
		return true;
	}
	
	public void tickBuilding() {}
	
	
	public void attackBuilding() {}

	// Visszaadja a szomsz�dot adott ir�nyb�l. V�ltozik m�g, jelenleg csak a forgat�k�nyvh�z lett be�ll�tva..
	public Field getNeighbour(int dir)
	{
		return neighbours.get(dir);
	}
	
	//Visszaadja a mez�n tal�lhat� j�t�kosokat.
	public ArrayList<Character> getCharacters()
	{
		return characters;
	}
}
