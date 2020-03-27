package Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

		//Input csekkolás
		while(true) {
			System.out.println("Milyen tárgy legyen a mezõn? (1 - Eldobható, 2 - Alkatrész, 3 - Semmi)" + bemenet + (bemenet == "1"));
			try {
				bemenet = reader.readLine();
				if(bemenet == "1") {
					Item item = new Shovel();
					item.pickUp();
					p.drainStamina();
					return item;
				} else if (bemenet == "2") {
					Item item = new Barrel();
					item.pickUp();
					p.drainStamina();
					return item;
				} else if (bemenet == "3") {
					return null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void removeItemFromIce(Player p) 
	{
		
	}
}
