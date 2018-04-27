package com.pfq.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.pfq.dao.CategoryDAO;
import com.pfq.dao.NomenclatureDAO;
import com.pfq.entity.Category;
import com.pfq.entity.Nomenclature;


@ViewScoped
@ManagedBean
public class NomenclatureController {
	@Inject
	private NomenclatureDAO productDAO;
	
	@Inject
	private CategoryDAO categorytDAO;

	public void removeProduct(Nomenclature product) {
		productDAO.removeProduct(product);
	}

	public List<Nomenclature> getProducts() {
		return new ArrayList<>(productDAO.getListProduct());
	}
	
	public void removeCategory(Category category) {
		categorytDAO.removeCategory(category);
	}

	public List<Category> getCategores() {
		return new ArrayList<>(categorytDAO.getListCategores());
	}


}
