package Core;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Visual.View;

/**
 * Az alkalmaz�st megjelenit� ablak
 * @author Balczer Dominik
 */
public class WindowFrame extends JFrame {

	/**
	 * SerialID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * F�panel, ezen van rajta a men� �s maga a j�t�k
	 * @author Balczer Dominik
	 */
	private static JPanel contPanel;
	
	/**
	 * Az elrendez�s�rt felel�s LayoutManager
	 * @author Balczer Dominik
	 */
	private static CardLayout cl;
	
	/**
	 * F�men� panelje
	 * @author Balczer Dominik
	 */
	private static Menu menuPanel;
	
	/**
	 * J�t�k panelje
	 * @author Balczer Dominik
	 */
	private static View gamePanel;
	
	/**
	 * Konstruktor, inicializ�lja az ablakot �s megjeleniti a f�men�t
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
		
		//View hozz�ad�sa a Controllerhez
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
	 * Elinditja a j�t�kot �s a f�panelen �tv�lt az j�t�k panelj�re
	 * @author Balczer Dominik
	 */
	public static void switchToGame(ArrayList<String> eskimos, ArrayList<String> scientists) {
		cl.show(contPanel, "game");
		Game.getInstance().Reset(eskimos, scientists);
		gamePanel.requestFocus();
	}
	
	/**
	 * A f�panelen �tv�lt az men� panelj�re
	 * @author Balczer Dominik
	 */
	public static void switchToMenu() {
		cl.show(contPanel, "menu");
		menuPanel.requestFocus();
	}
}