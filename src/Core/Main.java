package Core;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Items.*;
import Map.*;
import Map.Buildings.Igloo;
import Player.*;
import Player.Character;

/**
 * Kezdetleges Main osztály, a forgatókönyvek megjelenítéséhez, valamint azok végrehajtásához van rá szükség.
 * A késõbbiekben átalakításra kerül, úgy, hogy a játék vezérlését végezze.
 */

public class Main {
	
	public static void main(String[] args) throws IOException {
		Game game = new Game();	
	}
}
