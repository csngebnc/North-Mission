package Visual;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Map.Field;
import Player.Direction;
import Player.Player;

public class DirectionDialog extends JFrame{
	
	Player p;
	JDialog dia;
	Field centerField;
	int cetnerX = 640;
	int centerY = 360;
	int dialogSize = 340;
	
	public DirectionDialog(Player p) {
		dia = new JDialog(this, "doSkill", true);
		
		this.p = p;
		centerField = p.getField();
		
		//this.setLocationRelativeTo(null);
		
		this.setSize(dialogSize, dialogSize);
		JLabel label = new JLabel();

		this.add(label);
	}
	
	public void show() {
		dia.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				notifyField(e.getKeyCode());
			}

		});
		dia.setUndecorated(true);
		//dia.setLocationRelativeTo(null);
		dia.getContentPane().add(this.getContentPane());
		dia.pack();
		dia.setVisible(true);
	}
	
	
	
	private void notifyField(int charCode) {
		switch(charCode) {
		case KeyEvent.VK_Q:
			if(p.getField().getNeighbour(Direction.UPPER_LEFT)!=null) {
				p.getField().getNeighbour(Direction.UPPER_LEFT).revealLimit(p);
				p.drainStamina();
			}
			dia.dispose();
			return;
		case KeyEvent.VK_E:
			if(p.getField().getNeighbour(Direction.UPPER_RIGHT)!=null) {
				p.getField().getNeighbour(Direction.UPPER_RIGHT).revealLimit(p);
				p.drainStamina();
			}
			dia.dispose();
			return;
		case KeyEvent.VK_A:
			if(p.getField().getNeighbour(Direction.LEFT)!=null) {
				p.getField().getNeighbour(Direction.LEFT).revealLimit(p);
				p.drainStamina();
			}
			dia.dispose();
			return;
		case KeyEvent.VK_D:
			if(p.getField().getNeighbour(Direction.RIGHT)!=null) {
				p.getField().getNeighbour(Direction.RIGHT).revealLimit(p);
				p.drainStamina();
			}
			dia.dispose();
			return;
		case KeyEvent.VK_Y:
			if(p.getField().getNeighbour(Direction.BOTTOM_LEFT)!=null) {
				p.getField().getNeighbour(Direction.BOTTOM_LEFT).revealLimit(p);
				p.drainStamina();
			}
			dia.dispose();
			return;
		case KeyEvent.VK_X:
			if(p.getField().getNeighbour(Direction.BOTTOM_RIGHT)!=null) {
				p.getField().getNeighbour(Direction.BOTTOM_RIGHT).revealLimit(p);
				p.drainStamina();
			}
			dia.dispose();
			return;
		case KeyEvent.VK_S:
			if(p.getField()!=null) {
				p.getField().revealLimit(p);
				p.drainStamina();
			}
			dia.dispose();
			return;
			
		case KeyEvent.VK_ESCAPE:
			dia.dispose();
			return;
		}
	}
	
}
