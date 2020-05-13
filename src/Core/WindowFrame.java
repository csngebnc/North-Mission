package Core;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Visual.View;

/**
 * Az alkalmazást megjelenitõ ablak
 * @author Balczer Dominik
 */
public class WindowFrame extends JFrame {

	/**
	 * SerialID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Fõpanel, ezen van rajta a menü és maga a játék
	 * @author Balczer Dominik
	 */
	private static JPanel contPanel;
	
	/**
	 * Az elrendezésért felelõs LayoutManager
	 * @author Balczer Dominik
	 */
	private static CardLayout cl;
	
	/**
	 * Fõmenü panelje
	 * @author Balczer Dominik
	 */
	private static Menu menuPanel;
	
	/**
	 * Játék panelje
	 * @author Balczer Dominik
	 */
	private static View gamePanel;
	
	/**
	 * Konstruktor, inicializálja az ablakot és megjeleniti a fõmenüt
	 * @author Balczer Dominik
	 */
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
		
		//View hozzáadása a Controllerhez
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
	
	/**
	 * Elinditja a játékot és a fõpanelen átvált az játék paneljére
	 * @author Balczer Dominik
	 */
	public static void switchToGame(ArrayList<String> eskimos, ArrayList<String> scientists) {
		cl.show(contPanel, "game");
		Game.getInstance().Reset(eskimos, scientists);
		gamePanel.requestFocus();
	}
	
	/**
	 * A fõpanelen átvált az menü paneljére
	 * @author Balczer Dominik
	 */
	public static void switchToMenu() {
		cl.show(contPanel, "menu");
		menuPanel.requestFocus();
	}
}