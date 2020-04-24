package Items;

import Player.Player;

public class LimitedShovel extends Shovel{

	private int remainingUses;
	
	public void use(Player p) 
	{
		
	}
	
	public void Properties() 
	{
		System.out.println(this.getClass());
		System.out.println(remainingUses);
	}
	
}
