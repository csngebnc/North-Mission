import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		Game game = new Game();
		
		String lista = "Választható forgatókönyvek:\n" +
						"1. Valami";
		
		String bemenet = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		while(!bemenet.equals("kilep")) {
			System.out.println(lista);
			bemenet = reader.readLine();
			
			switch(bemenet) {
			case "1":
				System.out.println("forgatókönyv 1");
				break;
			
			}
	        
		}
//Zalán pórba push
	}

}
