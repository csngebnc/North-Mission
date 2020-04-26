package Items;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import Core.Main;
import Player.Player;
import Map.Field;

/**
 * Seg�ts�g�vel egy lyukba esett j�t�kos kimenthet�. 
 * Ha a ment�s sikeres, a j�t�kos stamin�j�t egy egys�ggel cs�kkenti
 * @author Norbi
 */
public class Rope extends Throwable
{
	/**
	 *  Egy lyukba esett j�t�kos kiment�se.
	 *  @param p a j�t�kos aki haszn�lja az �s�t.
	 *  @author Norbi
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
