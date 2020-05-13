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
import javax.swing.JPanel;

import Core.Game;
import Core.GameState;
import Map.Map;
import Map.Field;
import Player.Player;

public class View extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private Image playerFrame = new ImageIcon("./assets/HUD/player_frame.png").getImage();
	private Image playerFrameSelected = new ImageIcon("./assets/HUD/player_frame_selected.png").getImage();
	private Image heart = new ImageIcon("./assets/HUD/heart.png").getImage();
	private Image heartGold = new ImageIcon("./assets/HUD/heart_gold.png").getImage();
	private Image backgroundImage = new ImageIcon("./assets/fields/backg.png").getImage();
	private Image blizzardImage = new ImageIcon("./assets/HUD/cloud.png").getImage();
	
	private Graphics GG;
	
	public View() {
		/*this.setSize(1280,720);
		this.setPreferredSize(this.getSize());*/
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
	
	@Override
	public void revalidate() {
		//Graphics g = this.getBufferStrategy().getDrawGraphics();
		repaint();
		//this.getBufferStrategy().show();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		GG = g;
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0, null);
		drawHUD(g, Game.players);
		for(Field f : Game.getInstance().getMap().getFields()) {
			f.draw(this);
		}
	}
	
	public void drawHUD(Graphics g, ArrayList<Player> players) {
		
		ArrayList<Player> toDraw = new ArrayList<Player>();
		
		//Font
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		Font font = new Font("Arcade Normal", Font.PLAIN, 8);
		g2d.setFont(font);		
		
		int x = 38;
		int y = 15;
		int frameOffset = 150;
		
		if(players.size() > 8) {
			
			Player firstPlayer = players.get(0);
			
			for(Player p : players)
				if(p.getStamina() > 0) {
					firstPlayer = p;
					break;
				}
			
			int current = players.indexOf(firstPlayer);
			
			for(int i = 0; i < 8; i++) {
				if(current == players.size())
					current = 0;

				toDraw.add(players.get(current++));
			}
		}
		else
			for(Player p : players) {
				toDraw.add(p);
			}
		
		//Playercards
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
		
		//Turn counter
		g2d.setFont(font.deriveFont(15f));
		g2d.drawString("Turn: ", 10, 665);
		g2d.setFont(font.deriveFont(30f));
		g2d.drawString(String.valueOf(Game.getRoundNum()+1), 90, 670);
		
		//Blizzard
		if(Game.getInstance().getRoundsUntilBlizzard() > 0) {
			g2d.setFont(font.deriveFont(15f));
			g2d.drawString("IN", 58, 613);
			g2d.drawString(String.valueOf(Game.getInstance().getRoundsUntilBlizzard()), 58, 633);
			g2d.drawString("turns", 76, 633);
			g.drawImage(blizzardImage, 13, 600, null);
		}
		
		//Losing
		if(Game.getInstance().getState() == GameState.LOST) {
			g2d.setFont(font.deriveFont(12f));
			g2d.drawString("GAME OVER! PRESS ANY BUTTON TO RETURN TO THE MENU.", 200, 670);
		}
		//Winning
		if(Game.getInstance().getState() == GameState.WON) {
			g2d.setFont(font.deriveFont(12f));
			g2d.drawString("VICTORY! PRESS ANY BUTTON TO RETURN TO THE MENU.", 200, 670);
		}
	}
	
	public void drawThing(int x, int y, Image img) {
		GG.drawImage(img, x, y, null);
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
		Graphics2D g2d = (Graphics2D) GG;
		Color color = new Color(16, 121, 181);
		g2d.setColor(color);
		Font playerFont = new Font("Arcade Normal", Font.PLAIN, 8);
		g2d.setFont(playerFont);
		g2d.drawString(limit, x, y);
	}
}
