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
	
	//Norbi + valaki kiegészítette
	public void acceptPlayer(Player p)
	{
		System.out.println(Main.tabok+"->[IceField].acceptPlayer(Player p)");
		Main.tabok+="\t";
		p.setField(this);
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[IceField].acceptPlayer(Player p)");
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
		//Itt lesz egy felugr� ablak arr�l hogy melyik t�rgyat akarja a player felvenni
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		//Input csekkol�s
		System.out.print(Main.tabok+"Milyen t�rgy legyen a mez�n? (1 - Eldobhat�, 2 - Alkatr�sz, b�rmi m�s - Semmi)\n"+Main.tabok);
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
