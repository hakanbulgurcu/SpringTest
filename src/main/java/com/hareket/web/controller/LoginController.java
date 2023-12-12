package com.hareket.web.controller;

import com.hareket.web.model.User;
import com.hareket.web.services.UserService;
import com.hareket.web.utils.JSFUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@Scope("session")
@Controller(value = "loginBean")
public class LoginController {

    @Autowired
    UserService service;

    private User user = new User ();

    public String login() {
        HttpSession session = JSFUtils.getSession();

        user = service.checkLogin (user.getCode (), user.getPassword ());

        if (user != null) {
            System.out.println (user.getName ());
            session.setAttribute("activeUser", user);
            return "main?faces-redirect=true";
        } else {
            session.setAttribute("activeUser", null);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Kullanıcı adı veya şifre geçerli değil", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "login?faces-redirect=true";
        }
    }

    public String logout() {
        HttpSession session = JSFUtils.getSession();
        session.invalidate();
        return "login?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }

}
