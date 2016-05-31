package cih.projects.model.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;

import cih.projects.model.entity.User;

@RequestScoped
public class UserRepository {
	private Session session;
	private Criteria createCriteria(){
		return session.createCriteria(User.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> list(){
		return createCriteria().list();
	}
}
