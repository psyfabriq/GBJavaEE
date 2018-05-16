package com.pfq.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.pfq.entity.Order;

@Local
@Stateless
public class OrderDAO extends AbstractDAO {
	


	public List<Order> getListOrder() {
		return em.createQuery("SELECT e FROM Order e", Order.class).getResultList();
	}

	public void persist(Order order) {
		if (order == null)
			return;
		em.persist(order);
	}

	public Order getOrderById(String id) {
		if (id == null)
			return null;
		return em.find(Order.class, id);
	}

	public void merge(Order order) {
		if (order == null)
			return;
		em.merge(order);
	}

	public void removeOrder(Order order) {
		if (order == null)
			return;
		em.remove(order);
	}

	public void removeOrder(String orderid) {
		if (orderid == null || orderid.isEmpty())
			return;
		Order order = em.find(Order.class, orderid);
		em.remove(order);
	}
}
