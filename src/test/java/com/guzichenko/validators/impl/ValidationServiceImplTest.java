package com.guzichenko.validators.impl;

import org.junit.Before;
import org.junit.Test;

import com.guzichenko.exceptions.BusinessException;
import com.guzichenko.validators.ValidationService;

public class ValidationServiceImplTest {

	private ValidationService validationService;

	@Before
	public void setUp() {
		validationService = new ValidationServiceImpl();
	}

	@Test
	public void validateAge() throws BusinessException {
		//WHEN
		int age = 50;
		validationService.validateAge(age);
	}

	@Test(expected = BusinessException.class)
	public void validateWrongAge() throws BusinessException {
		//WHEN
		int age = 201;
		validationService.validateAge(age);
	}
}