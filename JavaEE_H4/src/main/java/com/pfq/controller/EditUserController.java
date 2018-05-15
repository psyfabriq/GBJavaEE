package com.pfq.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.pfq.dao.RoleDAO;
import com.pfq.dao.UserDAO;
import com.pfq.entity.Role;
import com.pfq.entity.User;

@ViewScoped
@ManagedBean
public class EditUserController extends AbstractController {

	private final String id = getParamString("id");
	private String[] selectedRoles;

	@Inject
	private UserDAO userDAO;

	@Inject
	private RoleDAO roleDAO;

	private User user;

	@PostConstruct
	private void init() {
		user = id.isEmpty() ? new User() : userDAO.getUserById(id);
		
		List<String> tmp = new ArrayList<>();
		for (Role role : user.getUserRoles()) {
			tmp.add(role.getId());
		}
		selectedRoles = new String[tmp.size()];
		selectedRoles = tmp.toArray(selectedRoles);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String save() {

		List<Role> tmp = new ArrayList<>();
		for (String string : selectedRoles) {
			tmp.add(roleDAO.getRoleById(string));
		}

		if (id.isEmpty()) {
			userDAO.persist(user);
		}
		user.setUserRoles(tmp);
		userDAO.merge(user);

		return "listusers";
	}

	public String[] getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(String[] selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

}
