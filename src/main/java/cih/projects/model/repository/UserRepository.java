package cih.projects.model.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;

import cih.projects.dao.GenericDao;
import cih.projects.dao.HibernateUtil;
import cih.projects.model.entity.User;

@RequestScoped
public class UserRepository extends GenericDao{
	
	public UserRepository(Session session) {
		super(session);
	}

	private Criteria createCriteria(){
		return HibernateUtil.getSession().createCriteria(User.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> list(){
		return createCriteria().list();
	}
}
