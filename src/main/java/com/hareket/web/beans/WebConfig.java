package com.hareket.web.beans;

import com.hareket.web.config.ServletListener;
import com.hareket.web.config.SessionListener;
import com.hareket.web.filters.AuthorizationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

public class WebConfig {

    //Register SessionListener
    @Bean
    public ServletListenerRegistrationBean<SessionListener> sessionCountListener() {
        ServletListenerRegistrationBean<SessionListener> listenerRegBean = new ServletListenerRegistrationBean<>();
        listenerRegBean.setListener(new SessionListener());
        return listenerRegBean;
    }

    //Register ServletListener
    @Bean
    public ServletListenerRegistrationBean<ServletListener> adminInfoListener() {
        ServletListenerRegistrationBean<ServletListener> listenerRegBean = new ServletListenerRegistrationBean<>();
        listenerRegBean.setListener(new ServletListener());
        return listenerRegBean;
    }

    //Register AuthorizationFilter
    @Bean
    public FilterRegistrationBean<AuthorizationFilter> authrizationFilter() {
        FilterRegistrationBean<AuthorizationFilter> filterRegBean = new FilterRegistrationBean<> ();
        filterRegBean.setFilter(new AuthorizationFilter());
        filterRegBean.addUrlPatterns("/faces/*");
        filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE -1);
        return filterRegBean;
    }

}
