package com.cognizant.server.controller;



import java.util.Map;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.server.model.Person;
import com.cognizant.server.service.PersonService;
import com.cognizant.server.validations.CheckValidAdhaar;


@RestController
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@GetMapping(path="/getpersonsdetails")
	public Map<Long,Person>getPersonsDetails()
	{
		return service.getPersonsDetails();
		
	}
	
	@GetMapping(path="/getpersonbyaadhar/{aadharNo}")
	public Person getPersonByAadhar(@PathVariable long aadharNo) throws CheckValidAdhaar 
	
	{
		if(service.isValidAadharNo(aadharNo))
		{
		return service.getPersonByAadharNo(aadharNo);
		}
		else
		{
			throw new CheckValidAdhaar("Adhaar not found");
		}
	}
		
	
	
    @PostMapping(path="/addperson")
	public Person addPerson(@RequestBody Person person)
	{
    	
		return service.addPersonDetail(person);
	}
    
    @DeleteMapping(path="/deletepersonbyaadhar/{aadharNo}")
    public Person deletePersonbyAadhar(@PathVariable long aadharNo) throws CheckValidAdhaar
    {
    	if(service.isValidAadharNo(aadharNo))
		{
    		return service.removePersonByAadharNo(aadharNo);
		}
		else
		{
			throw new CheckValidAdhaar("Adhaar not found");
		}
    	
    }
    
    @PutMapping("/updatepersondetails/{aadharNo}")
    public Person updatePersonDetails(@PathVariable Long aadharNo,@RequestBody Person person) throws CheckValidAdhaar
    {
    	if(service.isValidAadharNo(aadharNo))
		{
    		Person p=new Person();
            p=service.getPersonByAadharNo(aadharNo);
        	p.setName(person.getName());
        	p.setGender(person.getGender());
        	p.setDob(person.getDob());
        	return service.updatePersonDetails(p);
		}
		else
		{
			throw new CheckValidAdhaar("Adhaar not found");
		}
  	
    }
    
    @GetMapping("/jasontoxml")
    public String jasonToXml()
    {
    	JSONObject json = new JSONObject(service.getPersonsDetails());
    	String xml = XML.toString(json);
    	return xml;
    }
    
    
    
    
}
