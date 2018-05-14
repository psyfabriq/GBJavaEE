package com.pfq.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tnomenclature")
public class Nomenclature extends AbstractEntity {

	@Column(nullable = false, columnDefinition = "TEXT")
	private String name;
	@Column
	private String img_path;
	@Column
	private String description;
	private Boolean publish;
	private int cost;
    private Date date;
    
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "nomenclatures")
    private  Set<Order> orders = new HashSet();
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinTable(
    		name = "nomenclatures_categories",
            joinColumns = { @JoinColumn(name = "nomenclature_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "category_id") }
        )
    private  List<Category> categores = new ArrayList();
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getPublish() {
		return publish;
	}
	public void setPublish(Boolean publish) {
		this.publish = publish;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public List<Category> getCategores() {
		return categores;
	}
	public void setCategores(List<Category> categores) {
		this.categores = categores;
	}
	
	public void addCategores(Category category) {
		this.categores.add(category);
	}
	
	

	
	
}
