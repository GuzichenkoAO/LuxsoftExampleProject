package com.guzichenko.view;

import java.io.BufferedReader;
import java.io.IOException;

import com.guzichenko.services.ClientService;

abstract public class AbstractMenu {

	protected final BufferedReader br ;
	protected final ClientService clientService;

	protected AbstractMenu(BufferedReader br, ClientService clientService) {
		this.br = br;
		this.clientService = clientService;
	}

	abstract void show() throws IOException;

	protected int readInteger() {
		try {
			return Integer.parseInt(br.readLine());
		}
		catch (IOException | NumberFormatException ex) {
			System.out.println("Input number please!!");
			return readInteger();
		}
	}

}