package com.pfq.helper;

import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.context.FacesContext;

public class HiddenPageViewHandler extends ViewHandlerWrapper {

    private static final String WEB_INF = "/jsf";
    private static final String XHTML = ".xhtml";

    private ViewHandler parent;

    public HiddenPageViewHandler(ViewHandler parent) {
        this.parent = parent;
    }

    @Override
    public String getActionURL(FacesContext context, String viewId) {
        String actionUrl = super.getActionURL(context, viewId);

        if (actionUrl != null && actionUrl.contains(WEB_INF)) {
            actionUrl = actionUrl.replace(WEB_INF, "");
        } 
        
        if (actionUrl != null && actionUrl.contains(XHTML)) {
            actionUrl = actionUrl.replace(XHTML, "");
        }

        return actionUrl;
    }

    @Override
    public ViewHandler getWrapped() {
        return parent;
    }

}