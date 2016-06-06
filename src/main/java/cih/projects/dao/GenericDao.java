package cih.projects.dao;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import antlr.collections.List;

@SuppressWarnings("deprecation")
@RequestScoped
public class GenericDao {
	SessionFactory factory =  new Configuration().configure().buildSessionFactory();
	protected final Session session = factory.openSession();

	public void objInsert(Object obj) {
		if (session != null) {
			session.getTransaction().begin();
			session.save(obj);
			session.flush();
			session.getTransaction().commit();
			session.close();
		} else {
			System.out.println("Session is null");
		}
	}

	public void objUpdate(Object obj) {
		session.getTransaction().begin();
		session.update(obj);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public void objDelete(Object obj) {
		session.getTransaction().begin();
		session.delete(obj);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public List list(Class clazz) {
		session.getTransaction().begin();
		List objts;
		objts = null;
		Criteria selectAll = session.createCriteria(clazz);
		session.getTransaction().commit();
		objts = (List) selectAll.list();
		session.close();
		return objts;
	}

	public Object list(Class clazz, String pk) {
		session.getTransaction().begin();
		Object objt = session.load(clazz, new Integer(Integer.parseInt(pk)));
		session.getTransaction().commit();
		session.flush();
		session.close();
		return objt;
	}

	public void rollBack() {
		session.getTransaction().rollback();
		session.close();
	}
	// public void closeConnection() throws Exception
	// {
	// session = HibernateUtil.getSession();
	// session.connection().createStatement().execute("SHUTDOWN");
	// }
}
