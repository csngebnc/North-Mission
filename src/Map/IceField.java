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
	
	//Stabil j�gmez�re l�p�s.
	public void acceptCharacter(Character c)
	{
		
	}
	
	//T�rgy �tv�tele j�t�kos eldob�sa �ltal, mez�n tal�lhat� t�rgyakhoz ad�sa itt fog t�rt�nni.
	public void acceptItem(Item i) 
	{
		
	}
	
	// T�rgy felv�tele
	public Item pickUpItem(Player p) 
	{
		return null;	
	}
	
	// T�rgy kiszabad�t�sa mez�b�l.
	public void removeItemFromIce(Player p) 
	{
		
	}
}
