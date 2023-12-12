package com.hareket.web;

import com.hareket.web.config.ApplicationInitializer;
import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication(scanBasePackages = "com.hareket.web")
@Configuration
@EnableJpaRepositories("com.hareket.web.repository")
@EnableScheduling
@EnableAspectJAutoProxy
@ServletComponentScan
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run (WebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(
                new Class[] { WebApplication.class, ApplicationInitializer.class});
    }

    //JSF Configration Başlangıc
    @Bean
    public ServletRegistrationBean<FacesServlet> facesServletRegistraiton() {
        ServletRegistrationBean<FacesServlet> registration =
                new ServletRegistrationBean<FacesServlet>(new FacesServlet(), new String[] { "*.xhtml", "*.jsf", "*.png"});
        registration.setName("Faces Servlet");
        registration.setLoadOnStartup(1);

        return registration;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
            //Primefacesin ücretsiz temalarından bootstrap örneği yaptık değiştirebilirsiniz
            servletContext.setInitParameter("primefaces.THEME", "redmond");
            //Primefaces client browser tarafında kontrol edilebilme örneğin textbox 10 karakter olmalı vs..
            servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
            //Xhtml sayfalarında commentlerin parse edilmemesi.
            servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
            //primefaces icon set için
            servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
        };
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
    }
    //JSF Configration Sonu
}
