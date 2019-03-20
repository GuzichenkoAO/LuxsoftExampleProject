package com.guzichenko.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.guzichenko.dao.ClientDao;
import com.guzichenko.dao.impl.ClientDBDao;
import com.guzichenko.services.impl.ClientServiceImpl;
import com.guzichenko.validators.ValidationService;
import com.guzichenko.validators.impl.ValidationServiceImpl;

@WebListener
public class WebApp implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ClientDao clientDao = new ClientDBDao();
		ValidationService validationService = new ValidationServiceImpl();
		ClientServiceImpl clientService = new ClientServiceImpl(clientDao, validationService);

		ServletContext servletContext = sce.getServletContext();
		servletContext
				.addServlet("ClientServlet", new ClientServlet(clientService))
				.addMapping("/clients/*");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
