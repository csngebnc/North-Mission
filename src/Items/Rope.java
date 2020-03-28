package Items;
import java.util.Scanner;

import Core.Main;
import Map.Direction;
import Player.Player;
import Map.Field;
public class Rope extends Throwable
{
	//Dani
	public void use(Player p) 
	{
		System.out.println(Main.tabok+"->[Rope].use()");
		Main.tabok+="\t";
		
		//Itt lehet kiválasztani, hogy melyik irányba szeretnénk menteni
		Scanner myObj = new Scanner(System.in);
		System.out.println(Main.tabok+"Melyik irány?");
		System.out.print(Main.tabok+"bal, jobb, fel, le\n"+Main.tabok);
		String input = myObj.nextLine();
		Direction dir=Direction.UP;
		
		//Itt késõbb a dir felveszi a kiválaszott irányt
		
		Field f2 = p.getField();
		//Ha vannak azon a Field-en, ahonnan menteni szeretnénk
		if(f2.savePerson(dir))
			p.drainStamina();
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Rope].use()");
	
	}
}
