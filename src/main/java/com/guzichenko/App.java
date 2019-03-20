package com.guzichenko;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guzichenko.view.MainMenu;

public class App {

	public static void main(String[] args) throws IOException {
		//		ClientDao clientDao = new ClientDBDao();
		//		ValidationService validationService = new ValidationServiceImpl();
		//		ClientService clientService = new ClientServiceImpl(clientDao, validationService);
		//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//		AdminMenu adminMenu = new AdminMenu(br, clientService);
		//		ClientMenu clientMenu = new ClientMenu(br, clientService);
		//		MainMenu menu = new MainMenu(br, adminMenu, clientMenu);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
		MainMenu menu = (MainMenu) context.getBean("menu");
		menu.showMenu();
	}
}