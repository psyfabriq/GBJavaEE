package com.pfq.entity;

import java.util.ArrayList;
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
import javax.persistence.Table;

@Entity
@Table(name = "tcategory")
public class Category extends AbstractEntity {

	@Column
	private String name = "";

	@Column
	private String description = "";

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinTable(
    		name = "nomenclatures_categories",
            joinColumns = { @JoinColumn(name = "category_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "nomenclature_id") }
        )
	private List<Nomenclature> products = new ArrayList();

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
