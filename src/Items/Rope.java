package Items;
import java.util.Scanner;

import Core.Main;
import Player.Player;
import Map.Field;
public class Rope extends Throwable
{
	// Egy lyukba esett j�t�kos kiment�se.
	public void use(Player p) 
	{
		System.out.println(Main.tabok+"->[Rope].use()");
		Main.tabok+="\t";
		
		//Itt lehet kiv�lasztani, hogy melyik ir�nyba szeretn�nk menteni
		Scanner myObj = new Scanner(System.in);
		System.out.println(Main.tabok+"Melyik irany?");
		System.out.print(Main.tabok+"bal, jobb, fel, le\n"+Main.tabok);
		String input = myObj.nextLine();
		
		//Itt k�s�bb a dir felveszi a kiv�laszott ir�nyt
		
		Field f2 = p.getField();
		//Ha vannak azon a Field-en, ahonnan menteni szeretn�nk
		if(f2.savePerson(1))
			p.drainStamina();
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Rope].use()");
	
	}
}
