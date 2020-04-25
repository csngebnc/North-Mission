package Items;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import Core.Main;
import Player.Player;
import Map.Field;
public class Rope extends Throwable
{
	/*
	 *  Egy lyukba esett játékos kimentése.
	 *  
	 *  
	 *  @author Norbi
	 *  @param p a játékos aki használja az ásót.
	 */
	public void use(Player p) 
	{
		Field safeField = p.getField();
		int fields = safeField.getNeighbours().size()-1;
		
		System.out.println("From where?");
		
		int answer = -1;
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		try {
			bemenet = reader.readLine();
			answer = Integer.parseInt(bemenet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(answer >=0 && answer <= fields) 
			if(safeField.getNeighbour(answer-1).savePerson(safeField))
				p.drainStamina();
	}
}
