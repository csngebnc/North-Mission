package Core;
import java.util.ArrayList;

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
		case 6:
			Eskimo e = new Eskimo();
			e.doTurn();
			break;
		case 7:
			Scientist sc = new Scientist();
			sc.doTurn();
			break;
		case 11:
			Eskimo ee = new Eskimo();
			ee.doTurn();
			
		}
		
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println("<-[Game].doRound()");
		
		
		
		//innen fog történni a blizzard kezelés, feltételek alapján, ez a hóvihar forgatókönyv végrehajtása szempontjából nem lényeges (Dominik)
			
	}
	
	//Dominik
	public void callBlizzard() 
	{
		System.out.println("Game.callBlizzard()");
		Map m = new Map();
		m.callBlizzardOnFields();
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
		
	}
}
