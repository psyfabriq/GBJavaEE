package com.pfq.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nomenclature")
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
    @ManyToOne
    private Category category;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    private  List<Order> orders = new ArrayList();
    
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Order> getOrders() {
		return orders;
	}
	

	
	
}
