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
import Player.Eskimo;
import Player.Player;


public abstract class Field
{
	protected int snowLayers;
	protected int maxplayers;
	protected ArrayList<Player> players;
	protected Field neighbours;
	private boolean iglooOnField;
	
	//Dominik
	public void generateBlizzard() 
	{
		System.out.println(Main.tabok+"->[Field].generateBlizzard()");
		Main.tabok+="\t";
		
		//Iglu eldöntése input alapján
		boolean loop = true;
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.print(Main.tabok+"Legyen a mezõn iglu? (Y - IGEN, N - NEM)\n"+Main.tabok);
		
		while(loop) {
			try {
				bemenet = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(bemenet.equals("Y")) {
				iglooOnField = true;
				loop = false;
			} else if (bemenet.equals("N")) {
				iglooOnField = false;
				loop = false;
			}
		}
		
		//Nincs iglu a mezõn -> Rajta levõ játékosok HP-ja 1-el csökken
		if(iglooOnField == false) {
			Player p = new Eskimo();
			p.alterHealth(-1);
		}
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Field].generateBlizzard()");
	}
	
	public void moveMeTo(Player p, Direction dir) 
	{
		System.out.println("Field.moveMeTo");
		//Itt késõbb a neighbours attribútumot fogja használni.
		Field neighbours = new IceField();
		neighbours.acceptPlayer(p);
		
	}
	
	public void revealLimit() 
	{
		System.out.println(Main.tabok+"->[Field].revealLimit()");
		System.out.println(Main.tabok+"<-[Field].revealLimit()");
	}
	
	public abstract void acceptPlayer(Player p);
	
	//Dominik 
	public void acceptItem(Item i) {	}
	
	//Dominik
	//Alapimplementációja nem ad vissza tárgyat.
	public Item pickUpItem(Player p) 
	{
		return null;
	}
	
	//Dominik
	public boolean digSnow(int amount) 
	{
		System.out.println(Main.tabok+"->[Field].digSnow(int amount)");
		System.out.println(Main.tabok+"<-[Field].digSnow(int amount)");
		
		//Lekérdezés: volt-e eltakaritandó hó
		return true;
	}
	
	public void removeItemFromIce(Player p) 
	{
		
	}
	
	//Dani
	public boolean savePerson(Direction dir) 
	{
		//Itt késõbb az f2players helyett a players attribútum lesz használva.
		ArrayList<Player>f2players = new ArrayList<Player>();
		f2players.add(new Eskimo());
		f2players.add(new Eskimo());
		f2players.add(new Eskimo());
		
		if(f2players.size()>0)
		{
			System.out.println("Field.savePerson");
			System.out.println("Kit?");
			for(int i=0; i<f2players.size();i++)
			{
				System.out.println(i+": Játékos"+i);
			}
			
			Scanner myObj = new Scanner(System.in);
			String name = myObj.nextLine();
			
			//Itt késõbb a kiválaszott játékos lesz p2 értéke
			Player p2 = new Eskimo();
			moveMeTo(p2,dir);
			Field f1 = neighbours;
			p2.setField(f1);
			return true;
		}
		return false;
	}
	
	public boolean buildIgloo() 
	{
		return true;
	}
	//Dani
	public Field getNeighbours()
	{
		System.out.println("Field.getNeighbours");
		return neighbours;
	}
	
	//Dani
	public ArrayList<Player> getPlayers()
	{
		System.out.println("Field.getPlayer()");
		return players;
	}
}
