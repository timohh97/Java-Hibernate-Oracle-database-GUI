package mainpackage;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		
		String password = JOptionPane.showInputDialog("Please enter the password:");
		
		conf.setProperty("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
		conf.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
		conf.setProperty("hibernate.connection.username", "system");
		conf.setProperty("hibernate.connection.password", password);
		conf.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.Oracle8iDialect");
		conf.setProperty("hibernate.show_sql", "true");
		
        conf.addAnnotatedClass(Persons.class);
        
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction t = session.beginTransaction();
        
        session.save(new Persons("Schessl","Timo","timo.schessl@gmx.de",22));
        t.commit();
        session.close();
        sf.close();
        
	}

}
