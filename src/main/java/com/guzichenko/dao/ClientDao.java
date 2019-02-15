package com.guzichenko.dao;

import java.util.List;

import com.guzichenko.domain.Client;

public interface ClientDao {

	/**
	 *
	 */
	boolean saveClient(Client client);

	List<Client> getAllClients();

}