package com.justachallenge.criptos.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.justachallenge.criptos.dto.LoginDTO;

/**
* Classe para configurações do JWT
**/

public class JWTAuthFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authManager;

	private JWTUtil jwtUtil;

	public JWTAuthFilter(AuthenticationManager authManager, JWTUtil jwtUtil) {
		setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
		this.authManager = authManager;
		this.jwtUtil = jwtUtil;
		

	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp)
			throws AuthenticationException {

		try {
			LoginDTO credencials = new ObjectMapper().readValue(req.getInputStream(), LoginDTO.class);

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
					credencials.getUsername(), credencials.getPassword(), new ArrayList<>());

			Authentication auth = authManager.authenticate(authToken);
			return auth;
		}

		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse resp, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String username = ((UserSS) auth.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username);
		
		resp.addHeader("Authorization", "Bearer " + token);
	}

	
	private class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler 	{
		 @Override
	        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
	                throws IOException, ServletException {
	            response.setStatus(401);
	            response.setContentType("application/json"); 
	            response.getWriter().append(json());
	        }
	        
	        private String json() {
	            long date = new Date().getTime();
	            return "{\"timestamp\": " + date + ", "
	                + "\"status\": 401, "
	                + "\"error\": \"Unauthorized\", "
	                + "\"message\": \"Username or password doesn't match\", "
	                + "\"path\": \"/login\"}";
	        }
		
	}
}
