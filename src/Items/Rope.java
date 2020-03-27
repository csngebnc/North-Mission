package Items;
import java.util.Scanner;
import Map.Direction;
import Player.Player;
import Map.Field;
public class Rope extends Throwable
{
	//Dani
	public void use(Player p) 
	{
		System.out.println("Rope.use");
	
		Scanner myObj = new Scanner(System.in);
		System.out.println("Melyik irány?");
		System.out.println("1: bal, 2: jobb, 3: fel, 4: le");
		String input = myObj.nextLine();
		Direction dir = Direction.UP;
		Field f2 = p.getField();
		if(f2.savePerson(dir))
			p.drainStamina();
		
	
	}
}
