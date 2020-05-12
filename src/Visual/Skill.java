package Visual;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Core.Game;
import Player.Direction;
import Player.Player;

public class Skill extends JFrame{
	
	Player p;
	JDialog dia;
	
	public Skill(Player pp) {
		dia = new JDialog(this, "doSkill", true);
		p = pp;
		
		this.setLocationRelativeTo(null);
		
		this.setSize(340,340);
		JLabel label = new JLabel();
		label.setBounds(0, 0, 340, 340);
		label.setIcon(new ImageIcon("./assets/characters/skill.png"));
		
		
		
		this.add(label);
		
	}
	
	public void showItselt() {
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
