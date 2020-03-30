package Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Core.Game;
import Core.Main;
import Items.Barrel;
import Items.DivingSuit;
import Items.Food;
import Items.Item;
import Items.Rope;
import Items.Shovel;
import Map.Direction;
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
	
	// J�t�kos inventory-j�nak megjelen�t�se.
	protected void openInventory() 
	{
		// K�s�bb itt egy felugr� ablakban megjelennek a j�t�kosn�l l�v� t�rgyak, �s
		// ezekb�l v�laszthat majd. A kiv�lasztott t�rgyon fog use() h�v�dni.
		// Jelenleg csak forgat�k�nyveknek megfelel� esem�nyek t�rt�nnek.
		
		System.out.println(Main.tabok+"->[Player].openInventory()");
		Main.tabok+="\t";
		switch(Main.FORGATOKONYV_SZAMA) {
		case 10:
			IceField iF = new IceField();
			String bemenet = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.print(Main.tabok+"Milyen t�rgyat dobjunk el? (T - Eldobhat�t, P - Alkatr�szt)\n"+Main.tabok);
			boolean loop = true;
			while(loop) {
				try {
					bemenet = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(bemenet.equals("T")) {
					Item item = new Shovel();
					if(item.throwTo(iF))
						this.drainStamina();
					loop = false;
				} else if (bemenet.equals("P")) {
					Item item = new Barrel();
					if(item.throwTo(iF))
						this.drainStamina();
					loop = false;
				}
			}
			break;
			
		case 11:
			Barrel b = new Barrel();
			b.use(this);
			break;
		case 12:
			Item i1 = new Shovel();
			i1.use(this);
			break;
		case 13:
			Item f = new Food();
			f.use(this);
			break;
		case 14: 
			Item r = new Rope();
			r.use(this);
			break;
		case 15: 
			Item ds = new DivingSuit();
			ds.use(this);
			break;
			
		}
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Player].openInventory()");
	}
	
	// J�t�kos k�re
	public void doTurn() 
	{
		// Jelenleg csak forgat�k�nyvnek megfelel� esem�nyek t�rt�nnek,
		// de itt ker�l majd megfigyel�sre a felhaszn�l� (j�t�kos) �ltal
		// adott input, valamint itt lesz lekezelve.
		System.out.println(Main.tabok+"->[Player].doTurn()");
		Main.tabok+="\t";
		
		switch(Main.FORGATOKONYV_SZAMA) {
		case 1:
			break;
		case 2:
			IceField iF1 = new IceField();
			iF1.moveMeTo(this, Direction.UP);
			break;
		case 3:
			IceField iF2 = new IceField();
			iF2.moveMeTo(this, Direction.UP);
			break;
		case 4:
			IceField iF3 = new IceField();
			iF3.moveMeTo(this, Direction.UP);
			break;
		case 6:
		case 7:
			this.doSkill();
			break;
		case 8:
			Field f8 = new IceField();
			f8.removeItemFromIce(this);
			break;
		case 9:
			IceField f = new IceField();
			f.pickUpItem(this);
			break;
		case 10:
			this.openInventory();
			break;
		case 11:
			this.openInventory();
			break;
		case 12:
			this.openInventory();
			break;
		case 13:
			this.openInventory();
			break;
		case 14:
			this.openInventory();
			break;
		case 15:
			this.openInventory();
			break;
		case 16:
			Game.winGame(this.field);
			break;
		case 17:
			Field f17 = new IceField();
			f17.digSnow(1);
			String bemenet = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.print(Main.tabok+"Tudtunk asni? (1- igen ; 2- nem)");
			try {
				bemenet = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(bemenet.equals("1"))
				this.drainStamina();
			break;
		}
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Player].doTurn()");
	}
	
	//B�v�rruha haszn�lat
	public boolean changeSuit(DivingSuit dsuit) 
	{
		System.out.println(Main.tabok+"->[Player].changeSuit()");
		Main.tabok+="\t";
		
		Scanner myObj = new Scanner(System.in);
		System.out.print(Main.tabok+"Van rajta buvar ruha? (Y - igen, N - nem)\n"+Main.tabok);
		String bemenet = myObj.nextLine();
		
		Main.tabok = Main.tabok.replaceFirst("\t", "");
		System.out.println(Main.tabok+"<-[Player].changeSuit()");
		
		switch(bemenet) {
		case "Y":
			return false;
		case "N":
			return true;
		default:
			return false;
		}
	}
	
	// J�t�kos �let�nek v�ltoztat�sa fog itt t�rt�nni.
	public void alterHealth(int n) 
	{
		System.out.println(Main.tabok+"->[Player].alterHealth()");
		System.out.println(Main.tabok+"<-[Player].alterHealth()");
	}
	
	// J�t�kos stamin�j�nak cs�kkent�se fog itt t�rt�nni.
	public void drainStamina() 
	{
		System.out.println(Main.tabok+"->[Player].drainStamina()");
		System.out.println(Main.tabok+"<-[Player].drainStamina()");
	}
	
	// J�t�kos mez�j�nek be�ll�t�sa fog itt t�rt�nni.
	public void setField(Field f) 
	{
		System.out.println(Main.tabok+"->[Player].setField(Field f)");
		System.out.println(Main.tabok+"<-[Player].setField(Field f)");
		
	}
	
	// J�t�kos mez�j�nek lek�r�se
	public Field getField() 
	{
		System.out.println(Main.tabok+"->[Player].getField()");
		System.out.println(Main.tabok+"<-[Player].getField()");
		//K�s�bb a 'field' tagv�ltoz�t fogja visszaadni
		return new IceField();
	}
	
	// J�t�kos fuldokl�s�nak be�ll�t�s fog itt t�rt�nni.
	public void setIsDrowning(boolean b)
	{
		System.out.println(Main.tabok+"->[Player].setIsDrowning(boolean b)");
		System.out.println(Main.tabok+"<-[Player].setIsDrowning(boolean b)");
	}
	
	//J�t�kos nev�nek visszaad�sa.
	public String getName()
	{
		System.out.println(Main.tabok+"->[Player].getName()");
		System.out.println(Main.tabok+"<-[Player].getName()");
		return name;
	}
	
	// Visszaadja, hogy van-e a j�t�koson b�v�rruha.
	public boolean getdSuitOn()
	{
		System.out.println(Main.tabok+"->[Player].getDSuitOn()");
		System.out.println(Main.tabok+"<-[Player].getDSuitOn()");
		return dSuitOn;
	}
	
	
	public void setdSuitOn(boolean b)
	{
		System.out.println(Main.tabok+"->[Player].setdSuitOn(boolean b)");
		System.out.println(Main.tabok+"<-[Player].setdSuitOn(boolean b)");
		//K�s�bb itt ker�l be�ll�t�sra, hogy van-e a j�t�koson b�v�rruha.
	}
}
