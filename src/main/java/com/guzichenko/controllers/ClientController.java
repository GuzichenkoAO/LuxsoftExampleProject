package com.guzichenko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guzichenko.services.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping()
	public String showClients(ModelMap modelMap) {
		modelMap.put("message", clientService.getAllClients());
		return "clients";
	}

	@PostMapping()
	public void showClients(
			@RequestParam String name,
			@RequestParam String surname,
			@RequestParam String phone) {
		clientService.createClient(name, surname, phone);

	}

}