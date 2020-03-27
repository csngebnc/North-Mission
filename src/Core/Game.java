package Core;
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
		//innen fog történni a blizzard kezelés, feltételek alapján, ez a hóvihar forgatókönyv végrehajtása szempontjából nem lényeges (Dominik)
			
	}
	
	//Dominik
	public void callBlizzard() 
	{
		map.callBlizzardOnFields();
	}
	
	public static void winGame(Field f) 
	{
	
	}
	
	public static void loseGame() 
	{
	
	}
	
	public static void incGunParts() 
	{
		
	}
}
