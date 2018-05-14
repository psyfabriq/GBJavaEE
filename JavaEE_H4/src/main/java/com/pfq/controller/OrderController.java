package com.pfq.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.pfq.dao.OrderDAO;
import com.pfq.entity.Order;


@ViewScoped
@ManagedBean
public class OrderController {
	
	@Inject
	private OrderDAO orderDAO;
	

	public void removeOrder(Order order) {
		orderDAO.removeOrder(order);
	}

	public List<Order> getOrders() {
		return new ArrayList<>(orderDAO.getListOrder());
	}
	


}
