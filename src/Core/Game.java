package Core;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Visual.View;
import Map.Field;
import Map.Map;
import Player.Character;
import Player.Eskimo;
import Player.Player;
import Player.PolarBear;
import Player.Scientist;

/**
 * A jatekot osszefogo osztaly
 * @author Csonge Bence
 */
public class Game {
	
	/**
	 * A körök száma
	 * @author Csonge Bence
	 */
	private static int roundNum;
	
	/**
	 * Hány kör múlva lesz hóvihar, -1 ha jelenleg nincsen közelgõ hóvihar
	 * @author Csonge Bence
	 */
	private int roundsUntilBlizzard;
	
	/**
	 * A játékosok által megtalált alkatrészek száma
	 * @author Csonge Bence
	 */
	private static boolean foundGunParts[];
	
	/**
	 * A pálya amin a játék játszódik
	 * @author Csonge Bence
	 */
	private static Map map;
	
	/**
	 * A játékban részvevõ karakterek
	 * @author Csonge Bence
	 */
	public ArrayList<Character> characters;
	
	/**
	 * A játékban résztvevõ játékosok
	 * @author Csonge Bence
	 */
	public static ArrayList<Player> players;
	
	/**
	 * A játék állapota
	 * @author Csonge Bence
	 */
	private static GameState state;
	
	/**
	 * A játék nézete, ez jeleniti meg a játékot
	 * @author Csonge Bence
	 */
	private static View view;
	
	/**
	 * Az éppen soron levõ karakter
	 * @author Balczer Dominik
	 */
	private Character activeCharacter;
	
	/**
	 * Singleton tervezési minta alapján a Game osztály egyetlen példánya
	 * @author Balczer Dominik
	 */
	private static Game instance = new Game();
	
	/**
	 * Üres konstruktor, priváttá téve a Singleton elveket követve
	 * @author Balczer Dominik
	 */
	private Game() {	}
	
	/**
	 * Játék alaphelyzetbe állitása, inicializálása és elinditása
	 * @author Balczer Dominik
	 */
	public void Reset(ArrayList<String> playerNames, ArrayList<String> playerTypes) {
		
		roundNum = 0;
		roundsUntilBlizzard = -1;
		foundGunParts = new boolean[3];
		
		foundGunParts[0] = false;
		foundGunParts[1] = false;
		foundGunParts[2] = false;
		
		int playerCount = playerNames.size();
		
		map = new Map();
		map.Reset(playerCount);
		
		players = new ArrayList<Player>();
		characters = new ArrayList<Character>();
		
		for(int i = 0; i < playerCount; i++) {
			if(playerTypes.get(i) == "eskimo")
				addEskimo(0, playerNames.get(i));
			else
				addScientist(0, playerNames.get(i));
		}
		
		addPolarBear((int)(Math.random()*30) + 60);
		
		state = GameState.ONGOING;
		activeCharacter = characters.get(0);
		activeCharacter.startTurn();
	}
	
	/**
	 * Kutató hozzáadása a játékhoz
	 * @author Balczer Dominik
	 */
	public void addScientist(int fieldIndex, String name) {
		Scientist newScientist = new Scientist();
		newScientist.setName(name);
		map.getField(fieldIndex).acceptCharacter(newScientist);
		characters.add(newScientist);
		players.add(newScientist);
	}
	
	/**
	 * Eszkimó hozzáadása a játékhoz
	 * @author Balczer Dominik
	 */
	public void addEskimo(int fieldIndex, String name) {
		Eskimo newEskimo = new Eskimo();
		newEskimo.setName(name);
		map.getField(fieldIndex).acceptCharacter(newEskimo);
		characters.add(newEskimo);
		players.add(newEskimo);
	}
	
	/**
	 * Jegesmedve hozzáadása a játékhoz
	 * @author Balczer Dominik
	 */
	public void addPolarBear(int fieldIndex) {
		PolarBear newPolarBear = new PolarBear();
		map.getField(fieldIndex).acceptCharacter(newPolarBear);
		characters.add(newPolarBear);
	}
	
	/**
	 * Nézet csatolása a játékhoz
	 * @param v : A csatolandó View
	 * @author Balczer Dominik
	 */
	public static void attachView(View v) {
		view = v;
	}
	
	/**
	 * Nézet értesitése hogy megváltozott a pálya, ki kell újra rajzolni
	 * @author Balczer Dominik
	 */
	public static void notifyView() {
		view.revalidate();
	}

