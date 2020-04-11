package com.example.servingwebcontent.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.servingwebcontent.entity.User;

@Controller
public class UserController {
	
    @Autowired
    private HttpServletRequest request;
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String handleLogoutt() throws ServletException {
        request.logout();
        return "redirect:/";
    }

	@GetMapping("/login")
	public String getUserLogin(Model model) {
		configCommonAttributes(model);
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();        
        KeycloakPrincipal principal=(KeycloakPrincipal)token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();

		if (accessToken.getRealmAccess().getRoles().contains("ADMIN")) {
			System.out.println("ADMIN");
			return "redirect:/admin";
		} else if (accessToken.getRealmAccess().getRoles().contains("USER")) {
			System.out.println("USER");
			return "redirect:/user";
		}
		return "/";
		
	}
			
	public Object getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getPrincipal();
	}
	/*
	@GetMapping("/user")
	public String userPage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("userName", auth.getName());
		return "user/user";
	}*/
	
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String handleProtectedUser(Model model) {
        configCommonAttributes(model);
        return "user/user";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String handleProtectedAdmin(Model model) {
        configCommonAttributes(model);
        return "admin/admin";
    }

    private void configCommonAttributes(Model model) {
        model.addAttribute("user", new User(getKeycloakSecurityContext()));
    }

    private KeycloakSecurityContext getKeycloakSecurityContext() {
        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
    }
}