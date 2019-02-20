package com.guzichenko.view;

import java.io.BufferedReader;
import java.io.IOException;

import com.guzichenko.services.ClientService;

public class ClientMenu extends AbstractMenu {

	public ClientMenu(BufferedReader br, ClientService clientService) {
		super(br, clientService);
	}

	public void show() throws IOException {
		while (true) {
			showMenu();
			switch (br.readLine()) {
				case "1":
					createClient();
					break;
				case "2":
					System.out.println("Modify client");
					break;
				case "0":
					System.exit(0);
				default:
					System.out.println("Wrong input!!!");
					break;
			}
		}
	}

	private void createClient() throws IOException {
		System.out.println("Input name: ");
		String name = br.readLine();
		System.out.println("Input surname: ");
		String surname = br.readLine();
		System.out.println("Input phone number: ");
		String phoneNumber = br.readLine();
		clientService.createClient(name, surname, phoneNumber);
	}

	private void showMenu() {
		System.out.println("1. Register");
		System.out.println("2. Modify"); //by ID
		System.out.println();
		System.out.println("3. List products");
		System.out.println("4. Add order");
		System.out.println("5. List orders");
		System.out.println();
		System.out.println("R. Return");
		System.out.println("E. Exit");
	}

}