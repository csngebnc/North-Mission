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
 * A j�t�k megjelenit�s�rt felel�s JPanel
 * @author Balczer Dominik
 */
public class View extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * J�t�kos HUD-on lev� keretj�nek a k�pe ha �ppen nem � van soron
	 * @author Balczer Dominik
	 */
	private Image playerFrame;
	
	/**
	 * J�t�kos HUD-on lev� keretj�nek a k�pe ha �ppen � van soron
	 * @author Balczer Dominik
	 */
	private Image playerFrameSelected;
	
	/**
	 * HUD-on �leter� kijelz�s�re haszn�lt sziv k�pe (1-6 �leter�)
	 * @author Balczer Dominik
	 */
	private Image heart;
	
	/**
	 * HUD-on �leter� kijelz�s�re haszn�lt sziv k�pe (7+)
	 * @author Balczer Dominik
	 */
	private Image heartGold;
	
	/**
	 * J�t�k h�ttere
	 * @author Balczer Dominik
	 */
	private Image backgroundImage;
	
	/**
	 * HUD-on k�zelg� h�vihart jelz� k�p
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
	 * Panel �rv�nytelenit�se
	 * @author Balczer Dominik
	 */
	@Override
	public void revalidate() {
		repaint();
	}
	
	/**
	 * Panel rajzol�sa
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
	 * HUD kirajzol�sa
	 * @param g : Graphics elem
	 * @param players : J�t�kban r�szt vev� j�t�kosok
	 * @author Balczer Dominik
	 */
	public void drawHUD(Graphics g, ArrayList<Player> players) {
		
		//Kirajzoland� j�t�kosok
		ArrayList<Player> toDraw = new ArrayList<Player>();
		
		//Font
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		Font font = new Font("Arcade Normal", Font.PLAIN, 8);
		g2d.setFont(font);		
		
		int x = 38;
		int y = 15;
		int frameOffset = 150;
		
		//Ha nem f�r ki mindenki, akkor legel�l mindig a jelenlegi j�t�kos van (t�bb mint 8-an j�tszanak)
		if(players.size() > 8) {
			
			Player firstPlayer = players.get(0);
			
			//Megkeress�k ki van �ppen soron
			for(Player p : players)
				if(p.getStamina() > 0) {
					firstPlayer = p;
					break;
				}
			
			int current = players.indexOf(firstPlayer);
			
			//Kiv�lasztjuk a soron k�vetkez� j�t�kost �s az ut�na k�vetkez� 7-et
			for(int i = 0; i < 8; i++) {
				if(current == players.size())
					current = 0;

				toDraw.add(players.get(current++));
			}
		}
		
		//Ha kif�r mindenki (8-an vagy kevesebben j�tszanak)
		else
			for(Player p : players) {
				toDraw.add(p);
			}
		
		//Playercardok kirajzol�sa
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
		
		//Turn counter kirajzol�sa
		g2d.setFont(font.deriveFont(15f));
		g2d.drawString("Turn: ", 13, 670);
		g2d.setFont(font.deriveFont(30f));
		g2d.drawString(String.valueOf(Game.getRoundNum()+1), 93, 675);
		
		//Blizzard jelz� kirajzol�sa
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
	 * K�p kirajzol�sa a panelra
	 * @param x : Pozici� X koordin�t�ja
	 * @param y : Pozici� Y koordin�t�ja
	 * @param img : kirajzoland� k�p
	 * @author Balczer Dominik
	 */
	public void drawThing(int x, int y, Image img) {
		graphics.drawImage(img, x, y, null);
	}
	
	/**
	 * Sz�veg kirajzol�sa a panelra
	 * @param x mez� x koordin�t�ja
	 * @param y mez� y koordin�t�ja
	 * @param limit mez� maxplayers tulajdons�ga
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