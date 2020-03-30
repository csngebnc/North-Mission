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
	
	// Játékos inventory-jának megjelenítése.
	protected void openInventory() 
	{
		// Késõbb itt egy felugró ablakban megjelennek a játékosnál lévõ tárgyak, és
		// ezekbõl választhat majd. A kiválasztott tárgyon fog use() hívódni.
		// Jelenleg csak forgatókönyveknek megfelelõ események történnek.
		
		System.out.println(Main.tabok+"->[Player].openInventory()");
		Main.tabok+="\t";
		switch(Main.FORGATOKONYV_SZAMA) {
		case 10:
			IceField iF = new IceField();
			String bemenet = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.print(Main.tabok+"Milyen tï¿½rgyat dobjunk el? (T - Eldobhatï¿½t, P - Alkatrï¿½szt)\n"+Main.tabok);
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
	
	// Játékos köre
	public void doTurn() 
	{
		// Jelenleg csak forgatókönyvnek megfelelõ események történnek,
		// de itt kerül majd megfigyelésre a felhasználó (játékos) által
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
	
	//Búvárruha használat
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
	
	// Játékos életének változtatása fog itt történni.
	public void alterHealth(int n) 
	{
		System.out.println(Main.tabok+"->[Player].alterHealth()");
		System.out.println(Main.tabok+"<-[Player].alterHealth()");
	}
	
	// Játékos staminájának csökkentése fog itt történni.
	public void drainStamina() 
	{
		System.out.println(Main.tabok+"->[Player].drainStamina()");
		System.out.println(Main.tabok+"<-[Player].drainStamina()");
	}
	
	// Játékos mezõjének beállítása fog itt történni.
	public void setField(Field f) 
	{
		System.out.println(Main.tabok+"->[Player].setField(Field f)");
		System.out.println(Main.tabok+"<-[Player].setField(Field f)");
		
	}
	
	// Játékos mezõjének lekérése
	public Field getField() 
	{
		System.out.println(Main.tabok+"->[Player].getField()");
		System.out.println(Main.tabok+"<-[Player].getField()");
		//Késõbb a 'field' tagváltozót fogja visszaadni
		return new IceField();
	}
	
	// Játékos fuldoklásának beállítás fog itt történni.
	public void setIsDrowning(boolean b)
	{
		System.out.println(Main.tabok+"->[Player].setIsDrowning(boolean b)");
		System.out.println(Main.tabok+"<-[Player].setIsDrowning(boolean b)");
	}
	
	//Játékos nevének visszaadása.
	public String getName()
	{
		System.out.println(Main.tabok+"->[Player].getName()");
		System.out.println(Main.tabok+"<-[Player].getName()");
		return name;
	}
	
	// Visszaadja, hogy van-e a játékoson búvárruha.
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
		//Késõbb itt kerül beállításra, hogy van-e a játékoson búvárruha.
	}
}
