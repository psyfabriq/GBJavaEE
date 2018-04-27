package com.pfq.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order  extends AbstractEntity{

    private String name = "";
    private String phone = "";
    private String adress = "";
    private final List<Nomenclature> products = new ArrayList();

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
