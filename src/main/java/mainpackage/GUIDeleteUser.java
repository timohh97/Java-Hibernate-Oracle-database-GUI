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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GUIDeleteUser extends JFrame{

	private JLabel label;
    private JTable table;
    private JButton deleteButton;
    private JButton goBackButton;


    public GUIDeleteUser(String title) {
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout mainLayout = new GridLayout(4,1);
        mainLayout.setVgap(15);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,60,60,60));
        panel.setLayout(mainLayout);
        panel.setBackground(Color.BLACK);

        add(panel,BorderLayout.CENTER);

        initComponents();
        addComponentsToPanel(panel);

        setStyleOfComponents(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);


    }


    private void addComponentsToPanel(JPanel panel)
    {
        panel.add(label);
        panel.add(table);
        panel.add(deleteButton);
        panel.add(goBackButton);




    }

    private void setStyleOfComponents(JPanel panel)
    {
    	
    	for (Component c : panel.getComponents())
    	{
    		if(!(c.equals(table)))
    		{
    		c.setForeground(Color.WHITE);
    		c.setBackground(Color.BLACK);
    		c.setFont(c.getFont().deriveFont(32.0f));
    		}
    	}
    	
    }


    private void initComponents()  {

        label = new JLabel("Select a user:");
        
        final DefaultTableModel tableModel = new DefaultTableModel();
    
    	
    	List<Person> personList = RowReader.readAllRows();
    	final List<Vector> rowList = new ArrayList<Vector>();
    	
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
        deleteButton = new JButton("Delete user");
        goBackButton = new JButton("Go back");


        deleteButton.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
                        
            	int i =table.getSelectedRow();
            	Vector rowVector =rowList.get(i);
            	
            	int id = (Integer) rowVector.get(0);
                
            	tableModel.removeRow(i);
            	
            	RowDeleter.deleteRow(id);
            	
            	

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
