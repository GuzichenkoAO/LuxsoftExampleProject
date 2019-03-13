package com.guzichenko.domain;

import java.util.Objects;

public class Client {

	private long id;
	private String name;
	private String surname;
	private int age;
	private String email;
	private String phone;

	public Client(String name, String surname, String phone) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
	}

	public Client(String name, String surname, int age, String email, String phone) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}

	public Client(long id, String name, String surname, int age, String email, String phone) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Client{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", age=" + age +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Client client = (Client) o;
		return getId() == client.getId() &&
				getAge() == client.getAge() &&
				Objects.equals(getName(), client.getName()) &&
				Objects.equals(getSurname(), client.getSurname()) &&
				Objects.equals(getEmail(), client.getEmail()) &&
				Objects.equals(getPhone(), client.getPhone());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getSurname(), getAge(), getEmail(), getPhone());
	}
}