package com.guzichenko.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guzichenko.domain.Client;
import com.guzichenko.services.ClientService;

public class ClientServlet extends HttpServlet {

	private ClientService clientService;

	public ClientServlet(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pathInfo = req.getPathInfo();

		if ("/delete".equals(pathInfo)) {
			doDelete(req, resp);
			return;
		}
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		for (Client client : clientService.getAllClients()) {
			writer.println("<h2>" + client + "</h2>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String age = req.getParameter("age");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		clientService.createClient(name, surname, Integer.parseInt(age), phone, email);
		doGet(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		clientService.deleteClient(Long.parseLong(id));
	}
}