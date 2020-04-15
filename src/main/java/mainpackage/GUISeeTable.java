package mainpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUISeeTable extends JFrame{

	private JTable table;
	private JButton goBackButton;
   


    public GUISeeTable(String titel) {

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
    	List<Vector> rowList = new ArrayList<Vector>();
    	
    	for(Person p : personList)
    	{
    		Vector v = new Vector();
    		v.add(p.getId());
    		v.add(p.getName());
    		v.add(p.getFirst_name());
    		v.add(p.getEmail());
    		v.add(p.getAge());
    		
    		rowList.add(v);
    		
    	}
    	
    	String[] columnNames = {"Id","Name","First Name","Email","Age"};
    	
        for(String s : columnNames)
        {
        	tableModel.addColumn(s);
        }
    	
    	for(Vector v : rowList)
    	{
    	    tableModel.addRow(v);
    	}
    	
    	
        table = new JTable(tableModel);
        table.setEnabled(false);
        goBackButton = new JButton("Go back");
        

        goBackButton.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
               
            	dispose();
            	GUIStart gui = new GUIStart("User registration system");
              
            }
        });

}
	
}
