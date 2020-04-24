package Items;

import Map.Field;

public abstract class Throwable implements Item 
{
	/*
	 * Tárgy eldobása egy mezõre. Eldobható tárgy esete.
	 * 
	 * @param f az a mezõ akire dobjuk a tárgyat.
	 */
	public boolean throwTo(Field f) 
	{
		return true;
	}
	
	/*
	 * Eldobható, nem alkatrész tárgy felvétele.
	 * 
	 * 
	 */
	public void pickUp() 
	{
		
	}
	
	public void Properties() 
	{
		System.out.println(this.getClass());
	}
}
