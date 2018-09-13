
package dao;

import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import helpers.HibernateHelper;
import model.Todo;

public class TodoDAO {

	public static Stream<Todo> list() {
		
		Session s = HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;
		Stream<Todo> result = null;
		try {
			t = s.beginTransaction();
			
			result = s.createQuery("FROM Todos").list().stream();
			
		t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
		} finally {
			s.close();
		}
		return result;
	}

	public static Todo create(Todo todo) {
        Session s = HibernateHelper.getSessionFactory().openSession();
        Transaction t = null;

        try {
            t = s.beginTransaction();
            
            // CODE
            s.save(todo);
            
            t.commit();
        } catch(Exception e) {
            if(t != null)
                t.rollback();
        } finally {
            s.close();
        }
        
        return todo;
    }
	
	public static void delete(Integer id) {
		Session s =HibernateHelper.getSessionFactory().openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			
			Query q = s.createQuery("DELETE FROM Todos WHERE id_todo = :id");
			q.setParameter("id",id);
			q.executeUpdate();
			
		t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
		} finally {
			s.close();
		}
	}
	
 
}
