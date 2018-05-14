package com.pfq.entity;

import java.util.Date;
import java.util.HashSet;
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
@Table(name = "torder")
public class Order  extends AbstractEntity{

	@Column
    private String name = "";
	@Column
    private String phone = "";
	@Column
    private String adress = "";
	@Column
	private String description;
	@Column
	private Date date;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
    		name = "order_nomenclatures",
            joinColumns = { @JoinColumn(name = "order_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "nomenclature_id") }
        )
    private  Set<Nomenclature> nomenclatures = new HashSet();

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
	public Set<Nomenclature> getNomenclatures() {
		return nomenclatures;
	}
	public void addNomenclature(Nomenclature product) {
		this.nomenclatures.add(product);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
    
}
