package Visual;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
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

public abstract class DirectionDialog extends JDialog{
	
	protected Player player;
	protected Field centerField;
	protected int centerX = 640;
	protected int centerY = 360;
	protected int dialogSize = 340;
	protected Point diaLocation;
	protected DialogPanel dPanel = new DialogPanel();
	protected Image DialogBackground = new ImageIcon("./assets/HUD/DialogPanelBackG.png").getImage();
	
	public DirectionDialog(Player p) {		
		super();
		this.player = p;
		centerField = p.getField();
		this.add(dPanel);
		this.setSize(dialogSize, dialogSize);
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
	
	private void drawDialog(Graphics g) {
		
		g.drawImage(DialogBackground, 2, 110, null);
		
		ArrayList<Field> fields = new ArrayList<Field>();
		int[] fieldIndex = {5,0,4,6,1,3,2};
		String[] fieldKeyBinds = {"Q","E","A","S","D","Y","X"};
		
		for(int i = 0; i < 7; i++) {
			if(fieldIndex[i] == 6)
				fields.add(centerField);
			else
				fields.add(centerField.getNeighbour(Direction.FromInt(fieldIndex[i])));
		}
		
		int centerFieldX = dialogSize/2 - 47;
		int centerFieldY = dialogSize/2 - 15;
		
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
					
					//Player modell rajzolás
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
	
	protected abstract void doActivity(Field target);
	
	private class DialogPanel extends JPanel{
		
		public DialogPanel() {
			this.setBackground(new Color(0,0,0,0));
		}
		
		@Override
		public void paintComponent(Graphics g) {
			drawDialog(g);
		}
	}
	
}
