package mainpackage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RowDeleter {

	
	public static void deleteRow(int id) {
		
        
		List<Object> transactionAndSessionList = Start.connectWithDatabase();
		
		Session session = (Session) transactionAndSessionList.get(0);
		Transaction t = (Transaction) transactionAndSessionList.get(1);
		
        Person person = session.get(Person.class,id);
        session.delete(person);
        
        t.commit();
        session.close();
        
	}
}
