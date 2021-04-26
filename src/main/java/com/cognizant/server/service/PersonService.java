package com.cognizant.server.service;

import java.util.Map;

import com.cognizant.server.model.Person;


public interface PersonService {
	
	Map<Long,Person>getPersonsDetails();
	Person getPersonByAadharNo(long aadharNo);
	Person addPersonDetail(Person person);
	Person removePersonByAadharNo(long aadharNo);
	Person updatePersonDetails(Person person);
    boolean isValidAadharNo(long aadharNo);

}
