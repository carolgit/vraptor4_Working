package cih.projects.dao;

import javax.enterprise.context.RequestScoped;

import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@RequestScoped
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	@SuppressWarnings("deprecation")
	private static SessionFactory getSessionFactory() throws MappingException{
		 if(sessionFactory == null)
	            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	        return sessionFactory;
	}
	public static Session getSession()
    {
        return getSessionFactory().openSession();
    }
}
