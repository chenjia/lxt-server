package com.lxt.common.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.lxt.common.bean.Request;
import com.lxt.common.bean.Response;
import com.lxt.common.utils.CheckUtils;
import com.lxt.common.utils.JWTUtils;
import com.lxt.controller.BaseController;

public class AuthFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		Request req = BaseController.getRequest(request);
		String userId = req.getHead().getUserId();
		if (CheckUtils.isNotEmpty(userId)) {
			Map<String, String> claimMap = new HashMap<String, String>();
			claimMap.put("userId", userId);
			boolean b = JWTUtils.unsign(req.getHead().getToken(), claimMap);
			if (b) {
				filterChain.doFilter(request, response);
			} else {
				response.setContentType("application/json;charset=utf-8");
				Response resp = new Response();
				resp.getHead().setStatus(500);
				resp.getBody().setData("token验证失败！");
				response.getWriter().write(resp.toJson());
				response.getWriter().flush();
				response.getWriter().close();
			}
		}else {
			filterChain.doFilter(request, response);
		}
	}
}