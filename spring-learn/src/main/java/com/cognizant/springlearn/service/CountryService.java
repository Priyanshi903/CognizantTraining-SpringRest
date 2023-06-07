package com.cognizant.springlearn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Repository
public class CountryService {

	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

	public Country getCountryIndia() {

		Country country = (Country) context.getBean("in");
		return country;
	}

	public List<Country> getAllCountries() {
		List<Country> countries = (List<Country>) context.getBean("countryList");
		return countries;

	}

	public Country getCountry(String code) throws CountryNotFoundException {
		List<Country> countries = getAllCountries();
		Country country=countries.stream().filter(c->c.getCode().equalsIgnoreCase(code)).findAny().orElse(null);
		if(country==null) {
			throw new CountryNotFoundException();
			}
		return countries.get(0);
	}

	public void addCountry(Country country) {
		getAllCountries().add(country);
		
	}

}

