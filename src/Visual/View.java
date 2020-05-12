package Visual;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JFrame;

import Core.Game;
import Map.Map;
import Map.Field;
import Player.Player;

public class View extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private Graphics g;
	private Canvas cv;
	private Game game;
	private Image playerFrame = new ImageIcon("./assets/HUD/player_frame.png").getImage();
	private Image playerFrameSelected = new ImageIcon("./assets/HUD/player_frame_selected.png").getImage();
	private Image heart = new ImageIcon("./assets/HUD/heart.png").getImage();
	private Image heartGold = new ImageIcon("./assets/HUD/heart_gold.png").getImage();
	private Image backgroundImage = new ImageIcon("./assets/fields/backg.png").getImage();
	private Image blizzardImage = new ImageIcon("./assets/HUD/cloud.png").getImage();
	
	public View(Game game) {
		this.game = game;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(1280,720));
		this.setVisible(true);
		cv = new Canvas();
		cv.setSize(1280,720);
		cv.setPreferredSize(cv.getSize());
		this.add(cv);
		cv.createBufferStrategy(2);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				game.InputCame(e);
			}
		});
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./assets/HUD/ARCADE_N.ttf")));
		} catch (Exception e) {e.printStackTrace();}

	}
	
	public void revalidate(Map map, ArrayList<Player> players) {
		g = cv.getBufferStrategy().getDrawGraphics();
		g.drawImage(backgroundImage,0,0, null);
		drawHUD(g, players);
		for(Field f : map.getFields()) {
			f.draw(this);
		}
		cv.getBufferStrategy().show();
	}
	
	public void drawHUD(Graphics g, ArrayList<Player> players) {
		
		//Font
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		Font font = new Font("Arcade Normal", Font.PLAIN, 8);
		g2d.setFont(font);		
		
		int x = 38;
		int y = 15;
		int frameOffset = 150;
		
		//Playercards
		for(Player p : players) {
			
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
		
		//Turn counter
		g2d.setFont(font.deriveFont(15f));
		g2d.drawString("Turn: ", 10, 665);
		g2d.setFont(font.deriveFont(30f));
		g2d.drawString(String.valueOf(Game.getRoundNum()+1), 90, 670);
		
		//Blizzard
		if(game.getRoundsUntilBlizzard() > 0) {
			g2d.setFont(font.deriveFont(15f));
			g2d.drawString("IN", 58, 613);
			g2d.drawString(String.valueOf(game.getRoundsUntilBlizzard()), 58, 633);
			g2d.drawString("turns", 76, 633);
			g.drawImage(blizzardImage, 13, 600, null);
		}
	}
	
	public void drawThing(int x, int y, Image img) {
		g.drawImage(img, x, y, null);
	}
	
	/**
	 * Szöveg vastagítása majd kiírása egy jégtábla sarkára
	 * 
	 * @param x mezõ x koordinátája
	 * @param y mezõ y koordinátája
	 * @param limit mezõ maxplayers tulajdonsága
	 * @author Norbi
	 */
	public void drawThing(int x, int y, String limit) {
		Graphics2D g2d = (Graphics2D) g;
		Color color = new Color(16, 121, 181);
		g2d.setColor(color);
		Font playerFont = new Font("Arcade Normal", Font.PLAIN, 8);
		g2d.setFont(playerFont);
		g2d.drawString(limit, x, y);
	}
}
