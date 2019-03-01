package com.guzichenko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.guzichenko.dao.ClientDao;
import com.guzichenko.dao.impl.ClientDBDao;
import com.guzichenko.dao.impl.ClientDaoImpl;
import com.guzichenko.services.ClientService;
import com.guzichenko.services.impl.ClientServiceImpl;
import com.guzichenko.validators.ValidationService;
import com.guzichenko.validators.impl.ValidationServiceImpl;
import com.guzichenko.view.AdminMenu;
import com.guzichenko.view.ClientMenu;
import com.guzichenko.view.MainMenu;

public class App {

	public static void main(String[] args) throws IOException {
		ClientDao clientDao = new ClientDBDao();
		ValidationService validationService = new ValidationServiceImpl();
		ClientService clientService = new ClientServiceImpl(clientDao, validationService);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		AdminMenu adminMenu = new AdminMenu(br, clientService);
		ClientMenu clientMenu = new ClientMenu(br, clientService);
		MainMenu menu = new MainMenu(br, adminMenu, clientMenu);
		menu.showMenu();
	}
}