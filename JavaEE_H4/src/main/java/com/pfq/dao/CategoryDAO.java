package com.pfq.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.Local;

import com.pfq.entity.Category;

@Local
@Stateless
public class CategoryDAO extends AbstractDAO {
	

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
		removeCategory(category.getId());
	}

	public void removeCategory(String categoryid) {
		if (categoryid == null || categoryid.isEmpty())
			return;
		Category category = em.find(Category.class, categoryid);
		em.remove(category);
	}
}
