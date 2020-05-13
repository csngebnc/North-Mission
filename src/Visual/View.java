package Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import Core.Game;
import Core.GameState;
import Map.Field;
import Player.Player;

/**
 * A játék megjelenitésért felelõs JPanel
 * @author Balczer Dominik
 */
public class View extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Játékos HUD-on levõ keretjének a képe ha éppen nem õ van soron
	 * @author Balczer Dominik
	 */
	private Image playerFrame;
	
	/**
	 * Játékos HUD-on levõ keretjének a képe ha éppen õ van soron
	 * @author Balczer Dominik
	 */
	private Image playerFrameSelected;
	
	/**
	 * HUD-on életerõ kijelzésére használt sziv képe (1-6 életerõ)
	 * @author Balczer Dominik
	 */
	private Image heart;
	
	/**
	 * HUD-on életerõ kijelzésére használt sziv képe (7+)
	 * @author Balczer Dominik
	 */
	private Image heartGold;
	
	/**
	 * Játék háttere
	 * @author Balczer Dominik
	 */
	private Image backgroundImage;
	
	/**
	 * HUD-on közelgõ hóvihart jelzõ kép
	 * @author Balczer Dominik
	 */
	private Image blizzardImage;
	
	/**
	 * Graphics elem amivel rajzolunk
	 * @author Balczer Dominik
	 */
	private Graphics graphics;
	
	/**
	 * Konstruktor
	 * @author Balczer Dominik
	 */
	public View() {
		playerFrame = new ImageIcon("./assets/HUD/player_frame.png").getImage();
		playerFrameSelected = new ImageIcon("./assets/HUD/player_frame_selected.png").getImage();
		heart = new ImageIcon("./assets/HUD/heart.png").getImage();
		heartGold = new ImageIcon("./assets/HUD/heart_gold.png").getImage();
		backgroundImage = new ImageIcon("./assets/fields/backg.png").getImage();
		blizzardImage = new ImageIcon("./assets/HUD/cloud.png").getImage();
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				Game.getInstance().InputCame(e);
			}
		});
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./assets/HUD/ARCADE_N.ttf")));
		} catch (Exception e) {e.printStackTrace();}
		
	}
	
	/**
	 * Panel érvénytelenitése
	 * @author Balczer Dominik
	 */
	@Override
	public void revalidate() {
		repaint();
	}
	
	/**
	 * Panel rajzolása
	 * @param g : Graphics elem
	 * @author Balczer Dominik
	 */
	@Override
	protected void paintComponent(Graphics g) {
		graphics = g;
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0, null);
		drawHUD(g, Game.players);
		for(Field f : Game.getInstance().getMap().getFields()) {
			f.draw(this);
		}
	}
	
	/**
	 * HUD kirajzolása
	 * @param g : Graphics elem
	 * @param players : Játékban részt vevõ játékosok
	 * @author Balczer Dominik
	 */
	public void drawHUD(Graphics g, ArrayList<Player> players) {
		
		//Kirajzolandó játékosok
		ArrayList<Player> toDraw = new ArrayList<Player>();
		
		//Font
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		Font font = new Font("Arcade Normal", Font.PLAIN, 8);
		g2d.setFont(font);		
		
		int x = 38;
		int y = 15;
		int frameOffset = 150;
		
		//Ha nem fér ki mindenki, akkor legelõl mindig a jelenlegi játékos van (több mint 8-an játszanak)
		if(players.size() > 8) {
			
			Player firstPlayer = players.get(0);
			
			//Megkeressük ki van éppen soron
			for(Player p : players)
				if(p.getStamina() > 0) {
					firstPlayer = p;
					break;
				}
			
			int current = players.indexOf(firstPlayer);
			
			//Kiválasztjuk a soron következõ játékost és az utána következõ 7-et
			for(int i = 0; i < 8; i++) {
				if(current == players.size())
					current = 0;

				toDraw.add(players.get(current++));
			}
		}
		
		//Ha kifér mindenki (8-an vagy kevesebben játszanak)
		else
			for(Player p : players) {
				toDraw.add(p);
			}
		
		//Playercardok kirajzolása
		for(Player p : toDraw) {
			
			//Frame
			if(p.getStamina() > 0)
				g.drawImage(playerFrameSelected, x, y, null);
			else
				g.drawImage(playerFrame, x, y, null);
			
			//Avatar
			g.drawImage(p.getAvatar(), x+10, y+10, null);
			
			//HP
			int hp = p.getHealth();
			int hpOffset = 14;
			int hpCount;
			int hpX = x + 42;
			int hpY = y + 30;
			for(hpCount = 0; hpCount < hp && hpCount < 5; hpCount++) {
				g.drawImage(heart, hpX, hpY, null);
				hpX += hpOffset;
			}
			if(hp == 6)
				g.drawImage(heart, hpX, hpY, null);
			else if(hp > 6)
				g.drawImage(heartGold, hpX, hpY, null);
			
			//Name
			String name = p.getName();
			if(name.length() > 10)
				name = name.substring(0, 7) + "...";
			g2d.drawString(name, x + 42, y + 23);
			
			x += frameOffset;
		}
		
		//Turn counter kirajzolása
		g2d.setFont(font.deriveFont(15f));
		g2d.drawString("Turn: ", 13, 670);
		g2d.setFont(font.deriveFont(30f));
		g2d.drawString(String.valueOf(Game.getRoundNum()+1), 93, 675);
		
		//Blizzard jelzõ kirajzolása
		if(Game.getInstance().getRoundsUntilBlizzard() > 0) {
			g2d.setFont(font.deriveFont(15f));
			g2d.drawString("IN", 58, 613);
			g2d.drawString(String.valueOf(Game.getInstance().getRoundsUntilBlizzard()), 58, 633);
			g2d.drawString("turns", 76, 633);
			g.drawImage(blizzardImage, 13, 600, null);
		}
		
		//Losing message
		if(Game.getInstance().getState() == GameState.LOST) {
			g2d.setFont(font.deriveFont(12f));
			g2d.drawString("GAME OVER! PRESS ANY BUTTON TO RETURN TO THE MENU.", 260, 670);
		}
		//Winning message
		if(Game.getInstance().getState() == GameState.WON) {
			g2d.setFont(font.deriveFont(12f));
			g2d.drawString("VICTORY! PRESS ANY BUTTON TO RETURN TO THE MENU.", 280, 670);
		}
		
		//foundGunPats
		g2d.setFont(font.deriveFont(15f));
		g2d.drawString("FOUND GUNPARTS:", 935, 670);
		if(Game.getFoundGunPart(0))
			g2d.drawImage(new ImageIcon("./assets/items_buildings/rocket.png").getImage(), 1150, 648, null);
		else
			g2d.drawImage(new ImageIcon("./assets/items_buildings/rocket_frozen.png").getImage(), 1150, 648, null);
		if(Game.getFoundGunPart(1))
			g2d.drawImage(new ImageIcon("./assets/items_buildings/barrel.png").getImage(), 1180, 648, null);
		else
			g2d.drawImage(new ImageIcon("./assets/items_buildings/barrel_frozen.png").getImage(), 1180, 648, null);
		if(Game.getFoundGunPart(2))
			g2d.drawImage(new ImageIcon("./assets/items_buildings/grip.png").getImage(), 1210, 648, null);
		else
			g2d.drawImage(new ImageIcon("./assets/items_buildings/grip_frozen.png").getImage(), 1210, 643, null);
	}
	
	/**
	 * Kép kirajzolása a panelra
	 * @param x : Pozició X koordinátája
	 * @param y : Pozició Y koordinátája
	 * @param img : kirajzolandó kép
	 * @author Balczer Dominik
	 */
	public void drawThing(int x, int y, Image img) {
		graphics.drawImage(img, x, y, null);
	}
	
	/**
	 * Szöveg kirajzolása a panelra
	 * @param x mezõ x koordinátája
	 * @param y mezõ y koordinátája
	 * @param limit mezõ maxplayers tulajdonsága
	 * @author Norbi
	 */
	public void drawThing(int x, int y, String limit) {
		Graphics2D g2d = (Graphics2D) graphics;
		Color color = new Color(16, 121, 181);
		g2d.setColor(color);
		Font playerFont = new Font("Arcade Normal", Font.PLAIN, 8);
		g2d.setFont(playerFont);
		g2d.drawString(limit, x, y);
	}
}