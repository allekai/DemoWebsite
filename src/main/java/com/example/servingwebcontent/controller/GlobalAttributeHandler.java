package com.example.servingwebcontent.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sun.tools.javac.util.List;

@ControllerAdvice
public class GlobalAttributeHandler {
	
	/*
	 * TODO AP: Make this dynamic --> read from some config file maybe?
	 * Somewhat similar to Django's register functionality.
	 * Would be nice to have this inside an admin view 
	 */
	@ModelAttribute("menuEntries")
	public List<String> menuEntries() {
		List<String> ret = List.of("home", "gruppen", "fahrten");
		return ret;
	}
	
	@ModelAttribute("groups")
	public List<String> groups() {
		List<String> ret = List.of("Adler", "Grizzlys", "Orcas");
		return ret;
	}
	
	@ModelAttribute("trips")
	public List<String> trips() {
		List<String> ret = List.of("Sommerfahrt", "Winterfahrt", "Frühjahrsfahrt");
		return ret;
	}

}
