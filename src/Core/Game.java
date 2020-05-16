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
	 * A k�r�k sz�ma
	 * @author Csonge Bence
	 */
	private static int roundNum;
	
	/**
	 * H�ny k�r m�lva lesz h�vihar, -1 ha jelenleg nincsen k�zelg� h�vihar
	 * @author Csonge Bence
	 */
	private int roundsUntilBlizzard;
	
	/**
	 * A j�t�kosok �ltal megtal�lt alkatr�szek sz�ma
	 * @author Csonge Bence
	 */
	private static boolean foundGunParts[];
	
	/**
	 * A p�lya amin a j�t�k j�tsz�dik
	 * @author Csonge Bence
	 */
	private static Map map;
	
	/**
	 * A j�t�kban r�szvev� karakterek
	 * @author Csonge Bence
	 */
	public ArrayList<Character> characters;
	
	/**
	 * A j�t�kban r�sztvev� j�t�kosok
	 * @author Csonge Bence
	 */
	public static ArrayList<Player> players;
	
	/**
	 * A j�t�k �llapota
	 * @author Csonge Bence
	 */
	private static GameState state;
	
	/**
	 * A j�t�k n�zete, ez jeleniti meg a j�t�kot
	 * @author Csonge Bence
	 */
	private static View view;
	
	/**
	 * Az �ppen soron lev� karakter
	 * @author Balczer Dominik
	 */
	private Character activeCharacter;
	
	/**
	 * Singleton tervez�si minta alapj�n a Game oszt�ly egyetlen p�ld�nya
	 * @author Balczer Dominik
	 */
	private static Game instance = new Game();
	
	/**
	 * �res konstruktor, priv�tt� t�ve a Singleton elveket k�vetve
	 * @author Balczer Dominik
	 */
	private Game() {	}
	
	/**
	 * J�t�k alaphelyzetbe �llit�sa, inicializ�l�sa �s elindit�sa
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
	 * Kutat� hozz�ad�sa a j�t�khoz
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
	 * Eszkim� hozz�ad�sa a j�t�khoz
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
	 * Jegesmedve hozz�ad�sa a j�t�khoz
	 * @author Balczer Dominik
	 */
	public void addPolarBear(int fieldIndex) {
		PolarBear newPolarBear = new PolarBear();
		map.getField(fieldIndex).acceptCharacter(newPolarBear);
		characters.add(newPolarBear);
	}
	
	/**
	 * N�zet csatol�sa a j�t�khoz
	 * @param v : A csatoland� View
	 * @author Balczer Dominik
	 */
	public static void attachView(View v) {
		view = v;
	}
	
	/**
	 * N�zet �rtesit�se hogy megv�ltozott a p�lya, ki kell �jra rajzolni
	 * @author Balczer Dominik
	 */
	public static void notifyView() {
		view.revalidate();
	}

	/**
	 * Ha m�g nem vesztett�nk akkor l�ptetj�k a j�t�kot a k�vetkez� k�rbe.
	 * N�velj�k a k�r�k sz�m�t �s ha nincs jelenleg k�zelg� h�vihar akkor v�letlenszer�en gener�lunk egyet,
	 * ha pedig �ppen most kell bek�vetkeznie, akkor h�vihart hivunk a p�ly�n.
	 * @author Csonge Bence
	 */
	public void doRound() {
		if(state != GameState.ONGOING)
			return;
		
		roundNum++;
				
		//Ha nincs k�zelg� h�vihar, v�letlenszer�en l�trehozunk egyet
		if(roundsUntilBlizzard == -1)
			if((int) (Math.random()*10) == 2)
				roundsUntilBlizzard = (int) (Math.random()*4+2);
			
		//Ha van k�zelg� h�vihar, l�ptetj�k
		if(roundsUntilBlizzard>0) 
			roundsUntilBlizzard--;
		
		//Ha most j�tt el a h�vihar ideje, akkor meghivjuk a p�ly�n
		if(roundsUntilBlizzard == 0) {
			roundsUntilBlizzard--;
			callBlizzard();
		}
		
		map.tickBuildings();
	}
	
	/**
	 * Soron k�vetkez� karakter kiv�laszt�sa, ha k�rbe�rt�nk akkor �j k�r indit�sa doRound()-al
	 * @author Cs�nge Bence
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
	 * Input kezel�, ha v�ge a j�t�knak visszadob a men�be,
	 * egy�bk�nt �tadja az inputot lekezel�sre a soron lev� karakternek.
	 * @param e : Megnyomott billenty� KeyEvent-je
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
	 * H�vihar hiv�sa
	 * @author Balczer Dominik
	 */
	public void callBlizzard() 
	{
		map.callBlizzardOnFields();
		view.revalidate();
	}
	
	/**
	 * Game �rtesit�se jelz�pisztoly alkatr�sz megtal�l�s�r�l
	 * @param i : Azonositja melyiket tal�ltuk meg
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
	 * J�t�k megnyer�s�nek kezdem�nyez�se, ha a felt�telek teljes�lnek, a j�t�k�llapot WON lesz.
	 * @param f : A kezdem�nyez�st indit� j�t�kos mez�je
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
	 * J�t�k �rtesit�se arr�l hogy vesztett�nk
	 * @author Csonge Bence 
	 */
	public static void loseGame() 
	{
		state = GameState.LOST;
	}
	
	/**
	 * Visszaadja a Game oszt�ly egyetlen p�ld�ny�t
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
	 * Visszaadja a jelenlegi k�r sz�m�t
	 * @author Balczer Dominik
	 */
	public static int getRoundNum() {
		return roundNum;
	}
	
	/**
	 * Visszaadja h�ny k�r van m�g h�viharig
	 * @author Balczer Dominik
	 */
	public int getRoundsUntilBlizzard() {
		return roundsUntilBlizzard;
	}
	
	/**
	 * Visszaadja a p�lyamodelt
	 * @author Balczer Dominik
	 */
	public Map getMap() {
		return map;
	}
	
	/**
	 * Visszaadja a j�t�k �llapot�t
	 * @author Balczer Dominik
	 */
	public GameState getState() {
		return state;
	}
	
	/**
	 * Visszaadja a j�t�kosok sz�m�t
	 * @author Balczer Dominik
	 */
	public static int getPlayerCount() {
		return players.size();
	}
}