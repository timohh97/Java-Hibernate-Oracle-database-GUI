package mainpackage;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RowInserter {

	public static void insertRow(String name, String first_name, String email, int age) {
        
		List<Object> transactionAndSessionList = Start.connectWithDatabase();
		
		Session session = (Session) transactionAndSessionList.get(0);
		Transaction t = (Transaction) transactionAndSessionList.get(1);
		
        session.save(new Person(name,first_name,email,age));
        t.commit();
        session.close();
        
	}

}
