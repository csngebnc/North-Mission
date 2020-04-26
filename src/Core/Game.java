package Core;
import java.util.ArrayList;
import Map.Field;
import Map.Map;
import Player.Character;
import Player.Eskimo;
import Player.PolarBear;
import Player.Scientist;

public class Game {
	
	private static int players = 0;
	private int roundNum;
	private int roundsUntilBlizzard;
	private static int foundGunParts;
	private Map map;
	public static ArrayList<Character> characters;
	private static GameState state;
	
	
	/*
	 * Game osztaly konstruktora, alapertelmezett ertekek beallitasa
	 * @author Csonge Bence
	 */
	public Game() {
		roundNum = 0;
		roundsUntilBlizzard = -1;
		foundGunParts = 0;
		map = new Map();
		characters = new ArrayList<Character>();
		state = GameState.NOTSTARTED;
	}

	/*
	 * A jatek elinditasara es korok vezenylesere szolgalo metodus
	 * Veletlenszeruen bekovetkezhet egy hovihar, valamint minden karakter "leptetese" egy korben
	 * egeszen addig, amig a jatekot nem veszitik, vagy nem nyerik meg.
	 * @author Csonge Bence
	 */
	public void doRound() 
	{
		state = GameState.ONGOING;
		while(state == GameState.ONGOING) {
			map.tickBuildings();
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
	
	/*
	 * Hovihar bekovetkezesenek tovabbitasa a palya fele.
	 * @author Csonge Bence
	 */
	public void callBlizzard() 
	{
		map.callBlizzardOnFields();
	}
	
	/*
	 * A Game osztaly ertesitese arrol, hogy a jatekosok megnyertek a jatekot.
	 * Megtortenik a feltetelek teljesulesenek vizsgalata, majd aszerint allitja be a jatek allapotat.
	 * @param f : A mezõ, amelyen az összes játékos tartózkodni kell a gyõzelemhez.
	 * @author Csonge Bence
	 */
	public static void winGame(Field f) {
		if(foundGunParts==3 && (f.getCharacters().size()==players)) {
			state = GameState.WON;
			System.out.println("The players won the game.");
		}		
	}
	
	/*
	 * A Game osztaly ertesitese arrol, hogy a jatekot elvesztettek a jatekosok valamilyen okbol,
	 * a jatek allapota beallitasra kerul.
	 * @author Csonge Bence 
	 */
	public static void loseGame() 
	{
		state = GameState.LOST;
		System.out.println("The players lost the game.");
	}
	
	/*
	 * A Game osztaly ertesitese arrol, hogy a jatekosok osszegyujtottek egy, 
	 * a jatek megnyeresehez szukseges alkatreszt.
	 * @author Csonge Bence
	 */
	public static void incGunParts()
	{
		foundGunParts++;
		System.out.println("Found gunparts incremented, num: "+foundGunParts);		
	}
	
	/*
	 * A tovabbiakban getter/setter, valamint a teszteleshez szukseges metodusok talalhatok.
	 */
	
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
		players = 3;
		
		map.Reset();
		
		addEskimo(5, "Elton");
		addScientist(10, "John");
		addScientist(12, "Michael");
		addPolarBear(1);
	}
	
	public void addScientist(int fieldIndex, String name) {
		Scientist newScientist = new Scientist();
		newScientist.setName(name);
		map.getField(fieldIndex).acceptCharacter(newScientist);
		characters.add(newScientist);
	}
	
	public void addEskimo(int fieldIndex, String name) {
		Eskimo newEskimo = new Eskimo();
		newEskimo.setName(name);
		map.getField(fieldIndex).acceptCharacter(newEskimo);
		characters.add(newEskimo);
	}
	
	public void addPolarBear(int fieldIndex) {
		PolarBear newPolarBear = new PolarBear();
		map.getField(fieldIndex).acceptCharacter(newPolarBear);
		characters.add(newPolarBear);
	}
	
	public static int getPlayerCount() {
		return players;
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
