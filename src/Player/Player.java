package Player;
import Items.DivingSuit;
import Items.Item;
import Map.Field;
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
		
	}
}
