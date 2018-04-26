package com.pfq.controller;

import com.pfq.dao.ProductDAO;
import com.pfq.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ViewScoped
@ManagedBean
public class TestController {

    @Inject
    private ProductDAO productDAO;

    public void removeProduct(Product product) {
        productDAO.removeProduct(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(productDAO.getListProduct());
    }

    public void addProduct() {
        productDAO.persist(new Product());
    }

    public String test() {
        System.out.println("TEST");
        return "mega";
    }

}
