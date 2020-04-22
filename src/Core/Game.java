package Core;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Items.Barrel;
import Items.Item;
import Items.Shovel;
import Map.Field;
import Map.IceField;
import Map.Map;
import Player.Eskimo;
import Player.Player;
import Player.Scientist;

public class Game {
	
	private int roundNum;
	private int roundsUntilBlizzard;
	private static int foundGunParts;
	private Map map;
	// statikuss� tettem �ket, mert csak �gy lehet hozz�juk f�rni a winGame-ben
	private static ArrayList<Player> players;
	private static GameState state;
	
	public void doRound() 
	{
		// Jelenleg a forgat�k�nyveknek megfelel� �rt�kek be�ll�t�sa szerepel itt, 
		//	k�s�bbiekben a j�t�k �ltal, kor�bban beadott dokumentumokban le�rt esem�nyek fognak szerepelni.
		System.out.println("->[Game].doRound()");
		Main.tabok+="\t";
		switch(Main.FORGATOKONYV_SZAMA) {
		case 1:
			Scientist s1 = new Scientist();
			s1.doTurn();
			break;
		case 2:
			Scientist s2 = new Scientist();
			s2.doTurn();
			break;
		case 3:
			Scientist s3 = new Scientist();
			s3.doTurn();
			break;
		case 4:
			Scientist s4 = new Scientist();
			s4.doTurn();
			break;
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
		case 8:
			Eskimo e8 = new Eskimo();
			e8.doTurn();
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
		case 13:
			Eskimo e13 = new Eskimo();
			e13.doTurn();
			break;
		case 14:
			Eskimo e14 = new Eskimo();
			e14.doTurn();
			break; 
		case 15:
			Eskimo e15 = new Eskimo();
			e15.doTurn();
			break;
		case 16:
			Eskimo e16 = new Eskimo();
			e16.doTurn();
			break;
		case 17:
			Eskimo e17 = new Eskimo();
			e17.doTurn();
			break;
			
		}
			
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println("<-[Game].doRound()");
			
	}
	
	//Dominik
	public void callBlizzard() 
	{
		map.callBlizzardOnFields();
	}
	
	public static void winGame(Field f) 
	{
		
		if(foundGunParts==3 && (f.getCharacters().size()>=players.size())) {
			state = GameState.WON;
			System.out.println("The players won the game.");
		}
			
	}
	
	public static void loseGame() 
	{
		state = GameState.LOST;
	}
	
	public static void incGunParts()
	{
		foundGunParts++;
		System.out.println("Found gunparts incremented, num: "+foundGunParts);		
	}
}
