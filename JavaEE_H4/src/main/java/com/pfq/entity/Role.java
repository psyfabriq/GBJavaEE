package com.pfq.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author psyfabriq
 *
 */
@Entity
@Table(name = "trole")
public class Role extends AbstractEntity implements Serializable, Cloneable {

	@Column
	private String name;
	@Column
	private String description = "";

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private List<User> users = new ArrayList<User>();

	public enum Enum {
		ADMIN, USER
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}



	public List<User> getUsers() {
		return users;
	}


	public Role setUsers(User user) {
		this.users.add(user);
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	

}
