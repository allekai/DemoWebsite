package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Admin") String name, Model model) {
		model.addAttribute("name", name);
		return "nav/greeting";
	}
	
	@GetMapping("/gruppen")
	public String gruppen(@RequestParam(name="group", required = false, defaultValue = "Adler") String group, Model model) {
		model.addAttribute("group", group);
		return "nav/gruppen";
	}
		
	@GetMapping("/fahrten")
	public String fahrten(@RequestParam(name="fahrt", required = false, defaultValue = "Sofa2020") String fahrt, Model model) {
		model.addAttribute("fahrt", fahrt);
		return "nav/fahrten";
	}
}
