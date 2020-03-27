package Map;
import java.util.Scanner;

import Items.Shovel;
import Items.Barrel;
import Items.Item;
import Player.Player;

public class IceField extends Field 
{
	private boolean iglooOnField;
	private Item frozenItem;
	private Item itemOnGround;
	
	public void acceptPlayer(Player p)
	{
		System.out.println("IceField.acceptPlayer");
		p.setField(this);
	}
	
	//Dominik
	public void acceptItem(Item i) 
	{
		System.out.println("IceField.acceptItem(Item i)");
	}
	
	//Dominik
	public Item pickUpItem(Player p) 
	{
		System.out.println("IceField.pickUpItem");
		
		//Itt lesz egy felugró ablak arról hogy melyik tárgyat akarja a player felvenni
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Milyen tárgy legyen a mezõn? (T - Eldobható, P - Alkatrész, N - Semmi");
		
		//Input csekkolás
		while(true) {
			if(scanner.nextLine() == "T") {
				Item item = new Shovel();
				item.pickUp();
				p.drainStamina();
				scanner.close();
				return item;
			} else if (scanner.nextLine() == "P") {
				Item item = new Barrel();
				item.pickUp();
				p.drainStamina();
				scanner.close();
				return item;
			} else if (scanner.nextLine() == "N") {
				scanner.close();
				return null;
			}
		}
	}
	
	public boolean digSnow(int amount) 
	{
		return true;
	}
	
	public void removeItemFromIce(Player p) 
	{
		
	}
}
