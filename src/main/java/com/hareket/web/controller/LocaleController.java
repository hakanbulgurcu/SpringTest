package com.hareket.web.controller;

import com.hareket.web.utils.JSFUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.util.Locale;

@Scope("session")
@Controller("localeBean")
public class LocaleController {

    private String language = "tr";

    @PostConstruct
    public void init() {
        this.language = JSFUtils.getExternalContext ().getRequestLocale().getLanguage ();
        System.out.println (language);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}