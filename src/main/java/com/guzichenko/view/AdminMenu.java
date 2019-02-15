package com.guzichenko.view;

import java.io.BufferedReader;
import java.io.IOException;

import com.guzichenko.domain.Client;
import com.guzichenko.services.ClientService;

public class AdminMenu {

	private final BufferedReader br;
	private final ClientService clientService;

	public AdminMenu(BufferedReader br, ClientService clientService) {
		this.br = br;
		this.clientService = clientService;
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
				case "4":
					System.out.println("All clients:");
					showAllClients();
					break;
				case "9":
					return;
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
		System.out.println("Input age: ");
		int age = readInteger();
		System.out.println("Input phone number: ");
		String phoneNumber = br.readLine();
		System.out.println("Input email: ");
		String email = br.readLine();
		clientService.createClient(name, surname, age, phoneNumber, email);
	}

	private void showMenu() {
		System.out.println("1. Add client");
		System.out.println("2. Modify client"); // by ID
		System.out.println("3. Remove client");
		System.out.println("4. List all clients");
		System.out.println();
		System.out.println("5. Add product");
		System.out.println("6. Modify product");
		System.out.println("7. Remove product");
		System.out.println("8. List all product");
		System.out.println();
		System.out.println("9. Modify order");
		System.out.println("10. Remove order");
		System.out.println("11. List all order");
		System.out.println();
		System.out.println("R. Return");
		System.out.println("E. Exit");
	}

	private int readInteger() {
		try {
			return Integer.parseInt(br.readLine());
		}
		catch (IOException | NumberFormatException ex) {
			System.out.println("Input number please!!");
			return readInteger();
		}
	}

	private void showAllClients() {
		for (Client client : clientService.getAllClients()) {
			System.out.println(client);
		}
	}

}
