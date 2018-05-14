package com.pfq.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.pfq.dao.OrderDAO;
import com.pfq.dao.RoleDAO;
import com.pfq.dao.UserDAO;
import com.pfq.entity.Order;
import com.pfq.entity.Role;
import com.pfq.entity.User;


@ViewScoped
@ManagedBean
public class UserController {
	
	@Inject
	private UserDAO userDAO;
	
	@Inject
	private RoleDAO roleDAO;
	

	public void removeUser(User user) {
		userDAO.removeUser(user);
	}

	public List<User> getUsers() {
		return new ArrayList<>(userDAO.getListUsers());
	}
	
	public void removeRole(Role role) {
		roleDAO.removeRole(role);
	}

	public List<Role> getRoles() {
		return new ArrayList<>(roleDAO.getListRoles());
	}
	
	


}
