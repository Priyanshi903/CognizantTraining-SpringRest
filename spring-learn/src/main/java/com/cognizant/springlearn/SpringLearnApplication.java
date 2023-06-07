package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan("com.*")
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	private static void displayDate() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat simpleDateFormat = context.getBean("dateFormat", SimpleDateFormat.class);
		
		Date date;
		try {
			date = simpleDateFormat.parse("31/12/2018");
//			System.out.println(date);
			LOGGER.debug("Date:{}",date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		LOGGER.info("END");
		
	}
	
	private static void displayCountry() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", anotherCountry.toString());
		LOGGER.info("END");
	}
	
	private static void displayCountries() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries=(List<Country>) context.getBean("countryList");
		LOGGER.debug("Countries : {}", countries);
		LOGGER.info("END");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("MAIN STARTED---------------------------------------------");
//		displayDate();
//		displayCountry();
//		displayCountries();

	}

}
