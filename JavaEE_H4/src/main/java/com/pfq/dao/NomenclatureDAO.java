package com.pfq.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import com.pfq.entity.Nomenclature;

import java.util.*;

@Local
@Stateless
public class NomenclatureDAO extends AbstractDAO {

	public List<Nomenclature> getListProductByCategoryId(String categoryId) {
		if (categoryId == null || categoryId.isEmpty())
			return getListProduct();
		return em.createQuery("SELECT e FROM Nomenclature e WHERE category.id = :categoryId", Nomenclature.class)
				.setParameter("categoryId", categoryId).getResultList();
	}

	public List<Nomenclature> getListProduct() {
		return em.createQuery("SELECT e FROM Nomenclature e", Nomenclature.class).getResultList();
	}

	public void persist(Nomenclature product) {
		if (product == null)
			return;
		//System.out.println(product.getCategores().size());
		em.persist(product);
	}

	public Nomenclature getProductById(String id) {
		if (id == null)
			return null;
		return em.find(Nomenclature.class, id);
	}

	public void merge(Nomenclature product) {
		if (product == null)
			return;
		//System.out.println(product.getCategores().size());
		em.merge(product);
	}

	public void removeProduct(Nomenclature product) {
		if (product == null)
			return;
		removeProduct(product.getId());
	}

	public void removeProduct(String productId) {
		if (productId == null || productId.isEmpty())
			return;
		Nomenclature product = em.find(Nomenclature.class, productId);
		em.remove(product);
	}

}
