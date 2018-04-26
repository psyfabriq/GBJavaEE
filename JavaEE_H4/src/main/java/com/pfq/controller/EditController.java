package com.pfq.controller;

import com.pfq.dao.ProductDAO;
import com.pfq.entity.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class EditController extends AbstractController {

    private final String id = getParamString("id");

    @Inject
    private ProductDAO productDAO;

    private Product product;

    @PostConstruct
    private void init() {
        product = productDAO.getProductById(id);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String save() {
        productDAO.merge(product);
        return "test";
    }

}
