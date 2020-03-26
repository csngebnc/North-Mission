import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Items.*;
import Map.*;
import Player.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Game game = new Game();
		
		String lista = "V�laszthat� forgat�k�nyvek:\n" +
						"1. valami";
		
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		while(!bemenet.equals("kilep")) {
			System.out.println(lista);
			bemenet = reader.readLine();
			
			switch(bemenet) {
			case "1":
				System.out.println("forgat�k�nyv: 1");
				break;
			
			}
	        
		}
//Zal�n p�rba push
	}

}
