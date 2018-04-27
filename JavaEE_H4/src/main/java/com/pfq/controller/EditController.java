package com.pfq.controller;

import com.pfq.dao.NomenclatureDAO;
import com.pfq.entity.Nomenclature;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class EditController extends AbstractController {

	private final String id = getParamString("id");

	@Inject
	private NomenclatureDAO productDAO;

	private Nomenclature product;

	@PostConstruct
	private void init() {
		product = id.isEmpty() ? new Nomenclature() : productDAO.getProductById(id);
	}

	public Nomenclature getProduct() {
		return product;
	}

	public void setProduct(Nomenclature product) {
		this.product = product;
	}

	public String save() {
		if (id.isEmpty()) {
			productDAO.persist(product);
		} else {
			productDAO.merge(product);
		}
		return "listnomenclature";
	}

}
