package Items;

import Map.Field;

public abstract class Throwable extends Item 
{
	public boolean throwTo(Field f) 
	{
		return true;
	}
	
	//Dominik
	public void pickUp() 
	{
		System.out.println("Throwable.pickUp()");
	}
}
