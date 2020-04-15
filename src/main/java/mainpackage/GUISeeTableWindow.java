package mainpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUISeeTableWindow extends JFrame{

	private JTable table;
	private JButton goBackButton;
   


    public GUISeeTableWindow(String titel) {

        setTitle(titel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout mainLayout = new GridLayout(2,1);
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
        panel.add(table);
        panel.add(goBackButton);
       

    }

    private void setColorOfComponents(JPanel panel)
    {
    	
    	goBackButton.setForeground(Color.WHITE);
        goBackButton.setBackground(Color.BLACK);
        goBackButton.setFont(goBackButton.getFont().deriveFont(32.0f));
    	
    	
    }


    private void initComponents() {

        DefaultTableModel tableModel = new DefaultTableModel();
    
    	
    	List<Person> personList = RowReader.readAllRows();
    	List<Vector> 
    	
    	for(Person p : personList)
    	{
    		
    	}
    	
    	
    	
    	tableModel.addColumn("Name");
    	tableModel.addRow();
    	
    	
    	
    	
        table = new JTable(tableModel);
        goBackButton = new JButton("Go back");
        

        goBackButton.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
               
            	dispose();
            	GUIStartWindow gui = new GUIStartWindow("User registration system");
              
            }
        });

}
	
}
