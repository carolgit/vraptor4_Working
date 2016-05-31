package cih.projects.dao;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;

import antlr.collections.List;
import org.hibernate.stat.SessionStatistics;


public class GenericDao {
	private static Session session;
	private Transaction transaction;
	public void objInsert(Object obj)throws Exception{
		session = HibernateUtil.getSession();
		transaction = (Transaction) session.beginTransaction();
		session.save(obj);
		session.flush();
		transaction.commit();
		session.close();
	}
	 public void objUpdate( Object obj ) throws Exception
	    {
	            session = HibernateUtil.getSession();
	            transaction = (Transaction) session.beginTransaction();
	            session.update(obj);
	            session.flush();
	            transaction.commit();
	            session.close();
	    }
	    public void objDelete( Object obj ) throws Exception
	    {
	            session = HibernateUtil.getSession();
	            transaction = (Transaction) session.beginTransaction();
	            session.delete(obj);
	            session.flush();
	            transaction.commit();
	            session.close();
	    }
	    public List list(Class clazz) throws Exception
	    {
	        session = HibernateUtil.getSession();
	        transaction = (Transaction) session.beginTransaction();
	        List objts;
	        objts = null;
	        Criteria selectAll = session.createCriteria(clazz);
	        transaction.commit();
	        objts = (List) selectAll.list();
	        session.close();
	        return objts;
	    }
	     public Object list(Class clazz, String pk) throws Exception
	    {
	        session = HibernateUtil.getSession();
	        transaction = (Transaction) session.beginTransaction();
	        Object objt =  session.load(clazz, new Integer(Integer.parseInt(pk)) );
	        transaction.commit();
	        session.flush();
	        session.close();
	        return objt;
	    }
	    public void rollBack() throws IllegalStateException, SystemException
	    {
	        transaction.rollback();
	        session.close();
	    }
//	    public void closeConnection() throws Exception
//	    {
//	            session = HibernateUtil.getSession();
//	            session.connection().createStatement().execute("SHUTDOWN");
//	    }
}
