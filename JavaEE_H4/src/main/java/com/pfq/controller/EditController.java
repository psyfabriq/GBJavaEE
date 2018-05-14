package com.pfq.controller;

import com.pfq.dao.CategoryDAO;
import com.pfq.dao.NomenclatureDAO;
import com.pfq.entity.Category;
import com.pfq.entity.Nomenclature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ViewScoped
@ManagedBean
public class EditController extends AbstractController {

	private final String id = getParamString("id");
	private UploadedFile file;

	private String[] selectedCategories;

	@Inject
	private NomenclatureDAO productDAO;

	@Inject
	private CategoryDAO categoryDAO;

	private Nomenclature product;

	@PostConstruct
	private void init() {
		product = id.isEmpty() ? new Nomenclature() : productDAO.getProductById(id);

		List<String> tmp = new ArrayList<>();
		for (Category category : product.getCategores()) {
			tmp.add(category.getId());
		}
		selectedCategories = new String[tmp.size()];
		selectedCategories = tmp.toArray(selectedCategories);

	}

	public Nomenclature getProduct() {
		return product;
	}

	public void setProduct(Nomenclature product) {
		this.product = product;
	}

	public String save() {
		List<Category> tmp = new ArrayList<>();
		for (String string : selectedCategories) {
			tmp.add(categoryDAO.getCategoryById(string));
		}

		if (id.isEmpty()) {
			productDAO.persist(product);
		}
		product.setCategores(tmp);
		productDAO.merge(product);

		return "listnomenclature";
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void fileUploadListener(FileUploadEvent e) {
		// Get uploaded file from the FileUploadEvent
		this.file = e.getFile();
		// Print out the information of the file
		System.out.println(
				"Uploaded File Name Is :: " + file.getFileName() + " :: Uploaded File Size :: " + file.getSize());
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File Uploaded Successfully"));
	}

	public String[] getSelectedCategories() {
		return selectedCategories;
	}

	public void setSelectedCategories(String[] selectedCategories) {
		this.selectedCategories = selectedCategories;
	}

}
