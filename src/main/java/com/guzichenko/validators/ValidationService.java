package com.guzichenko.validators;

import com.guzichenko.exceptions.BusinessException;

public interface ValidationService {

	void validateAge(int age) throws BusinessException;

}