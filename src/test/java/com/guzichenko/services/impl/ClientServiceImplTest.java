package com.guzichenko.services.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.guzichenko.dao.ClientDao;
import com.guzichenko.domain.Client;
import com.guzichenko.services.ClientService;
import com.guzichenko.validators.ValidationService;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

	@Mock
	private ClientDao clientDao;

	private ValidationService validationService = Mockito.mock(ValidationService.class);

	private ClientService clientService;

	@Before
	public void init() {
		clientService = new ClientServiceImpl(clientDao, validationService);
	}

	@Test
	public void createClientWithFullParametersTest() {
		//GIVEN
		String name = "test";
		String surname = "test";
		int age = 10;
		String phone = "1234567890";
		String email = "test@test.com";

		//WHEN
		clientService.createClient(name, surname, age, phone, email);

		//THEN
	}

	@Test
	public void findClientTest() {
		//GIVEN
		long id = 1;
		String name = "test";
		String surname = "test";
		int age = 10;
		String phone = "1234567890";
		String email = "test@test.com";
		Client expectedClient = new Client(id, name, surname, age, phone, email);

		Mockito.when(clientDao.findClient(id)).thenReturn(expectedClient);

		//WHEN
		Client client = clientService.findClient(id);

		//THEN
		Mockito.verify(clientDao).findClient(id);
		Mockito.verifyNoMoreInteractions(clientDao);
		Assert.assertEquals(expectedClient, client);
	}

	@Test
	public void findClientWithNegateIdTest() {
		//GIVEN
		long id = -1;
		Mockito.when(clientDao.findClient(id)).thenReturn(null);

		//WHEN
		Client client = clientService.findClient(id);

		//THEN
		Mockito.verify(clientDao).findClient(id);
		Mockito.verifyNoMoreInteractions(clientDao);
		Assert.assertNull(client);
	}

	@After
	public void tearDawn() {
		clientService = null;
	}

}