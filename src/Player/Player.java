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
			System.out.print(Main.tabok+"Milyen t�rgyat dobjunk el? (T - Eldobhat�t, P - Alkatr�szt)\n"+Main.tabok);
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
		
		//dSuitOn lek�rdez�s
		
		if(dSuitOn && dsuit == null) {
			//B�v�rruha lev�tele �s elhelyez�se a lelt�rbban
			return true;
		} else if (!dSuitOn && dsuit != null) {
			//B�v�rruha felv�tele �s lelt�rb�l elt�volit�s
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
		//K�s�bb a 'field' tagv�ltoz�t fogja visszaadni
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
		//K�s�bb itt �t�ll�tja a dSuitOn-t b-re
	}
}
