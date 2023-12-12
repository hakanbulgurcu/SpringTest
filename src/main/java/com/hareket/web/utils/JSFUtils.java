package com.hareket.web.utils;

import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class JSFUtils {

    public static ExternalContext getExternalContext() {
        return (ExternalContext) FacesContext.getCurrentInstance().getExternalContext ();
    }

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    public static String getUserName() {
        HttpSession session = getSession();
        return session.getAttribute("userCode").toString();
    }

    public static UIViewRoot getViewRoot() {
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        if (viewRoot != null)
            return viewRoot;
        else
            return null;
    }

}
