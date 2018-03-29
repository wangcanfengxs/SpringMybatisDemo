package com.netease.wcf.demo.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebFilter(urlPatterns = {"/publish", "/cart", "/account", "/api/buy", "/api/delete", "/edit", "/editSubmit",
        "/api/upload", "/publishSubmit"})
public class SessionTimeOutRedirectFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(SessionTimeOutRedirectFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if (httpRequest.getSession().getAttribute("user") != null) {
            chain.doFilter(httpRequest, httpResponse);
        } else {
            LOGGER.info("session is timeout." + httpRequest.getRequestURI());
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
        }
    }

    public void destroy() {

    }

}
