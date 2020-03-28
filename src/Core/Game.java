package Core;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Items.Barrel;
import Items.Item;
import Items.Shovel;
import Map.Field;
import Map.Map;
import Player.Eskimo;
import Player.Player;
import Player.Scientist;

public class Game {
	
	private int roundNum;
	private int roundsUntilBlizzard;
	private static int foundGunParts;
	private Map map;
	private Player players;
	private GameState state;
	
	public void doRound() 
	{
		System.out.println("->[Game].doRound()");
		Main.tabok+="\t";
		switch(Main.FORGATOKONYV_SZAMA) {
		case 5:
			this.callBlizzard();
			break;
		case 6:
			Eskimo e = new Eskimo();
			e.doTurn();
			break;
		case 7:
			Scientist sc = new Scientist();
			sc.doTurn();
			break;
		case 9:
			Eskimo e1 = new Eskimo();
			e1.doTurn();
			break;
		case 10:
			Eskimo e2 = new Eskimo();
			e2.doTurn();
			break;
		case 11:
			Eskimo e3 = new Eskimo();
			e3.doTurn();
			break;
		case 12:
			Eskimo e4 = new Eskimo();
			e4.doTurn();
			break;
		}
		
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println("<-[Game].doRound()");
		
		
		
		//innen fog történni a blizzard kezelés, feltételek alapján, ez a hóvihar forgatókönyv végrehajtása szempontjából nem lényeges (Dominik)
			
	}
	
	//Dominik
	public void callBlizzard() 
	{
		System.out.println(Main.tabok+"->[Game].callBlizzard()");
		Main.tabok+="\t";
		
		Map m = new Map();
		m.callBlizzardOnFields();
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Game].callBlizzard()");
	}
	
	public static void winGame(Field f) 
	{
		System.out.println("Game.winGame()");
		ArrayList <Player> players = new ArrayList <Player>();
		players = f.getPlayers();
	}
	
	public static void loseGame() 
	{
	
	}
	
	public static void incGunParts()
	{
		System.out.println(Main.tabok+"->[Game].incGunParts()");
		System.out.println(Main.tabok+"<-[Game].incGunParts()");
		
	}
}
