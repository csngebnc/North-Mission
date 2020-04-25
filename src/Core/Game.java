package Core;
import java.util.ArrayList;
import Map.Field;
import Map.Map;
import Player.Character;
import Player.Eskimo;
import Player.PolarBear;
import Player.Scientist;

public class Game {
	
	private int roundNum;
	private int roundsUntilBlizzard;
	private static int foundGunParts;
	private Map map;
	// statikussá tettem õket, mert csak úgy lehet hozzájuk férni a winGame-ben
	public static ArrayList<Character> characters;
	private static GameState state;
	
	public Game() {
		roundNum = 0;
		roundsUntilBlizzard = -1;
		foundGunParts = 0;
		map = new Map();
		characters = new ArrayList<Character>();
		state = GameState.NOTSTARTED;
	}

	public void doRound() 
	{
		state = GameState.ONGOING;
		while(state == GameState.ONGOING) {
			roundNum++;
			if(roundsUntilBlizzard == -1) {
				int hovihar_esely = (int) (Math.random()*4);
				if(hovihar_esely == 2) {
					roundsUntilBlizzard = (int) (Math.random()*4+2);
				}
			}
			
			if(roundsUntilBlizzard>0) {
				roundsUntilBlizzard--;
				System.out.println("Rounds until blizzard: "+roundsUntilBlizzard);
				if(roundsUntilBlizzard == 0) {
					callBlizzard();
				}
			}
			
			System.out.println("Round number: "+roundNum);
			for(Character c: characters) {
				c.doTurn();
				if(state != GameState.ONGOING) {
					break;
				}
			}
		}
	}
	
	public void callBlizzard() 
	{
		map.callBlizzardOnFields();
	}
	
	public static void winGame(Field f) 
	{
		if(foundGunParts==3 && (f.getCharacters().size()>=characters.size())) {
			state = GameState.WON;
			System.out.println("The players won the game.");
		}		
	}
	
	public static void loseGame() 
	{
		state = GameState.LOST;
		System.out.println("The players lost the game.");
	}
	
	public static void incGunParts()
	{
		foundGunParts++;
		System.out.println("Found gunparts incremented, num: "+foundGunParts);		
	}
	
	public Map getMap() {
		return map;
	}
	
	public void setFoundGunParts(int i) {
		foundGunParts = i;
	}
	
	public int getFoundGunparts() {
		return foundGunParts;
	}
	
	public void Reset() {
		characters = new ArrayList<Character>();
		Eskimo e1 = new Eskimo();
		Scientist s1 = new Scientist();
		Scientist s2 = new Scientist();
		PolarBear pb = new PolarBear();
		
		map.Reset();
		map.getField(5).acceptCharacter(e1);
		map.getField(10).acceptCharacter(s1);
		map.getField(12).acceptCharacter(s2);
		map.getField(1).acceptCharacter(pb);
		
		characters.add(e1);
		characters.add(s1);
		characters.add(s2);
		characters.add(pb);
	}
	
	public void addCharacter(Character c, int f) {
		map.getField(f).acceptCharacter(c);
		characters.add(c);
	}
	
	public int getRoundNum()
	{
		return roundNum;
	}
	
	public ArrayList<Character> getCharacters()
	{
		return characters;
		
	}
}
