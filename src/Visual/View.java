package Visual;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Core.Game;
import Map.Map;
import Map.Field;
import Player.Player;

public class View extends JFrame{
	
	private Graphics g;
	private Canvas cv;
	private Game game;
	private Image playerFrame = new ImageIcon("./assets/HUD/player_frame.png").getImage();
	private Image playerFrameSelected = new ImageIcon("./assets/HUD/player_frame_selected.png").getImage();
	private Image heart = new ImageIcon("./assets/HUD/heart.png").getImage();
	private Image heartGold = new ImageIcon("./assets/HUD/heart_gold.png").getImage();
	private Image backgroundImage = new ImageIcon("./assets/fields/backg.png").getImage();
	
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
	}
	
	public void revalidate(Map map, ArrayList<Player> players) {
		g = cv.getBufferStrategy().getDrawGraphics();
		drawHUD(g, players);
		g.drawImage(backgroundImage,0,0, null);
		for(Field f : map.getFields()) {
			f.draw(this);
		}
		cv.getBufferStrategy().show();
	}
	
	public void drawHUD(Graphics g, ArrayList<Player> players) {
		int x = 10;
		int y = 10;
		int frameOffset = 150;
		for(Player p : players) {
			if(p.getStamina() > 0)
				g.drawImage(playerFrameSelected, x, y, null);
			else
				g.drawImage(playerFrame, x, y, null);
			
			x += frameOffset;
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
		g.setFont(new Font("default", Font.BOLD, 11));
		g.drawString(limit, x, y);
	}

}
