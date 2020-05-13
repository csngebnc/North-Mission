package Items;

import java.util.ArrayList;

import Map.Field;

/**
 * Egy absztrakt oszt�ly, az eldobhat� t�rgyak �se. 
 * Mivel a j�t�k sor�n a t�rgyak �tad�s c�lj�b�l felv�tel ut�n ism�t eldobhat�ak, 
 * �gy ennek az oszt�lynak a bevezet�se sz�ks�ges.
 * @author Norbi 
 */
public abstract class Throwable implements Item 
{
	/**
	 * T�rgy eldob�sa egy mez�re. Eldobhat� t�rgy esete.
	 * @param f az a mez� akire dobjuk a t�rgyat.
	 */
	public boolean throwTo(Field f) 
	{
		f.acceptItem(this);
		return true;
	}
	
	/**
	 * Eldobhat�, nem alkatr�sz t�rgy felv�tele.
	 */
	public void pickUp() 
	{
		return;
	}
	
	/**
	 * Megadott sz�m� p�ld�nyt �ll�t el� az oszt�lyb�l.
	 * @author Csonge Bence
	 */
	public ArrayList<Item> generateInstances(int count) throws IllegalAccessException, InstantiationException {
        ArrayList<Item> array = new ArrayList<Item>();
        for (int i = 0; i < count; i++) {
            array.add(this.getClass().newInstance());
        }
        return array;
    }
}