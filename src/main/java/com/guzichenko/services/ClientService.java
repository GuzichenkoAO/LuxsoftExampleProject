package com.guzichenko.services;

import java.util.List;

import com.guzichenko.domain.Client;

public interface ClientService {

	/**
	 * add documentation
	 */
	void createClient(String name, String surname, String phone);

	void createClient(String name, String surname, int age, String phone, String email);

	List<Client> getAllClients();

	void deleteClient();

}