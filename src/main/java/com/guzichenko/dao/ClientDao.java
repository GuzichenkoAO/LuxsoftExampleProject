package com.guzichenko.dao;

import java.util.List;

import com.guzichenko.domain.Client;

public interface ClientDao {

	/**
	 * @param
	 * @throws
	 */
	boolean saveClient(Client client);

	Client findClient(long clientId);

	List<Client> getAllClients();

}