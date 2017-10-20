package com.lxt.common.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

public class CrossDomainFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "http://192.168.43.185:8888");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		response.setCharacterEncoding("UTF-8");
		filterChain.doFilter(request, response);
	}
}