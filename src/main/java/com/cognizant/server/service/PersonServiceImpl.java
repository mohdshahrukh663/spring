package com.cognizant.server.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cognizant.server.model.Person;


@Service
public class PersonServiceImpl implements PersonService {
	
	Map<Long,Person>personsDetails;
	
	public PersonServiceImpl() throws ParseException
	{
		//Instantiating the map
		personsDetails=new HashMap<Long,Person>();
		//Adding new persons details to the map
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		//Creating a new 'Person'	object	
		Person person=new Person("Debopama","female",sdf.parse("06/05/1998"));
		//Adding the new 'Person' object to the map
		personsDetails.put(person.getAadharNo(),person);
		person=new Person("Mohit","male",sdf.parse("03/18/1999"));
		personsDetails.put(person.getAadharNo(),person);
		person=new Person("Sanyam","male",sdf.parse("10/22/1999"));
		personsDetails.put(person.getAadharNo(),person);
		person=new Person("Muskan","female",sdf.parse("09/17/1998"));
		personsDetails.put(person.getAadharNo(),person);
	}
	
	public boolean isValidAadharNo(long aadharNo)
	{
		boolean b=false;
		for(long adno:personsDetails.keySet())
		{
			if(aadharNo==adno)
			{
				b=true;
			}
		}
		return b;
		
	}

	public Map<Long,Person>getPersonsDetails()
	{
		//returning the map
		return personsDetails;
	}
	public Person getPersonByAadharNo(long aadharNo)
	{
		return personsDetails.get(aadharNo);
	}
	public Person addPersonDetail(Person person)
	{
		//Adding the 'Person' object received to te map
		personsDetails.put(person.getAadharNo(), person);
		return person;
		
	}
	public Person removePersonByAadharNo(long aadharNo)
	{
		Person person=personsDetails.get(aadharNo);
		personsDetails.remove(aadharNo);
		return person;
		
	}
	public Person updatePersonDetails(Person person)
	{
		personsDetails.put(person.getAadharNo(), person);
		return person;
	}

}
