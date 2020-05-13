package Visual;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import Core.Game;
import Map.Field;
import Player.Character;
import Player.Direction;
import Player.Player;

/**
 * Ir�ny kiv�laszt�s�ra alkalmas dial�gusablak
 * @author Balczer Dominik
 */
public abstract class DirectionDialog extends JDialog{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * A j�t�kos aki megnyitotta a dial�gusablakot
	 * @author Balczer Dominik
	 */
	protected Player player;
	
	/**
	 * A j�t�kos mez�je
	 * @author Balczer Dominik
	 */
	protected Field centerField;
	
	/**
	 * A dial�gusablak h�ttere
	 * @author Balczer Dominik
	 */
	protected Image DialogBackground;
	
	/**
	 * Konstruktor, inicializ�lja �s megnyitja a dial�gusablakot
	 * @author Balczer Dominik
	 */
	public DirectionDialog(Player p) {		
		super();
		JPanel dPanel = new JPanel() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				drawDialog(g);
			}
		};
		
		dPanel.setBackground(new Color(0,0,0,0));
		DialogBackground = new ImageIcon("./assets/HUD/DialogPanelBackG.png").getImage();
		
		this.player = p;
		centerField = p.getField();
		
		this.add(dPanel);
		this.setSize(340, 340);
		this.setPreferredSize(this.getSize());
		this.setLocation(Game.getView().getLocation());
		this.setUndecorated(true);
		this.getRootPane().setOpaque(false);
		this.getContentPane().setBackground(new Color(0,0,0,0));
		this.setBackground(new Color(0,0,0,0));
		this.setModalityType(Dialog.ModalityType.MODELESS);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setLocationRelativeTo(Game.getView());
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				notifyField(e.getKeyCode());
			}
		});
	}
	
	/**
	 * Dial�gus ablak kirajzol�s��rt felel�s f�ggv�ny
	 * @param g : Graphics
	 * @author Balczer Dominik
	 */
	private void drawDialog(Graphics g) {
		
		g.drawImage(DialogBackground, 2, 110, null);
		
		ArrayList<Field> fields = new ArrayList<Field>();
		int[] fieldIndex = {5,0,4,6,1,3,2};
		String[] fieldKeyBinds = {"W","E","A","S","D","Y","X"};
		
		for(int i = 0; i < 7; i++) {
			if(fieldIndex[i] == 6)
				fields.add(centerField);
			else
				fields.add(centerField.getNeighbour(Direction.FromInt(fieldIndex[i])));
		}
		
		int centerFieldX = 340/2 - 47;
		int centerFieldY = 340/2 - 15;
		
		int[] xOffset = {47, 95, 47, -47, -95, -47, 0};
		int[] yOffset = {-30, 0, 30, 30, 0, -30, 0};
		
		Graphics2D g2d = (Graphics2D)g;
		
		for(int i = 0; i < 7; i++) {
			
			Field currentField = fields.get(i);
			
			if(currentField != null) {
				
				int currentFieldX = centerFieldX + xOffset[fieldIndex[i]];
				int currentFieldY = centerFieldY + yOffset[fieldIndex[i]];
				
				g2d.drawImage(currentField.getSprite(), currentFieldX, currentFieldY, null);
				
				for(Character c : currentField.getCharacters()) {
					
					int charPos = (52/currentField.getCharacters().size()) * 
							(int)Math.pow(-1, currentField.getCharacters().indexOf(c)) *
							(int)(Math.ceil(((double)currentField.getCharacters().indexOf(c))/2));
					
					//Player modell rajzol�s
					if(!currentField.hasBuilding()) {
						if(c.getDrowning()) 
							g2d.drawImage(c.getAvatar(), currentFieldX + 40 + charPos, currentFieldY + 8, null);
						else 
							g2d.drawImage(c.getAvatar(), currentFieldX + 36 + charPos, currentFieldY, null);
					}
				}
				
				//Key Binds
				Color color = new Color(16, 121, 181);
				g2d.setColor(color);
				Font playerFont = new Font("Arcade Normal", Font.PLAIN, 8);
				g2d.setFont(playerFont);
				g.drawString(fieldKeyBinds[i], currentFieldX + 85, currentFieldY + 20);
			}
		}		
	}
	
	/**
	 * Billenyt� k�d alapj�n meghat�rozza a c�lmez�t �s tov�bbitja a doActivity()-nek
	 * @param charCode : Kiv�lasztott mez� billenty� k�dja
	 * @author Balczer Dominik
	 */
	private void notifyField(int charCode) {
		
		Field target = null;
		
		switch(charCode) {
		case KeyEvent.VK_Q:
			target = centerField.getNeighbour(Direction.UPPER_LEFT);
			break;
		case KeyEvent.VK_E:
			target = centerField.getNeighbour(Direction.UPPER_RIGHT);
			break;
		case KeyEvent.VK_A:
			target = centerField.getNeighbour(Direction.LEFT);
			break;
		case KeyEvent.VK_D:
			target = centerField.getNeighbour(Direction.RIGHT);
			break;
		case KeyEvent.VK_Y:
			target = centerField.getNeighbour(Direction.BOTTOM_LEFT);
			break;
		case KeyEvent.VK_X:
			target = centerField.getNeighbour(Direction.BOTTOM_RIGHT);
			break;
		case KeyEvent.VK_S:
			target = centerField;
			break;			
		case KeyEvent.VK_ESCAPE:
			break;
		}
		
		if(target != null)
			doActivity(target);
		
		Game.notifyView();
		dispose();
		return;
	}
	
	/**
	 * V�grehajtja a dial�gusablak tipusa szerint a cselekv�st a kiv�lasztott mez�n
	 * @param target : A kiv�lasztott mez�
	 * @author Balczer Dominik
	 */
	protected abstract void doActivity(Field target);
}