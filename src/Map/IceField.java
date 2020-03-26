package Map;
import Items.Item;
import Player.Player;

public class IceField extends Field 
{
	private boolean iglooOnField;
	private Item frozenItem;
	private Item itemOnGround;
	
	public void acceptPlayer(Player p)
	{
		System.out.println("IceField.acceptPlayer");
		p.setField(this);
	}
	
	public void acceptItem(Item i) 
	{
		
	}
	
	public Item pickUpItem(Player p) 
	{
		
	}
	
	public boolean digSnow(int amount) 
	{
		
	}
	
	public void removeItemFromIce(Player p) 
	{
		
	}
	
	public void acceptPlayer(Player p) 
	{
		
	}
}
