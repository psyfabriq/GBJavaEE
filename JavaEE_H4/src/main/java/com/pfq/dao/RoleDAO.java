package com.pfq.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.pfq.entity.Role;

@Stateless
public class RoleDAO extends AbstractDAO {
	

	public List<Role> getListRoles() {
		return em.createQuery("SELECT e FROM Role e", Role.class).getResultList();
	}

	public void persist(Role role) {
		if (role == null)
			return;
		em.persist(role);
	}

	public Role getRoleById(String id) {
		if (id == null)
			return null;
		return em.find(Role.class, id);
	}

	public void merge(Role role) {
		if (role == null)
			return;
		em.merge(role);
	}

	public void removeRole(Role role) {
		if (role == null)
			return;
		removeRole(role.getId());
	}

	public void removeRole(String roleid) {
		if (roleid == null || roleid.isEmpty())
			return;
		Role role = em.find(Role.class, roleid);
		em.remove(role);
	}
}
