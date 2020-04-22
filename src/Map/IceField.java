package Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import Core.Main;
import Items.Shovel;
import Map.Buildings.Building;
import Items.Barrel;
import Items.Item;
import Items.Rope;
import Player.Player;
import Player.Character;

public class IceField extends Field 
{
	private Item frozenItem;
	private ArrayList<Item> itemOnGround;
	
	//Stabil j�gmez�re l�p�s.
	public void acceptCharacter(Character c)
	{
		c.drainStamina();
		c.setField(this);
		characters.add(c);
		if(building!=null){
			if(building.attack()) {
				for(Character ch : characters) {
					if(!ch.equals(c))
						c.collideWith(ch);
				}
			}
		}else {
			for(Character ch : characters) {
				if(!ch.equals(c))
					c.collideWith(ch);
			}
		}
	}
	
	//T�rgy �tv�tele j�t�kos eldob�sa �ltal, mez�n tal�lhat� t�rgyakhoz ad�sa itt fog t�rt�nni.
	public void acceptItem(Item i) 
	{
		itemOnGround.add(i);
	}
	
	// T�rgy felv�tele, protohoz egyenl�re ennyi
	public Item pickUpItem(Player p) 
	{
		if(itemOnGround.isEmpty()) {
			return null;
		}
		p.drainStamina();
		Item i = itemOnGround.get(0);
		itemOnGround.remove(0);
		return i;
	}
	
	// T�rgy kiszabad�t�sa mez�b�l. protohoz egyenl�re ennyi
	public void removeItemFromIce(Player p) 
	{
		if(itemOnGround.isEmpty())
			return;
		
		itemOnGround.set(0, frozenItem);
		p.drainStamina();
		
		
	}
	
	public boolean digSnow(int amount) {
		if(snowLayers>0) {
			snowLayers-=amount;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean buildBuilding(Building b) {
		if(building == null) {
			building = b;
			return true;
		}
		return false;
	}
	
	@Override
	public void tickBuilding() {
		if(building != null) {
			if(building.tick()) {
				building = null;
			}
		}
	}
}
