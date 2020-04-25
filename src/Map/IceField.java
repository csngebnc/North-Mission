package Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import Core.Game;
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
	protected Item frozenItem;
	protected ArrayList<Item> itemOnGround;
	
	public IceField() {
		super();
		frozenItem = null;
		itemOnGround = new ArrayList<Item>();
	}
	
	//Stabil jégmezõre lépés.
	public void acceptCharacter(Character c)
	{
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
	
	//Tárgy átvétele játékos eldobása által, mezõn található tárgyakhoz adása itt fog történni.
	public void acceptItem(Item i) 
	{
		itemOnGround.add(i);
	}
	
	// Tárgy felvétele, protohoz egyenlõre ennyi
	public Item pickUpItem(Player p) 
	{
		if(itemOnGround.isEmpty()) {
			return null;
		}
		p.drainStamina();
		Item i = itemOnGround.get(0);
		i.pickUp();
		itemOnGround.remove(0);
		return i;
	}
	
	// Tárgy kiszabadítása mezõbõl. protohoz egyenlõre ennyi
	public void removeItemFromIce(Player p) 
	{
		if(snowLayers > 0 || frozenItem == null)
			return;
		
		itemOnGround.add(frozenItem);
		frozenItem = null;
		p.drainStamina();
	}
	
	public boolean digSnow(int amount) {
		if(snowLayers>0) {
			snowLayers-=amount;
			if(snowLayers < 0)
				snowLayers = 0;
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
	
	@Override
	public void setFrozenItem(Item i) {
		frozenItem = i;
	}
	
	@Override
	public void Properties()
	{
		System.out.println("---------------------------");
		System.out.println(this.getClass());
		System.out.println("Limit: " + maxplayers);
		System.out.println("Snow layers: " + snowLayers);
		
		if(building != null)
			System.out.println("Building: " + building.getClass());
		else
			System.out.println("Building: -");
		
		if(!characters.isEmpty())
			for(Character c:characters)
			{
				System.out.println("Character on field: " + c.getName());
			}
		
		if(frozenItem != null)
			System.out.println("Frozen item: " + frozenItem.getClass());
		else
			System.out.println("Frozen item: -");	
		for(Item i: itemOnGround)
		{
			System.out.println("Item on ground: " + i.getClass());
		}
	}
}
