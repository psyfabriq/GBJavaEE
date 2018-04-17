package com.pfq.javaee.model;

public class Nomenclature {
	private String name;
	private String img_path;
	private String text;
	boolean productis ;
	private int old_cost;
	private int cost;
	
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isProductis() {
		return productis;
	}
	public void setProductis(boolean productis) {
		this.productis = productis;
	}
	public int getOld_cost() {
		return old_cost;
	}
	public void setOld_cost(int old_cost) {
		this.old_cost = old_cost;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
