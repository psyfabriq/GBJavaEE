package com.pfq.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.pfq.entity.Link;

@ViewScoped
@ManagedBean
public class MenuController {

	public List<Link> getTopMenuLinks() {
		List<Link> list = new ArrayList<>();
		
		list.add(Link.newBuilder().setURL("").setTitle("Главная").build());
		list.add(Link.newBuilder().setURL("p/catalog").setTitle("Каталог").build());
		list.add(Link.newBuilder().setURL("p/cart").setTitle("Корзина").build());
		list.add(Link.newBuilder().setURL("p/order").setTitle("Заказы").build());

		return list;
	}
	
	 public String showPage(Link l) {
		 System.out.println(l.getUrl());
		return l.getUrl(); 
	 }
	 
	 



	

	
}
