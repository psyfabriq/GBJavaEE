package com.pfq.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.pfq.dao.UserDAO;
import com.pfq.entity.User;

@ViewScoped
@ManagedBean
public class EditUserController extends AbstractController {

	private final String id = getParamString("id");
	private String[] selectedRoles;

	@Inject
	private UserDAO userDAO;

	private User user;

	@PostConstruct
	private void init() {
		user = id.isEmpty() ? new User() : userDAO.getUserById(id);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String save() {
		if (id.isEmpty()) {
			userDAO.persist(user);
		} else {
			userDAO.merge(user);
		}
		return "listusers";
	}

	public String[] getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(String[] selectedRoles) {
		this.selectedRoles = selectedRoles;
	}
	
	

}
