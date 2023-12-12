package com.hareket.web.filters;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Order(Ordered.HIGHEST_PRECEDENCE)
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*", "*.xhtml"})
public class AuthorizationFilter implements Filter {

	public AuthorizationFilter() {
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession session = reqt.getSession(false);
			System.out.println ("Request Context Path : " + reqt.getContextPath ());

			String reqURI = reqt.getRequestURI();
            System.out.println ("RequestURI : " + reqt.getRequestURI ());

            if (reqURI.indexOf("/login.xhtml") >= 0
				|| (session != null && session.getAttribute("activeUser") != null)
				|| reqURI.indexOf("/public/") >= 0
				|| reqURI.contains("javax.faces.resource")) {
				//Eğer zaten giriş yapmış ise login sayfasına gitmek istiyor ise 
				//main'e yönlendirilmeli logout yaptığına login'e gidebilmeli..
				chain.doFilter(request, response);
			} else {
				resp.sendRedirect(reqt.getContextPath() + "/resources/faces/login.xhtml");
			}
		} catch (Exception e) {
            Logger.getGlobal().log (Level.SEVERE, e.getMessage (), e);
		}
	}

	@Override
	public void destroy() {

	}
}
