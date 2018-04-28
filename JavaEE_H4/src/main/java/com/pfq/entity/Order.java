package com.pfq.entity;

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

@Entity
@Table(name = "order")
public class Order  extends AbstractEntity{

	@Column
    private String name = "";
	@Column
    private String phone = "";
	@Column
    private String adress = "";
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
    		name = "products",
            joinColumns = { @JoinColumn(name = "order_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "nomenclature_id") }
        )
    private  List<Nomenclature> products = new ArrayList();

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public List<Nomenclature> getProducts() {
		return products;
	}
	public void addProduct(Nomenclature product) {
		this.products.add(product);
	}
    
    
}
