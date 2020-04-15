package mainpackage;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Start {
	
	public static void main(String[] args)
	{
		GUIStart gui = new GUIStart("User registration system");
	}
	
	
	static List<Object> connectWithDatabase()
	{
		
	
	
		List<Object> transactionAndSessionList= new ArrayList<Object>();
		
		
        Configuration conf = new Configuration();
		
		String password = JOptionPane.showInputDialog("Please enter the password:");
		
		
		conf.setProperty("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
		conf.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
		conf.setProperty("hibernate.connection.username", "system");
		
		
		conf.setProperty("hibernate.connection.password", password);
		
		
		
		conf.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.Oracle8iDialect");
		conf.setProperty("hibernate.show_sql", "true");
		
        conf.addAnnotatedClass(Person.class);
        
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction t = session.beginTransaction();
        
        transactionAndSessionList.add(session);
        transactionAndSessionList.add(t);
        
        
        
        return transactionAndSessionList;
        
	
	}

}
