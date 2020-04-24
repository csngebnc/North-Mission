package Items;

import Map.Field;

public abstract class Throwable implements Item 
{
	// T�rgy eldob�sa egy mez�re. Eldobhat� t�rgy esete.
	public boolean throwTo(Field f) 
	{
		return true;
	}
	
	// Eldobhat�, nem alkatr�sz t�rgy felv�tele.
	public void pickUp() 
	{
		
	}
	
	public void Properties() 
	{
		System.out.println(this.getClass());
	}
}
