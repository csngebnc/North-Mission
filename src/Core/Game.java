package Core;
import java.util.ArrayList;

import Map.Field;
import Map.Map;
import Player.Player;

public class Game {
	
	private int roundNum;
	private int roundsUntilBlizzard;
	private static int foundGunParts;
	private Map map;
	private Player players;
	private GameState state;
	
	public void doRound() 
	{
		//innen fog t�rt�nni a blizzard kezel�s, felt�telek alapj�n, ez a h�vihar forgat�k�nyv v�grehajt�sa szempontj�b�l nem l�nyeges (Dominik)
			
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
