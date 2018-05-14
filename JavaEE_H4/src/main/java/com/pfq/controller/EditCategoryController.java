package com.pfq.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.pfq.dao.CategoryDAO;
import com.pfq.entity.Category;

@ViewScoped
@ManagedBean
public class EditCategoryController extends AbstractController {

	private final String id = getParamString("id");

	@Inject
	private CategoryDAO categoryDAO;

	private Category category;

	@PostConstruct
	private void init() {
		category = id.isEmpty() ? new Category() : categoryDAO.getCategoryById(id);
	}

	public Category getCategore() {
		return category;
	}

	public void setCategore(Category category) {
		this.category = category;
	}

	public String save() {
		if (id.isEmpty()) {
			categoryDAO.persist(category);
		} else {
			categoryDAO.merge(category);
		}
		return "listcategore";
	}

}
