package Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Core.Main;
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
		System.out.println(Main.tabok+"->[IceField].acceptItem(Item i)");
		System.out.println(Main.tabok+"<-[IceField].acceptItem(Item i)");
	}
	
	//Dominik
	public Item pickUpItem(Player p) 
	{
		System.out.println(Main.tabok+"->[IceField].pickUpItem()");
		Main.tabok+="\t";
		//Itt lesz egy felugró ablak arról hogy melyik tárgyat akarja a player felvenni
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		//Input csekkolás
		System.out.print(Main.tabok+"Milyen tárgy legyen a mezõn? (1 - Eldobható, 2 - Alkatrész, bármi más - Semmi)\n"+Main.tabok);
		try {
			bemenet = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(bemenet.equals("1")) {
			Item item = new Shovel();
			item.pickUp();
			p.drainStamina();
			Main.tabok = Main.tabok.replaceFirst("\t", "");
			System.out.println(Main.tabok+"->[IceField].pickUpItem()");
			return item;
		} else if (bemenet.equals("2")) {
			Item item = new Barrel();
			item.pickUp();
			p.drainStamina();
			Main.tabok = Main.tabok.replaceFirst("\t", "");
			System.out.println(Main.tabok+"<-[IceField].pickUpItem()");
			return item;
		} else {
			Main.tabok = Main.tabok.replaceFirst("\t", "");
			System.out.println(Main.tabok+"<-[IceField].pickUpItem()");
			return null;
		}		
	}
	
	public void removeItemFromIce(Player p) 
	{
		
	}
}
