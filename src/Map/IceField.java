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
	private Item frozenItem;
	private Item itemOnGround;
	
	//Stabil jégmezõre lépés.
	public void acceptCharacter(Character c)
	{
		
	}
	
	//Tárgy átvétele játékos eldobása által, mezõn található tárgyakhoz adása itt fog történni.
	public void acceptItem(Item i) 
	{
		
	}
	
	// Tárgy felvétele
	public Item pickUpItem(Player p) 
	{
		return null;	
	}
	
	// Tárgy kiszabadítása mezõbõl.
	public void removeItemFromIce(Player p) 
	{
		
	}
}
