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
	
		//Itt lehet kiválasztani, hogy melyik irányba szeretnénk menteni
		Scanner myObj = new Scanner(System.in);
		System.out.println("Melyik irány?");
		System.out.println("bal, jobb, fel, le");
		String input = myObj.nextLine();
		Direction dir=Direction.UP;
		switch(input) {
			case "bal": 
				dir = Direction.LEFT;
			case "jobb":
				dir = Direction.RIGHT;
			case "fel":
				dir = Direction.UP;
			case "le":
				dir = Direction.DOWN;
		}
		
		Field f2 = p.getField();
		//Ha vannak azon a Field-en, ahonnan menteni szeretnénk
		if(f2.savePerson(dir))
			p.drainStamina();
		
	
	}
}
