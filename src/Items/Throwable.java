package Items;

import Map.Field;

/**
 * 
 * @author Norbi
 * Egy absztrakt oszt�ly, az eldobhat� t�rgyak �se. 
 * Mivel a j�t�k sor�n a t�rgyak �tad�s c�lj�b�l felv�tel ut�n ism�t eldobhat�ak, 
 * �gy ennek az oszt�lynak a bevezet�se sz�ks�ges. 
 */
public abstract class Throwable implements Item 
{
	/**
	 * T�rgy eldob�sa egy mez�re. Eldobhat� t�rgy esete.
	 * 
	 * @param f az a mez� akire dobjuk a t�rgyat.
	 */
	public boolean throwTo(Field f) 
	{
		f.acceptItem(this);
		return true;
	}
	
	/**
	 * Eldobhat�, nem alkatr�sz t�rgy felv�tele.
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
