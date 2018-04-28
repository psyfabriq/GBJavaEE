package com.pfq.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

import com.pfq.entity.Category;
import com.pfq.entity.Nomenclature;

@Stateless
public class CategoryDAO extends AbstractDAO {
	
	/*
	public List<Category> getListCategoriesByProductId(String categoryId) {
		if (categoryId == null || categoryId.isEmpty())
			return getListCategories();
		return em.createQuery("SELECT e FROM Category e WHERE category.id = :categoryId", Category.class)
				.setParameter("categoryId", categoryId).getResultList();
	}
	*/

	public List<Category> getListCategory() {
		return em.createQuery("SELECT e FROM Category e", Category.class).getResultList();
	}

	public void persist(Category category) {
		if (category == null)
			return;
		em.persist(category);
	}

	public Category getCategoryById(String id) {
		if (id == null)
			return null;
		return em.find(Category.class, id);
	}

	public void merge(Category category) {
		if (category == null)
			return;
		em.merge(category);
	}

	public void removeCategory(Category category) {
		if (category == null)
			return;
		em.remove(category);
	}

	public void removeCategory(String categoryid) {
		if (categoryid == null || categoryid.isEmpty())
			return;
		Category category = em.find(Category.class, categoryid);
		em.remove(category);
	}
}
