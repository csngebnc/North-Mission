package Items;
import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;

/**
 * Segítségével egy lyukba esett játékos kimenthetõ. 
 * Ha a mentés sikeres, a játékos stamináját egy egységgel csökkenti
 * @author Norbi
 */
public class Rope extends Throwable
{
	/**
	 *  Egy lyukba esett játékos kimentése.
	 *  @param p a játékos aki használja a kötelet.
	 *  @author Norbi
	 */
	public void use(Player p) 
	{
		// CONSOLOS VÁLTOZAT, LE KELL CSERÉLNI VIZUÁLISRA
		/*
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
		*/
	}
	
	@Override
	public String getName() {
		return "Rope";
	}
	
	@Override
	public Image getImg(ImgType form) {
		if(form==ImgType.DROPPED) {
			return new ImageIcon("./assets/items_buildings/rope.png").getImage();
		}else if(form==ImgType.FROZEN) {
			return new ImageIcon("./assets/items_buildings/rope_frozen.png").getImage();
		}else{
			return null;
		}
	}
}
