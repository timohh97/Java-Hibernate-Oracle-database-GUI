package mainpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIStartWindow extends JFrame{

	
	    private JButton createUserButton;
	    private JButton seeUsersButton;
	    private JButton deleteUserButton;


	    public GUIStartWindow(String titel) {

	        setTitle(titel);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        GridLayout mainLayout = new GridLayout(3,1);
	        mainLayout.setVgap(10);

	        JPanel panel = new JPanel();
	        panel.setBorder(BorderFactory.createEmptyBorder(30,100,60,100));
	        panel.setLayout(mainLayout);
	        panel.setBackground(Color.BLACK);

	        add(panel,BorderLayout.CENTER);

	        initComponents();
	        addComponentsToPanel(panel);

	        setColorOfComponents(panel);

	        pack();
	        setLocationRelativeTo(null);
	        setVisible(true);
	        setResizable(false);

	    }


	 

		private void addComponentsToPanel(JPanel panel)
	    {
	        panel.add(createUserButton);
	        panel.add(seeUsersButton);
	        panel.add(deleteUserButton);

	    }

	    private void setColorOfComponents(JPanel panel)
	    {
	    	
	    	for (Component c : panel.getComponents())
	    	{
	    		c.setForeground(Color.WHITE);
	    		c.setBackground(Color.BLACK);
	    		c.setFont(c.getFont().deriveFont(32.0f));
	    	}
	    	
	    }


	    private void initComponents() {

	     
	        createUserButton = new JButton("Register"); 
	        seeUsersButton = new JButton("Look at table"); 
	        deleteUserButton = new JButton("Delete User");

	        createUserButton.addActionListener(new ActionListener() {
	        	
	            public void actionPerformed(ActionEvent e) {
	               
	            	dispose();
	            	BuildCreateUserWindow.buildCreateUserWindowGUI();
	              
	            }
	        });
	        
           seeUsersButton.addActionListener(new ActionListener() {
	        	
	            public void actionPerformed(ActionEvent e) {
	               
	            	dispose();
	            	BuildSeeTableWindow.buildSeeTableWindowGUI();
	              
	            }
	        });

	}
	
}
