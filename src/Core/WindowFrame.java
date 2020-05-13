package Core;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Visual.View;

public class WindowFrame extends JFrame {

	private static JPanel contPanel;
	private static CardLayout cl;
	private static Menu menuPanel;
	private static View gamePanel;
	
	public WindowFrame() {
		
		cl = new CardLayout();
		contPanel = new JPanel();
		menuPanel = new Menu();
		gamePanel = new View();
		
		contPanel.setLayout(cl);
		contPanel.add(menuPanel, "menu");
		contPanel.add(gamePanel, "game");
		cl.show(contPanel, "menu");
		this.add(contPanel);
		
		this.setVisible(true);
		
		//gamePanel.createBufferStrategy(2);
		Game.attachView(gamePanel);
		
		this.setTitle("North Mission");
		this.setIconImage(new ImageIcon("./assets/icon.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1280,720);
		this.setPreferredSize(this.getSize());
		this.setResizable(false);
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void switchToGame(ArrayList<String> eskimos, ArrayList<String> scientists) {
		cl.show(contPanel, "game");
		Game.getInstance().Reset(eskimos, scientists);
		gamePanel.requestFocus();
	}
	
	public static void switchToMenu() {
		cl.show(contPanel, "menu");
		menuPanel.requestFocus();
	}
}
