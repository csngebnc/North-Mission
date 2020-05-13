package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Core.Game;
import Items.Item;
import Player.Player;

/**
 * Játékos leltárát megjelenitõ dialógusablak
 * @author Balczer Dominik
 */
public class Inventory extends JDialog{

	private static final long serialVersionUID = 1L;
	
	/**
	 * A játékos akinek a leltárját megjelenitjük
	 * @author Balczer Dominik
	 */
	private Player player;
	
	/**
	 * A játékos tárgyai
	 * @author Balczer Dominik
	 */
	private ArrayList<Item> items;
	
	/**
	 * Saját magára mutató változó
	 * @author Balczer Dominik
	 */
	private JDialog dialog;
	
	/**
	 * Leltár elemeit tároló ListModel
	 * @author Balczer Dominik
	 */
	private DefaultListModel<String> listModel;
	
	/**
	 * A Use gomb (ezzel használjuk a tárgyat)
	 * @author Balczer Dominik
	 */
	private JButton useButton;
	
	/**
	 * A Drop gomb (ezzel dobhatjuk el a tárgyat)
	 * @author Balczer Dominik
	 */
    private JButton dropButton;
    
    /**
	 * ListModelünket tároló JList
	 * @author Balczer Dominik
	 */
    private JList<String> list;
    
    /**
	 * Görgethetõ panelje a dialógusablaknak
	 * @author Balczer Dominik
	 */
    private JScrollPane pane;
	
    /**
	 * Konstruktor, létrehozza az ablakot és megjeleniti
	 * @param p : A játékos akinek a leltárát megjelenitjük
	 * @author Balczer Dominik
	 */
	public Inventory(Player p)
	{
		initComponents();
		
		dialog = this;
		player = p;
		items = player.getInventory();
		this.setTitle("Inventory");
		this.setModal(true);
		this.setResizable(false);

		listModel = new DefaultListModel<String>();
		for(Item item : items)
			listModel.addElement(item.getName());
		
		this.setLocationRelativeTo(Game.getView());
		
		list.setModel(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		useButton.addActionListener(new ActionListener(){
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
		});
		
		dropButton.addActionListener(new ActionListener(){
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
		});
	}
	
	/**
	 * Inicializáláshoz használt függvény
	 * @author Balczer Dominik
	 */
	private void initComponents() {

        pane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        useButton = new javax.swing.JButton();
        dropButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(300, 335));

        pane.setViewportView(list);

        useButton.setText("Use");

        dropButton.setText("Drop");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(useButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(dropButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(useButton)
                    .addComponent(dropButton))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        pack();
    } 
}