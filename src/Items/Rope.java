package Items;
import java.awt.Image;
import javax.swing.ImageIcon;
import Player.Player;
import Visual.ImgType;

/**
 * Seg�ts�g�vel egy lyukba esett j�t�kos kimenthet�. 
 * Ha a ment�s sikeres, a j�t�kos stamin�j�t egy egys�ggel cs�kkenti
 * @author Norbi
 */
public class Rope extends Throwable
{
	/**
	 *  Egy lyukba esett j�t�kos kiment�se.
	 *  @param p a j�t�kos aki haszn�lja a k�telet.
	 *  @author Norbi
	 */
	public void use(Player p) 
	{
		// CONSOLOS V�LTOZAT, LE KELL CSER�LNI VIZU�LISRA
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
