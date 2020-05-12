package Core;
import java.io.IOException;

import Visual.Menu;

/**
 * Kezdetleges Main osztály, a forgatókönyvek megjelenítéséhez, valamint azok végrehajtásához van rá szükség.
 * A késõbbiekben átalakításra kerül, úgy, hogy a játék vezérlését végezze.
 */

public class Main {
	
	public static void main(String[] args) throws IOException {
		//Menu menu = new Menu();
		
		
		Game.getInstance();
	}
}
