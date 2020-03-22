package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GroupController {

	@GetMapping("/gruppen")
	public String gruppen(@RequestParam(name="group", required = false, defaultValue = "Adler") String group, Model model) {
		model.addAttribute("group", group);
		return "mainMenu/gruppen";
	}

}
