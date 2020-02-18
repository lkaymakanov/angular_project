package com.example.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class TransactionFilter implements Filter {
 
   
	@Override
	public void doFilter(ServletRequest request, javax.servlet.ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
		 HttpServletResponse res = (HttpServletResponse)response;
		 
		 res.addHeader("Access-Control-Allow-Credentials", "true");
		 res.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		 res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		 res.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
		/* res.getHttpHeaders().putSingle("Access-Control-Allow-Origin", "http://localhost:8000");
		 cresp.getHttpHeaders().putSingle("Access-Control-Allow-Credentials", "true");
		 cresp.getHttpHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		 cresp.getHttpHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");*/
	        //LOG.info
		 System.out.println(
	          "Starting a transaction for req : {}"+ 
	          req.getRequestURI());
	  
	        chain.doFilter(request, response);
	       /* LOG.info(
	          "Committing a transaction for req : {}", 
	          req.getRequestURI());*/
		
	}
 
    // other methods 
}