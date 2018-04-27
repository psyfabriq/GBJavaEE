package com.pfq.controller;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController {

    protected String getParamString(String paramName) {
    	String result = getHttpServletRequest().getParameter(paramName)!=null?getHttpServletRequest().getParameter(paramName):"";
        return result;
    }

    public HttpServletRequest getHttpServletRequest() {
        final FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest) context.getExternalContext().getRequest();
    }

}
