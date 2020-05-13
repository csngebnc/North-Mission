package Core;

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
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A jatek allapotait tartalmazo enumeracio.
 * @author Barabás Dániel
 * @author Gyarmati Zalán
 */
public class Menu extends JPanel{

	/**
	 * Szerializáláshoz szükséges
	 * @author Balczer Dominik
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel mainLabel;
	JLabel name1, name2, playerType1, playerType2;
	JButton bStart, bCredits, bExit;
	JLabel titleLabel1, titleLabel2;
	JTextField[] names;
	JComboBox<String>[] playerTypes;
	Font font;
	
	public Menu()
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./assets/HUD/ARCADE_N.ttf")));
		} catch (Exception e) {e.printStackTrace();}
		
		font = new Font("Arcade Normal", Font.PLAIN, 30);
		
		this.setSize(new Dimension(1200,740));

		Icon imgIcon = new ImageIcon("./assets/menu_bg2.gif");
		mainLabel = new JLabel(imgIcon);
		this.add(mainLabel);
		
		//Cim
		titleLabel1 = new JLabel("North");
		titleLabel2 = new JLabel("Mission");
		titleLabel1.setBounds(30,50,300,30);
		titleLabel2.setBounds(30,85,500,70);
		titleLabel1.setFont(font.deriveFont(30f));
		titleLabel2.setFont(font.deriveFont(50f));
		titleLabel1.setForeground(Color.WHITE);
		titleLabel2.setForeground(Color.WHITE);
		titleLabel1.setOpaque(false);
		titleLabel2.setOpaque(false);
		titleLabel1.setFocusable(false);
		titleLabel2.setFocusable(false);
		mainLabel.add(titleLabel1);
		mainLabel.add(titleLabel2);
		
		//Start gomb
		bStart = new JButton("START");
		bStart.setBounds(450, 30, 330, 70);
		bStart.setForeground(Color.white);
		bStart.setFont(new Font("Arcade Normal", Font.PLAIN, 30));
		bStart.setOpaque(false);
		bStart.setContentAreaFilled(false);
		bStart.setBorderPainted(false);
		bStart.addMouseListener(new MouseHover());
		bStart.addActionListener(new StartPressedListener());
		bStart.setFocusable(false);
		mainLabel.add(bStart);
		
		
		//Credits gomb
		bCredits = new JButton("CREDITS");
		bCredits.setBounds(450, 90, 330, 70);
		bCredits.setForeground(Color.white);
		bCredits.setFont(new Font("Arcade Normal", Font.PLAIN, 30));
		bCredits.setOpaque(false);
		bCredits.setContentAreaFilled(false);
		bCredits.setBorderPainted(false);
		bCredits.addMouseListener(new MouseHover());
		bCredits.addActionListener(new CreditsPressedListener());
		bCredits.setFocusable(false);
		mainLabel.add(bCredits);
		
		//Exit gomb
		bExit = new JButton("EXIT");
		bExit.setBounds(450, 150, 330, 70);
		bExit.setForeground(Color.white);
		bExit.setFont(new Font("Arcade Normal", Font.PLAIN, 30));
		bExit.setOpaque(false);
		bExit.setContentAreaFilled(false);
		bExit.setBorderPainted(false);
		bExit.addMouseListener(new MouseHover());
		bExit.setFocusable(false);
		bExit.addActionListener(new ExitPressedListener());
		mainLabel.add(bExit);
		
		this.setVisible(true);
	}
	
	public void InitMenu() {

		bStart.setForeground(Color.white);
		bStart.setFont(new Font("Arcade Normal", Font.PLAIN, 30));
		bExit.setForeground(Color.white);
		bExit.setFont(new Font("Arcade Normal", Font.PLAIN, 30));
		bCredits.setForeground(Color.white);
		bCredits.setFont(new Font("Arcade Normal", Font.PLAIN, 30));
		
		mainLabel.add(titleLabel1);
		mainLabel.add(titleLabel2);
		mainLabel.add(bStart);
		mainLabel.add(bCredits);
		mainLabel.add(bExit);
	}
	
	private class HowManyPlayerListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {

				if(names != null)
					for(int i = 0; i < names.length; i++)
						mainLabel.remove(names[i]);
		    	   
				if(playerTypes != null)
					for(int i = 0; i < playerTypes.length; i++)
						mainLabel.remove(playerTypes[i]);
				
				
	    	   int playerCount = (int) event.getItem();
	    	   
	    	   if(playerCount < 9) {
	    		   name2.setVisible(false);
	    		   playerType2.setVisible(false);
	    	   }
	    	   else {
	    		   name2.setVisible(true);
	    		   playerType2.setVisible(true);
	    	   }
	    	   
	    	   names = new JTextField[playerCount];
	    	   playerTypes = new JComboBox[playerCount];
	    	   
	    	   for(int i = 0; i < playerCount; i++)
	    	   {
	    		   playerTypes[i]=new JComboBox<String>();
	    		   playerTypes[i].addItem("Scientist");
	    		   playerTypes[i].addItem("Eskimo");
	    		   
	    		   if(i > 9)
	    			   playerTypes[i].setBounds(950, 150 + i * 50 - 500, 80, 30);
	    		   else
	    			   playerTypes[i].setBounds(450, 150 + i * 50, 80, 30);	   
	    		   
	    		   mainLabel.add(playerTypes[i]);
	    	   }
	    	  
	    	   JLabel nev = new JLabel("Név");
	    	   nev.setBounds(300,100,40,40);
	    	   nev.setForeground(Color.white);
	    	   nev.setFont(new Font("Arcade Normal", Font.PLAIN, 20));
	    	   mainLabel.add(nev);
	    	   
	    	   for(int i=0; i<playerCount;i++) {
	    		   names[i]=new JTextField();
	    		   
	    		   if(i > 9)
	    			   names[i].setBounds(800,150+i*50-500,120,30);
	    		   else
	    			   names[i].setBounds(300,150+i*50,120,30);		   
	    		   
	    		   names[i].setBackground(new Color(130,130,130,230));
	    		   names[i].setForeground(Color.white);
	    		   
	    		   mainLabel.add(names[i]);
	    	   }
			}		
		}
	}
	
	
	private class GoButtonPressed implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if(names!=null){
				ArrayList<String> eskimos = new ArrayList<String>();
				ArrayList<String> scientists = new ArrayList<String>();
				
				for(int i = 0; i < names.length; i++) {
					if(playerTypes[i].getSelectedItem() == "Eskimo")
						eskimos.add(names[i].getText());
					else
						scientists.add(names[i].getText());
				}
				WindowFrame.switchToGame(eskimos, scientists);
			}
		}
	}
	
	private class StartPressedListener implements ActionListener {
		@Override
	    public void actionPerformed(ActionEvent e) {
			mainLabel.removeAll();
	    	
	    	JButton bBack = new JButton("BACK");
	    	bBack.setBounds(0, 30, 300, 70);
	    	bBack.setForeground(Color.white);
	    	bBack.setFont(new Font("Arcade Normal", Font.PLAIN, 30));
			bBack.setOpaque(false);
			bBack.setContentAreaFilled(false);
			bBack.setBorderPainted(false);
			bBack.addMouseListener(new MouseHover());
			bBack.setFocusable(false);
			bBack.addActionListener(new BackPressedListener());
			mainLabel.add(bBack);
	    	
	    	JButton bGo = new JButton("GO");
	    	bGo.setBounds(530, 42, 120, 50);
	    	bGo.setForeground(Color.white);
	    	bGo.setFont(new Font("Arcade Normal", Font.PLAIN, 30));
			bGo.setOpaque(false);
			bGo.setContentAreaFilled(false);
			bGo.setBorderPainted(false);
			bGo.addMouseListener(new MouseHover());
			bGo.setFocusable(false);
			bGo.addActionListener(new GoButtonPressed());
			mainLabel.add(bGo);
	
			name1 = new JLabel("Name");
			name1.setBounds(300,100, 60,50);
			name1.setForeground(Color.white);
			name1.setFont(new Font("Arcade Normal", Font.PLAIN, 15));
			mainLabel.add(name1);
	   
			name2 = new JLabel("Name");
			name2.setBounds(800,100,60,50);
			name2.setForeground(Color.white);
			name2.setFont(new Font("Arcade Normal", Font.PLAIN, 15));
			name2.setVisible(false);
			mainLabel.add(name2);
	   
			playerType1 = new JLabel("Type");
			playerType1.setBounds(450,100,70,50);
			playerType1.setForeground(Color.white);
			playerType1.setFont(new Font("Arcade Normal", Font.PLAIN, 15));
			mainLabel.add(playerType1);
	   
			playerType2 = new JLabel("Type");
			playerType2.setBounds(900,100,70,50);
			playerType2.setForeground(Color.white);
			playerType2.setFont(new Font("Arcade Normal", Font.PLAIN, 15));
			playerType2.setVisible(false);
			mainLabel.add(playerType2);
	    	   
			JLabel label2 = new JLabel("PLAYERS: ");
			label2.setForeground(Color.white);
			label2.setBounds(300,50,300,30);
			label2.setFont(new Font("Arcade Normal", Font.PLAIN, 20));
			mainLabel.add(label2);
			
			JComboBox cb = new JComboBox();
			for(int i=0;i<21;i++)
				cb.addItem(new Integer(i));
			cb.setBounds(470,50,50,30);
			cb.addItemListener(new HowManyPlayerListener());
			mainLabel.add(cb);
	    }
	}
	
	private class ExitPressedListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
	
	private class BackPressedListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			mainLabel.removeAll();
			InitMenu();
		}
	}
	
	private class CreditsPressedListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			mainLabel.removeAll();
			
			JLabel l1, l2, l3, l4, l5;
			l1 = new JLabel("Balczer Dominik");
			l1.setBounds(50, 30, 440, 50);
			l1.setForeground(Color.white);
	    	l1.setFont(new Font("Arcade Normal", Font.PLAIN, 20));
	    	mainLabel.add(l1);
			l2 = new JLabel("Barabas Daniel");
			l2.setBounds(50, 90, 440, 50);
			l2.setForeground(Color.white);
	    	l2.setFont(new Font("Arcade Normal", Font.PLAIN, 20));
	    	mainLabel.add(l2);
			l3 = new JLabel("Csonge Bence");
			l3.setBounds(480, 30, 440, 50);
			l3.setForeground(Color.white);
	    	l3.setFont(new Font("Arcade Normal", Font.PLAIN, 20));
	    	mainLabel.add(l3);
			l4 = new JLabel("Gyarmati Zalan");
			l4.setBounds(480, 90, 440, 50);
			l4.setForeground(Color.white);
	    	l4.setFont(new Font("Arcade Normal", Font.PLAIN, 20));
	    	mainLabel.add(l4);
			l5 = new JLabel("Nagy Norbert");
			l5.setBounds(290, 150, 440, 50);
			l5.setForeground(Color.white);
	    	l5.setFont(new Font("Arcade Normal", Font.PLAIN, 20));
	    	mainLabel.add(l5);
			
			
	    	JButton bBack = new JButton("BACK");
	    	bBack.setBounds(900, 40, 300, 70);
	    	bBack.setForeground(Color.white);
	    	bBack.setFont(new Font("Arcade Normal", Font.PLAIN, 50));
			bBack.setOpaque(false);
			bBack.setContentAreaFilled(false);
			bBack.setBorderPainted(false);
			bBack.addMouseListener(new MouseHover());
			bBack.setFocusable(false);
			bBack.addActionListener(new BackPressedListener());
			mainLabel.add(bBack);
		}
	}
	
	private class MouseHover extends MouseAdapter{
		@Override
        public void mouseEntered(MouseEvent me) {
       	((JButton) me.getSource()).setFont(new Font("Arcade Normal", Font.PLAIN, 40));
       	((JButton) me.getSource()).setForeground(new Color(66,180,230));
        }
		@Override
        public void mouseExited(MouseEvent me) {
		((JButton) me.getSource()).setFont(new Font("Arcade Normal", Font.PLAIN, 30));
		((JButton) me.getSource()).setForeground(Color.white);
		}
	}
}


