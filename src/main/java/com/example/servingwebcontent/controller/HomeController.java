package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.tools.javac.util.List;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Unknown") String name, Model model) {
		model.addAttribute("name", name);
		return "home";
	}
	
	@GetMapping("/home")
	public String home(@RequestParam(name="name", required=false, defaultValue="Unknown") String name, Model model) {
		model.addAttribute("name", name);
		return "redirect:/";
	}

}