package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gruppen")
public class GroupController {

	@RequestMapping
	public String groupsIndex() {
		return "mainMenu/groups/groupsIndex";
	}
	
	@GetMapping("/{scoutGroup}")
	public String getScoutGroup(@PathVariable String scoutGroup) {
		return "mainMenu/groups/".concat(scoutGroup.toLowerCase());
	}	
	
}
