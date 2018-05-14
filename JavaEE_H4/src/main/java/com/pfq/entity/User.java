package com.pfq.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.pfq.utils.Password;

@Entity
@Table(name = "tuser")
public class User  extends AbstractEntity  implements Serializable  {

	@Column
	private String name = "";
	@Column
	private String login = "";
	@Column
	private String foldercode = "";
	@Column
	private String email = "";
	@Column
	private String passwordHash = "";
	@Column
	private boolean isactive;
	@Column
	private boolean isadministrative;
	@Column
	private Date   dateAdd;
	
	@Transient
	private String password;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinTable(
    		name = "users_roles",
            joinColumns = { @JoinColumn(name = "user_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
        )
	private List<Role> userRoles  = new ArrayList<Role>();;


	public User() {
		this.dateAdd   = new Date();
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFoldercode() {
		return foldercode;
	}

	public void setFoldercode(String foldercode) {
		this.foldercode = foldercode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		if(passwordHash!=null) {
		     User.this.passwordHash = Password.hashPassword(passwordHash);
		}
	}

	public Date getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}

	public List<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
		 setPasswordHash(password);
	}


	public boolean isIsactive() {
		return isactive;
	}


	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}


	public boolean isIsadministrative() {
		return isadministrative;
	}


	public void setIsadministrative(boolean isadministrative) {
		this.isadministrative = isadministrative;
	}
	
	
	
	

}
