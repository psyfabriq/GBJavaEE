package com.pfq.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import com.pfq.entity.Category;

@ApplicationScoped
public class CategoryDAO extends AbstractDAO {

    private final Map<String, Category> categores = new LinkedHashMap<>();
    
    

    public CategoryDAO() {
		Category catAll = new Category(true);
		categores.put(catAll.getId(), catAll);
	}

	public Collection<Category> getListCategores() {
        return categores.values();
    }

    public void persist(Category category) {
        if (category == null) return;
        categores.put(category.getId(), category);
    }

    public Category getCategoryById(String id) {
        if (id == null) return null;
        return categores.get(id);
    }

    public void merge(Category category) {
        if (category == null) return;
        categores.put(category.getId(), category);
    }

    public void removeCategory(Category category) {
        if (category == null) return;
        categores.remove(category.getId());
    }

}
