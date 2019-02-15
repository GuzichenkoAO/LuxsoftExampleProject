package com.guzichenko.services.impl;

import java.util.List;

import com.guzichenko.dao.ClientDao;
import com.guzichenko.domain.Client;
import com.guzichenko.exceptions.BusinessException;
import com.guzichenko.services.ClientService;
import com.guzichenko.validators.ValidationService;

public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao;
	private ValidationService validationService;

	public ClientServiceImpl(ClientDao clientDao, ValidationService validationService) {
		this.clientDao = clientDao;
		this.validationService = validationService;
	}

	@Override
	public void createClient(String name, String surname, String phone) {
		createClient(name, surname, 0, phone, null);
	}

	@Override
	public void createClient(String name, String surname, int age, String phone, String email) {
		try {
			validationService.validateAge(age);
			Client client = new Client(name, surname, age, email, phone);
			boolean result = clientDao.saveClient(client);
			if (result) {
				System.out.println("Client Saved: " + client);
			}
		}
		catch (BusinessException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Client> getAllClients() {
		return clientDao.getAllClients();
	}

	@Override
	public void deleteClient() {

	}
}
