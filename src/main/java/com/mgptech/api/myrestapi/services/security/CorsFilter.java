package com.mgptech.api.myrestapi.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {



    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Credentials","true");

        if("OPTIONS".equals(request.getMethod())){
            response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,PUT,PATCH,DELETE");
            response.setHeader("Access-Control-Allow-Headers", "Authorizations, Content-Type, Accept");
            response.setHeader("Access-Control-Max-Age","3600");

            response.setStatus(HttpServletResponse.SC_OK);

        }else {
            chain.doFilter(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
