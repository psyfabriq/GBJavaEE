package com.pfq.manager;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class TestManager {

    public Date getDate() {
        return new Date();
    }

}
