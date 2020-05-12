package Visual;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Core.Game;
import Items.Item;
import Player.Player;

public class Inventory extends JDialog{

	private Player player;
	private ArrayList<Item> items;
	private JDialog dialog;
	private JScrollPane pane;
	private JList<String> list;
	DefaultListModel<String> listModel;
	
	public Inventory(Player p)
	{
		dialog = this;
		player = p;
		items = player.getInventory();
		this.setSize(300, 300);
		this.setTitle("Inventory");
		this.setModal(true);
		this.setResizable(false);

		listModel = new DefaultListModel<String>();
		for(Item item : items)
			listModel.addElement(item.getName());
		
		list = new JList<String>(listModel);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		pane = new JScrollPane(list) {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(300,200);
			}
		};
		pane.setPreferredSize(new Dimension(300, 200));
		pane.setSize(new Dimension(300, 200));
		
		JButton b1 = new JButton("Drop");
		b1.setBounds(46, 200, 80, 30);
		b1.addActionListener(new DropButtonListener());
		this.add(b1);

		
		JButton b2 = new JButton("Use");
		b2.setBounds(176, 200, 80, 30);
		b2.addActionListener(new UseButtonListener());
		this.add(b2);
		
		this.add(pane);
		pane.setVisible(true);
		this.setVisible(true);
		this.pack();
	}
	
	private class DropButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int chosen = list.getSelectedIndex();
			if (chosen >= 0) {
				Item item = player.getItem(chosen);
				
				if (item.throwTo(player.getField())) {
					player.removeItem(item);
					player.drainStamina();
					listModel.remove(chosen);
					pane.revalidate();
					if(player.getStamina() == 0) {
						dialog.dispose();
					}
					Game.notifyView();
				}
			}
		}
	}
		
	private class UseButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int chosen = list.getSelectedIndex();
			if (chosen >= 0) {
				Item item = player.getItem(chosen);
				dialog.dispose();
				item.use(player);
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
