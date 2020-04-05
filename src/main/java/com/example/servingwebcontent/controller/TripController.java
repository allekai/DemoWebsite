package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TripController {
	
	@GetMapping("/fahrten")
	public String fahrten(@RequestParam(name="fahrt", required = false, defaultValue = "Sofa2020") String fahrt, Model model) {
		model.addAttribute("fahrt", fahrt);
		return "mainMenu/fahrten";
	}
	
}
