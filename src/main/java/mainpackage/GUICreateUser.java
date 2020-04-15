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

public class GUICreateUser extends JFrame{
	
	private JLabel nameLabel;
    private JTextField nameText;
    private JLabel first_nameLabel;
    private JTextField first_nameText;
    private JLabel emailLabel;
    private JTextField emailText;
    private JLabel ageLabel;
    private JTextField ageText;
    private JButton registerButton;
    private JButton goBackButton;
    
 


    public GUICreateUser(String titel) {

        setTitle(titel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout mainLayout = new GridLayout(5,2);
        mainLayout.setVgap(10);
        mainLayout.setHgap(20);

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
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(first_nameLabel);
        panel.add(first_nameText);
        panel.add(emailLabel);
        panel.add(emailText);
        panel.add(ageLabel);
        panel.add(ageText);
        panel.add(registerButton);
        panel.add(goBackButton);
        

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

     
        nameLabel = new JLabel("Name:");
        nameText = new JTextField();
        first_nameLabel = new JLabel("First name:");
        first_nameText = new JTextField();
        emailLabel = new JLabel("E-mail:");
        emailText = new JTextField();
        ageLabel = new JLabel("Age");
        ageText = new JTextField();
        registerButton = new JButton("Register");
        goBackButton = new JButton("Go back");

        registerButton.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
               
            	try{
            	String name =nameText.getText();
            	String first_name =first_nameText.getText();
            	String email = emailText.getText();
            	int age = Integer.parseInt(ageText.getText());
            	
            	RowInserter.insertRow(name, first_name, email, age);
                
            	JOptionPane.showMessageDialog(GUICreateUser.this, "Registration successful!");}
            	catch (Exception exc){
            		JOptionPane.showMessageDialog(GUICreateUser.this, "Registration not successful!");	
            	}
            	
            }
        });
        
        goBackButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUIStart gui = new GUIStart("User registration system");
				
			}
		});

}

}
