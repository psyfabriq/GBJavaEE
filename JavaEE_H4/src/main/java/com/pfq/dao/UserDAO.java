package com.pfq.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.pfq.entity.User;

@Local
@Stateless
public class UserDAO extends AbstractDAO {
	

	public List<User> getListUsers() {
		return em.createQuery("SELECT e FROM User e", User.class).getResultList();
	}

	public void persist(User user) {
		if (user == null)
			return;
		em.persist(user);
	}

	public User getUserById(String id) {
		if (id == null)
			return null;
		return em.find(User.class, id);
	}

	public void merge(User user) {
		if (user == null)
			return;
		em.merge(user);
	}

	public void removeUser(User user) {
		if (user == null)
			return;
		removeUser(user.getId());
	}

	public void removeUser(String userid) {
		if (userid == null || userid.isEmpty())
			return;
		User user = em.find(User.class, userid);
		em.remove(user);
	}
}
