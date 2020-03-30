package Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Core.Main;
import Items.Shovel;
import Items.Barrel;
import Items.Item;
import Items.Rope;
import Player.Player;

public class IceField extends Field 
{
	private boolean iglooOnField;
	private Item frozenItem;
	private Item itemOnGround;
	
	//Stabil jégmezõre lépés.
	public void acceptPlayer(Player p)
	{
		System.out.println(Main.tabok+"->[IceField].acceptPlayer(Player p)");
		Main.tabok+="\t";
		p.setField(this);
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[IceField].acceptPlayer(Player p)");
	}
	
	//Tárgy átvétele játékos eldobása által, mezõn található tárgyakhoz adása itt fog történni.
	public void acceptItem(Item i) 
	{
		System.out.println(Main.tabok+"->[IceField].acceptItem(Item i)");
		System.out.println(Main.tabok+"<-[IceField].acceptItem(Item i)");
	}
	
	// Tárgy felvétele
	public Item pickUpItem(Player p) 
	{
		System.out.println(Main.tabok+"->[IceField].pickUpItem()");
		Main.tabok+="\t";
		//Itt lesz egy felugró ablak lesz arróll hogy melyik tárgyat akarja a player felvenni.
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		//Input ellenõrzés
		System.out.print(Main.tabok+"Milyen tárgy legyen a mezõn? (1 - Eldobható½, 2 - Alkatrész, bármi más - Semmi)\n"+Main.tabok);
		try {
			bemenet = reader.readLine();
		} catch (IOException e) {
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
	
	// Tárgy kiszabadítása mezõbõl.
	public void removeItemFromIce(Player p) 
	{
		System.out.println(Main.tabok+"->[Field].removeItemFromIce(Player p) ");
		Main.tabok+="\t";

		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.print(Main.tabok+"Legyen targy a mezon? (1- igen ; 2- nem)");
		try {
			bemenet = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(bemenet.equals("1"))
				frozenItem = new Rope();
		
		if (snowLayers == 0 && frozenItem != null)
			p.drainStamina();
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Field].removeItemFromIce(Player p) ");
	}
}
