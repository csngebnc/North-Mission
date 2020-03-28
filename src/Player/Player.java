package Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Core.Main;
import Items.Barrel;
import Items.DivingSuit;
import Items.Item;
import Items.Shovel;
import Map.Field;
import Map.IceField;
import Map.Map;

public abstract class Player 
{
	protected String name;
	protected int health;
	protected int stamina;
	protected boolean isDrowning;
	protected boolean dSuitOn;
	protected Map players;
	protected Field field;
	protected Item inventory;
	
	public abstract void doSkill();
	
	// Bence
	protected void openInventory() 
	{
		System.out.println(Main.tabok+"->[Player].openInventory()");
		Main.tabok+="\t";
		switch(Main.FORGATOKONYV_SZAMA) {
		case 10:
			IceField iF = new IceField();
			String bemenet = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.print(Main.tabok+"Milyen tárgyat dobjunk el? (T - Eldobhatót, P - Alkatrészt)\n"+Main.tabok);
			boolean loop = true;
			while(loop) {
				try {
					bemenet = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(bemenet.equals("T")) {
					Item item = new Shovel();
					if(item.throwTo(iF))
						this.drainStamina();
					loop = false;
				} else if (bemenet.equals("P")) {
					Item item = new Barrel();
					if(item.throwTo(iF))
						this.drainStamina();
					loop = false;
				}
			}
			break;
			
		case 12:
			Item i1 = new Shovel();
			i1.use(this);
			break;
			
		}
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Player].openInventory()");
	}
	
	// Bence
	public void doTurn() 
	{
		System.out.println(Main.tabok+"->[Player].doTurn()");
		Main.tabok+="\t";
		
		switch(Main.FORGATOKONYV_SZAMA) {
		case 6:
		case 7:
			this.doSkill();
			break;
		case 9:
			IceField f = new IceField();
			f.pickUpItem(this);
			break;
		case 10:
			this.openInventory();
			break;
		case 11:
			this.openInventory();
			break;
		case 12:
			this.openInventory();
			break;
		}
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Player].doTurn()");
	}
	
	//Dominik
	public boolean changeSuit(DivingSuit dsuit) 
	{
		System.out.println("Player.changeSuit()");
		
		//dSuitOn lekérdezés
		
		if(dSuitOn && dsuit == null) {
			//Búvárruha levétele és elhelyezése a leltárbban
			return true;
		} else if (!dSuitOn && dsuit != null) {
			//Búvárruha felvétele és leltárból eltávolitás
			return true;
		} else
			return false;	
	}
	
	//Dani
	public void alterHealth(int n) 
	{
		System.out.println(Main.tabok+"->[Player].alterHealth()");
		System.out.println(Main.tabok+"<-[Player].alterHealth()");
	}
	
	public void drainStamina() 
	{
		System.out.println(Main.tabok+"->[Player].drainStamina()");
		System.out.println(Main.tabok+"<-[Player].drainStamina()");
	}
	
	public void setField(Field f) 
	{
		System.out.println("Player.setField");
	}
	
	//Dominik
	public Field getField() 
	{
		System.out.println(Main.tabok+"->[Player].getField()");
		System.out.println(Main.tabok+"<-[Player].getField()");
		//Késõbb a 'field' tagváltozót fogja visszaadni
		return new IceField();
	}
	
	public void setIsDrowning(boolean b)
	{
		System.out.println("Player.setIsDrowning");
	}
	
	//Dani
	public String getName()
	{
		System.out.println("Player.getName()");
		return name;
	}
	
	public boolean getdSuitOn()
	{
		System.out.println("Player.getDSuitOn()");
		return dSuitOn;
	}
	
	
	public void setdSuitOn(boolean b)
	{
		System.out.println("Player.setdSuitOn");
		//Késõbb itt átállítja a dSuitOn-t b-re
	}
}