	/**
	 * Ha még nem vesztettünk akkor léptetjük a játékot a következõ körbe.
	 * Növeljük a körök számát és ha nincs jelenleg közelgõ hóvihar akkor véletlenszerûen generálunk egyet,
	 * ha pedig éppen most kell bekövetkeznie, akkor hóvihart hivunk a pályán.
	 * @author Csonge Bence
	 */
	public void doRound() {
		if(state != GameState.ONGOING)
			return;
		
		roundNum++;
				
		//Ha nincs közelgõ hóvihar, véletlenszerûen létrehozunk egyet
		if(roundsUntilBlizzard == -1)
			if((int) (Math.random()*10) == 2)
				roundsUntilBlizzard = (int) (Math.random()*4+2);
			
		//Ha van közelgõ hóvihar, léptetjük
		if(roundsUntilBlizzard>0) 
			roundsUntilBlizzard--;
		
		//Ha most jött el a hóvihar ideje, akkor meghivjuk a pályán
		if(roundsUntilBlizzard == 0) {
			roundsUntilBlizzard--;
			callBlizzard();
		}
		
		map.tickBuildings();
	}
	
	/**
	 * Soron következõ karakter kiválasztása, ha körbeértünk akkor új kör inditása doRound()-al
	 * @author Csönge Bence
	 */
	public void nextCharacter() {
		if(characters.indexOf(activeCharacter) == characters.size()-1) {
			doRound();
			activeCharacter = characters.get(0);;
		}
		else
			activeCharacter = characters.get(characters.indexOf(activeCharacter)+1);
		
		if(state == GameState.ONGOING)
			activeCharacter.startTurn();
		notifyView();
	}
	
	/**
	 * Input kezelõ, ha vége a játéknak visszadob a menübe,
	 * egyébként átadja az inputot lekezelésre a soron levõ karakternek.
	 * @param e : Megnyomott billentyû KeyEvent-je
	 * @author Balczer Dominik
	 */
	public void InputCame(KeyEvent e) {
		if(state!=GameState.ONGOING) {
			WindowFrame.switchToMenu();
			return;
		}
		activeCharacter.doTurn(e);
	}
	
	/**
	 * Hóvihar hivása
	 * @author Balczer Dominik
	 */
	public void callBlizzard() 
	{
		map.callBlizzardOnFields();
		view.revalidate();
	}
	
	/**
	 * Game értesitése jelzõpisztoly alkatrész megtalálásáról
	 * @param i : Azonositja melyiket találtuk meg
	 * @author Csonge Bence
	 */
	public static void incGunParts(int i)
	{
		foundGunParts[i] = true;
	}
	
	/**
	 * foundGunParts gettere
	 * param i : gunPart indexe
	 * @author Csonge Bence
	 */
	public static boolean getFoundGunPart(int i)
	{
		return foundGunParts[i];
	}
	
	/**
	 * Játék megnyerésének kezdeményezése, ha a feltételek teljesülnek, a játékállapot WON lesz.
	 * @param f : A kezdeményezést inditó játékos mezõje
	 * @author Csonge Bence
	 */
	public static void winGame(Field f) {
		for(boolean found : foundGunParts)
			if(!found)
				return;
		
		if(f.getCharacters().size()==players.size())
			state = GameState.WON;
	}
	
	/**
	 * Játék értesitése arról hogy vesztettünk
	 * @author Csonge Bence 
	 */
	public static void loseGame() 
	{
		state = GameState.LOST;
	}
	
	/**
	 * Visszaadja a Game osztály egyetlen példányát
	 * @author Balczer Dominik
	 */
	public static Game getInstance() {
		return instance;
	}
	
	/**
	 * Visszaadja a view-t
	 * @author Balczer Dominik
	 */
	public static View getView() {
		return view;
	}
	
	/**
	 * Visszaadja a jelenlegi kör számát
	 * @author Balczer Dominik
	 */
	public static int getRoundNum() {
		return roundNum;
	}
	
	/**
	 * Visszaadja hány kör van még hóviharig
	 * @author Balczer Dominik
	 */
	public int getRoundsUntilBlizzard() {
		return roundsUntilBlizzard;
	}
	
	/**
	 * Visszaadja a pályamodelt
	 * @author Balczer Dominik
	 */
	public Map getMap() {
		return map;
	}
	
	/**
	 * Visszaadja a játék állapotát
	 * @author Balczer Dominik
	 */
	public GameState getState() {
		return state;
	}
	
	/**
	 * Visszaadja a játékosok számát
	 * @author Balczer Dominik
	 */
	public static int getPlayerCount() {
		return players.size();
	}
}