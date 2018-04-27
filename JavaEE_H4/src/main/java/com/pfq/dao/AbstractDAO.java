package com.pfq.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO {

    @PersistenceContext(unitName = "pfq-persistence-unit")
    protected EntityManager em;

}