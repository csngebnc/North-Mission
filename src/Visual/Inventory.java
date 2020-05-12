package Visual;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Core.Game;
import Items.Item;
import Player.Player;

public class Inventory extends JFrame {

	private Player player;
	private ArrayList<Item> items;
	private JComboBox box;
	private JFrame frame;
	private JScrollPane pane;
	
	public Inventory(Player p)
	{
		frame = this;
		player = p;
		items = player.getInventory();
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setTitle("Inventory");
		JPanel jp = new JPanel();
		jp.setLayout(null);
		jp.setBackground(new Color(5, 60, 200, 200));
		
		jp.setPreferredSize(new Dimension(350, 100));
		this.add(jp);

		box = new JComboBox();
		box.setBounds(90, 70, 120, 30);
		for(Item i : items) {
			box.addItem(i.getName());
		}
		
		jp.add(box);
		JButton b1 = new JButton("Drop");
		b1.setBounds(46, 200, 80, 30);
		b1.addActionListener(new DropButtonListener());
		jp.add(b1);
		
		JButton b2 = new JButton("Use");
		b2.setBounds(176, 200, 80, 30);
		b2.addActionListener(new UseButtonListener());
		jp.add(b2);
		this.setVisible(true);
		this.setResizable(false);
		/*
	//	pane.setBounds(90, 70, 120, 30);
		for(int i = 0; i < items.size() ; i++)
		{
			JLabel l = new JLabel(items.get(i).getClass().getName());
			jp.add(l);
		}
		pane = new JScrollPane(jp);
		pane.setVisible(true);
		this.add(pane, BorderLayout.CENTER);
		*/
	}
	
	private class DropButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int chosen = box.getSelectedIndex();
			if (chosen >= 0) {
				Item item = player.getItem(chosen);
				
				if (item.throwTo(player.getField())) {
					player.removeItem(item);
					player.drainStamina();
					box.removeItemAt(chosen);
					box.revalidate();
					if(player.getStamina() == 0) {
						frame.dispose();
					}
					Game.notifyView();
				}
			}
		}
	}
		
	private class UseButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int chosen = box.getSelectedIndex();
			if (chosen >= 0) {
				Item item = player.getItem(chosen);
				item.use(player);
				box.removeAllItems();
				items = player.getInventory();
				for(Item i : items) {
					box.addItem(i.getName());
				}
				
				box.revalidate();
			}
			Game.notifyView();
		}
		
	}
	/*
	private class ItemSelectedListener implements MouseListener{

		int sorszam;
		public ItemSelectedListener(int i)
		{
			sorszam=i;
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			if(!selected) 
			{
				labels[sorszam].setBackground(Color.lightGray);
				labels[sorszam].setOpaque(true);
				labels[sorszam].repaint();
				selected=true;
				selectedItem=items.get(sorszam);
				System.out.println("asd");
			}
			else if(items.indexOf(selectedItem)==sorszam)
			{
				labels[sorszam].setOpaque(false);
				labels[sorszam].repaint();
				selected=false;
				selectedItem=null;
			}
			

			
			System.out.println(selected);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class ItemSelectListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			selectedItem = (Item) arg0.getSource();
			System.out.println(selectedItem.getItemName());
		}
		
	}
	*/
}
