package Visual;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Core.Game;

public class Menu extends JFrame{

	JLabel label;
	JLabel nev, nev2, kaszt1, kaszt2;
	JButton bStart, bCredits, bExit;
	JTextField[] nevek;
	JComboBox[] kaszt;
	
	public Menu()
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./assets/HUD/ARCADE_N.ttf")));
		} catch (Exception e) {e.printStackTrace();}
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(1200,740));

		//Icon imgIcon = new ImageIcon("C:\\Users\\barab\\eclipse-workspace\\Menu\\src\\menu_bg2.gif");
		Icon imgIcon = new ImageIcon("D:\\Eclipse\\Menu\\src\\menu_bg2.gif");
		label = new JLabel(imgIcon);
		this.add(label);
		this.setResizable(false);
		
		//Start gomb
		bStart = new JButton("START");
		bStart.setBounds(100, 140, 250, 70);
		bStart.setForeground(Color.white);
		bStart.setFont(new Font("Cochin", Font.PLAIN, 50));
		bStart.setOpaque(false);
		bStart.setContentAreaFilled(false);
		bStart.setBorderPainted(false);
		bStart.addMouseListener(new MouseHover());
		bStart.addActionListener(new StartPressedListener());
		bStart.setFocusable(false);
		label.add(bStart);
		
		
		//Credits gomb
		bCredits = new JButton("CREDITS");
		bCredits.setBounds(450, 140, 300, 70);
		bCredits.setForeground(Color.white);
		bCredits.setFont(new Font("Cochin", Font.PLAIN, 50));
		bCredits.setOpaque(false);
		bCredits.setContentAreaFilled(false);
		bCredits.setBorderPainted(false);
		bCredits.addMouseListener(new MouseHover());
		bCredits.addActionListener(new CreditsPressedListener());
		bCredits.setFocusable(false);
		label.add(bCredits);
		
		//Exit gomb
		bExit = new JButton("EXIT");
		bExit.setBounds(850, 140, 250, 70);
		bExit.setForeground(Color.white);
		bExit.setFont(new Font("Cochin", Font.PLAIN, 50));
		bExit.setOpaque(false);
		bExit.setContentAreaFilled(false);
		bExit.setBorderPainted(false);
		bExit.addMouseListener(new MouseHover());
		bExit.setFocusable(false);
		bExit.addActionListener(new ExitPressedListener());
		label.add(bExit);
		
		this.setVisible(true);
	}
	
	public void InitMenu() {

		label.add(bStart);
		label.add(bCredits);
		label.add(bExit);
	}
	
	private class HowManyPlayerListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent event) {
		       if (event.getStateChange() == ItemEvent.SELECTED) {
		    	   
		    	   //Ha v�letlen�l t�bbet �rtunk els�re, mint akartunk
		    	   if(nevek!=null)
		    	   { 
			    	   for(int i=0;i<nevek.length;i++)
			    	   {
			    		   label.remove(nevek[i]);
			    		   label.remove(kaszt[i]);
			    	   }
		    	   }
		    	   
		    	   int hanyan = (int) event.getItem();
		    	   if(hanyan < 9) {
		    		   nev2.setVisible(false);
		    		   kaszt2.setVisible(false);
		    	   }
		    	   else {
		    		   nev2.setVisible(true);
		    		   kaszt2.setVisible(true);
		    	   }
		    	   nevek = new JTextField[hanyan];
		    	   kaszt = new JComboBox[hanyan];
		    	   for(int i=0; i<hanyan; i++)
		    	   {
		    		   kaszt[i]=new JComboBox();
		    		   kaszt[i].addItem("Sarkkutat�");
		    		   kaszt[i].addItem("Eszkim�");
		    		   if(i>9)
		    		   {
		    			   kaszt[i].setBounds(950,150+i*50-500,80,30);
		    		   }
		    		   else
		    		   {
		    			   kaszt[i].setBounds(450,150+i*50,80,30);	   
		    		   }
		    		   label.add(kaszt[i]);
		    	   }
		    	  
		    	   JLabel nev = new JLabel("N�v");
		    	   nev.setBounds(300,100,40,40);
		    	   nev.setForeground(Color.white);
		    	   nev.setFont(new Font("Cochin", Font.PLAIN, 20));
		    	   label.add(nev);
		    	   for(int i=0; i<hanyan;i++)
		    	   {
		    		   nevek[i]=new JTextField();
		    		   if(i>9)
		    		   {
		    			   nevek[i].setBounds(800,150+i*50-500,120,30);
		    		   }
		    		   else
		    		   {
		    			   nevek[i].setBounds(300,150+i*50,120,30);		   
		    		   }
		    		   nevek[i].setBackground(new Color(130,130,130,230));
		    		   
		    		   nevek[i].setForeground(Color.white);
		    		   
		    		   label.add(nevek[i]);
		    	   }
		    	   
		    	   JButton bCredits = new JButton("GO");
		    	   bCredits.setBounds(620, 600, 60, 40);
		    	   bCredits.addActionListener(new GoButtonPressed());
		    	   label.add(bCredits);	  
		       }		
		}
	}
	
	private class GoButtonPressed implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			Game.getInstance();
			/*
			for (int i = 0; i < kaszt.length; i++) {
				if (kaszt[i].getSelectedItem() == "Eszkim�") {
					System.out.println("ESKIMO L�TREHOZVA");
					Game.getInstance().addEskimo(0, nevek[i].getText());
				}
				else {
					System.out.println("SCI L�TREHOZVA");
					Game.getInstance().addScientist(0, nevek[i].getText());
				}
			}*/
			//Game.notifyView();

		}
		
	}
	
	private class StartPressedListener implements ActionListener {
		
	    public void actionPerformed(ActionEvent e) {
	/*		label.remove(bStart);
			label.remove(bCredits);
			label.remove(bExit);*/
			label.removeAll();
	    	
	    	JButton bBack = new JButton("BACK");
	    	bBack.setBounds(900, 40, 300, 70);
	    	bBack.setForeground(Color.white);
	    	bBack.setFont(new Font("Cochin", Font.PLAIN, 50));
			bBack.setOpaque(false);
			bBack.setContentAreaFilled(false);
			bBack.setBorderPainted(false);
			bBack.addMouseListener(new MouseHover());
			bBack.setFocusable(false);
			bBack.addActionListener(new BackPressedListener());
			label.add(bBack);
	    	
	    	
	    	

			
	    	   nev = new JLabel("N�v");
	    	   nev.setBounds(300,100,40,40);
	    	   nev.setForeground(Color.white);
	    	   nev.setFont(new Font("Cochin", Font.PLAIN, 20));
	    	   label.add(nev);
	    	   
	    	   nev2 = new JLabel("N�v");
	    	   nev2.setBounds(800,100,40,40);
	    	   nev2.setForeground(Color.white);
	    	   nev2.setFont(new Font("Cochin", Font.PLAIN, 20));
	    	   nev2.setVisible(false);
	    	   label.add(nev2);
	    	   
	    	   kaszt1 = new JLabel("Kaszt");
	    	   kaszt1.setBounds(450,100,50,40);
	    	   kaszt1.setForeground(Color.white);
	    	   kaszt1.setFont(new Font("Cochin", Font.PLAIN, 20));
	    	   label.add(kaszt1);
	    	   
	    	   kaszt2 = new JLabel("Kaszt");
	    	   kaszt2.setBounds(900,100,50,40);
	    	   kaszt2.setForeground(Color.white);
	    	   kaszt2.setFont(new Font("Cochin", Font.PLAIN, 20));
	    	   kaszt2.setVisible(false);
	    	   label.add(kaszt2);
	    	   
    		   
			JLabel label2 = new JLabel("H�ny j�t�kos? ");
			label2.setForeground(Color.white);
			label2.setBounds(300,50,300,30);
			label2.setFont(new Font("Cochin", Font.PLAIN, 30));
			label.add(label2);
			
			
			JComboBox cb = new JComboBox();
			for(int i=0;i<21;i++)
			{
				cb.addItem(new Integer(i));
			}
			cb.setBounds(600,50,50,30);
			cb.addItemListener(new HowManyPlayerListener());
			label.add(cb);
			
	    }
	}
	
	private class ExitPressedListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	private class BackPressedListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			label.removeAll();
			InitMenu();
		}
	}
	
	private class CreditsPressedListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			label.removeAll();
			
			JLabel l1, l2, l3, l4, l5;
			l1 = new JLabel("Balczer Dominik");
			l1.setBounds(50, 30, 440, 50);
			l1.setForeground(Color.white);
	    	l1.setFont(new Font("Arcade Normal", Font.PLAIN, 20));
	    	label.add(l1);
			l2 = new JLabel("Barabas Daniel");
			l2.setBounds(50, 90, 440, 50);
			l2.setForeground(Color.white);
	    	l2.setFont(new Font("Arcade Normal", Font.PLAIN, 20));
	    	label.add(l2);
			l3 = new JLabel("Csonge Bence");
			l3.setBounds(480, 30, 440, 50);
			l3.setForeground(Color.white);
	    	l3.setFont(new Font("Arcade Normal", Font.PLAIN, 20));
	    	label.add(l3);
			l4 = new JLabel("Gyarmati Zalan");
			l4.setBounds(480, 90, 440, 50);
			l4.setForeground(Color.white);
	    	l4.setFont(new Font("Arcade Normal", Font.PLAIN, 20));
	    	label.add(l4);
			l5 = new JLabel("Nagy Norbert");
			l5.setBounds(290, 150, 440, 50);
			l5.setForeground(Color.white);
	    	l5.setFont(new Font("Arcade Normal", Font.PLAIN, 20));
	    	label.add(l5);
			
			
	    	JButton bBack = new JButton("BACK");
	    	bBack.setBounds(900, 40, 300, 70);
	    	bBack.setForeground(Color.white);
	    	bBack.setFont(new Font("Cochin", Font.PLAIN, 50));
			bBack.setOpaque(false);
			bBack.setContentAreaFilled(false);
			bBack.setBorderPainted(false);
			bBack.addMouseListener(new MouseHover());
			bBack.setFocusable(false);
			bBack.addActionListener(new BackPressedListener());
			label.add(bBack);
		}
	}
	private class MouseHover extends MouseAdapter{
		@Override
        public void mouseEntered(MouseEvent me) {
       	((JButton) me.getSource()).setFont(new Font("Cochin", Font.PLAIN, 60));
       	((JButton) me.getSource()).setForeground(new Color(66,180,230));
        }
		@Override
        public void mouseExited(MouseEvent me) {
		((JButton) me.getSource()).setFont(new Font("Cochin", Font.PLAIN, 50));
		((JButton) me.getSource()).setForeground(Color.white);
		}
	}
}


