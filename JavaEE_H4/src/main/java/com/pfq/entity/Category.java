package com.pfq.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Category extends AbstractEntity {

	@Column
	private String name = "";

	@Column
	private String description = "";

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Nomenclature> products = new ArrayList<>();

	public Category(boolean isAll) {
		if (isAll) {
			this.name = "All";
			super.id = "0";
		}
	}

	public Category() {
	}

	public List<Nomenclature> getProducts() {
		return products;
	}

	public void setProducts(List<Nomenclature> products) {
		this.products = products;
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
