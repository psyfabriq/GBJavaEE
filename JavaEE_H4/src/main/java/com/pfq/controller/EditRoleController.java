package com.pfq.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.pfq.dao.RoleDAO;
import com.pfq.entity.Role;

@ViewScoped
@ManagedBean
public class EditRoleController extends AbstractController {

	private final String id = getParamString("id");

	@Inject
	private RoleDAO roleDAO;

	private Role role;

	@PostConstruct
	private void init() {
		role = id.isEmpty() ? new Role() : roleDAO.getRoleById(id);
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String save() {
		if (id.isEmpty()) {
			roleDAO.persist(role);
		} else {
			roleDAO.merge(role);
		}
		return "listrole";
	}

}
