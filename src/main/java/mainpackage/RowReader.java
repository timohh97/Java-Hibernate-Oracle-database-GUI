package mainpackage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RowReader {

	public static List<Person> readAllRows() {
		
        List<Object> transactionAndSessionList = Start.connectWithDatabase();
		
		Session session = (Session) transactionAndSessionList.get(0);
		
	    return session.createQuery("SELECT a FROM Person a", Person.class).getResultList();      
	}
}
