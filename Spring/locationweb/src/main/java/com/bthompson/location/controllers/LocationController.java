package com.bthompson.location.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bthompson.location.entities.Location;
import com.bthompson.location.service.LocationService;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LocationController {
	
	@Autowired
	LocationService service;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelmap) {
		Location locationSaved = service.saveLocation(location);
		String msg = "Location saved with id: "+ locationSaved.getId();
		modelmap.addAttribute("msg", msg);
		return "createLocation";
	}
}
