package com.guzichenko.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.guzichenko.dao.ClientDao;
import com.guzichenko.domain.Client;

public class ClientDBDao implements ClientDao {

	private final String dbUrl;
	private final String login;
	private final String pass;

	public ClientDBDao(String dbUrl, String login, String pass) {
		this.dbUrl = dbUrl;
		this.login = login;
		this.pass = pass;

		try (Connection connection = DriverManager.getConnection(this.dbUrl, this.login, this.pass); Statement statement = connection
				.createStatement()) {
			statement.execute(
					"CREATE TABLE IF NOT EXISTS CLIENT(ID BIGINT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), SURNAME VARCHAR(20), AGE INT, PHONE VARCHAR(20), EMAIL VARCHAR(50));");
		}
		catch (SQLException e) {
			System.out.println("SOMETHING GOING WRONG!!!");
		}
	}

	@Override
	public boolean saveClient(Client client) {
		try (Connection connection = DriverManager.getConnection(dbUrl, login, pass);
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO CLIENT(NAME, SURNAME, AGE, PHONE, EMAIL) VALUES(?,?,?,?,?)")) {

			statement.setString(1, client.getName());
			statement.setString(2, client.getSurname());
			statement.setInt(3, client.getAge());
			statement.setString(4, client.getPhone());
			statement.setString(5, client.getEmail());
			return statement.execute();
		}
		catch (SQLException e) {
			System.out.println("SOMETHING GOING WRONG!!!");
		}
		return false;
	}

	@Override
	public Client findClient(long clientId) {
		try (Connection connection = DriverManager.getConnection(dbUrl, login, pass);
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM CLIENT WHERE ID=?")) {
			statement.setLong(1, clientId);
			try (ResultSet resultSet = statement.executeQuery()) {
				resultSet.next();
				long id = resultSet.getLong(1);
				String name = resultSet.getString(2);
				String surname = resultSet.getString("SURNAME");
				int age = resultSet.getInt("AGE");
				String phone = resultSet.getString(5);
				String email = resultSet.getString(6);
				return new Client(id, name, surname, age, phone, email);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CLIENT DIDN'T FIND!!!");
		}
		return null;
	}

	@Override
	public List<Client> getAllClients() {
		List<Client> result = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(dbUrl, login, pass);
				Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery("SELECT * FROM CLIENT")) {
				while (resultSet.next()) {
					long id = resultSet.getLong(1);
					String name = resultSet.getString(2);
					String surname = resultSet.getString("SURNAME");
					int age = resultSet.getInt("AGE");
					String phone = resultSet.getString(5);
					String email = resultSet.getString(6);
					result.add(new Client(id, name, surname, age, phone, email));
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("CLIENT DIDN'T FIND!!!");
		}
		return result;
	}
}
