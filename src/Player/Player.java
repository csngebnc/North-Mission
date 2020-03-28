package Player;
import Core.Main;
import Items.DivingSuit;
import Items.Item;
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
		case 11:
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
		System.out.println("Player.alterHealth");
	}
	
	public void drainStamina() 
	{
		System.out.println("Player.drainStamina");
	}
	
	public void setField(Field f) 
	{
		System.out.println("Player.setField");
	}
	
	//Dominik
	public Field getField() 
	{
		System.out.println("Player.getField()");
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
