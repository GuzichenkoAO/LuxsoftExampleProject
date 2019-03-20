package com.guzichenko.services;

import java.util.List;

import com.guzichenko.domain.Client;

public interface ClientService {

	/**
	 * add documentation
	 */
	void createClient(String name, String surname, String phone);

	void createClient(String name, String surname, int age, String phone, String email);

	Client findClient(long clientId);

	void modifyClient(long clientId, String newName, String newSurname, int newAge, String newPhone, String newEmail);

	List<Client> getAllClients();

	void deleteClient(long id);
}