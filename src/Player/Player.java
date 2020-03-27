package Player;
import Items.DivingSuit;
import Items.Item;
import Map.Field;
import Map.IceField;
import Map.Map;

public abstract class Player 
{
	private String name;
	private int health;
	private int stamina;
	private boolean isDrowning;
	private boolean dSuitOn;
	private Map players;
	private Field field;
	private Item inventory;
	
	public abstract void doSkill();
	
	private void openInventory() 
	{
		
	}
	
	public void doTurn() 
	{
		
	}
	
	public void changeSuit(DivingSuit dsuit) 
	{
		
	}
	
	public void alterHealth(int n) 
	{
		
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
}
