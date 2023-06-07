package com.cognizant.springlearn;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.springlearn.controller.CountryController;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private CountryController countryController;

	@Test
	void contextLoads() {
		assertNotNull(countryController);
	}

	@Test
	public void testGetCountry() throws Exception {
		ResultActions actions = mvc.perform(get("/country"));

		// to check if the HTTP Status is 200, which means the call is successful
		actions.andExpect(status().isOk());

		// to check if the code is available in the response
		actions.andExpect(jsonPath("$.code").exists());

		// to check if the value of code is "IN"
		actions.andExpect(jsonPath("$.code").value("IN"));

		actions.andExpect(jsonPath("$.name").value("India"));
	}

	@Test
	public void testGetCountryException() throws Exception {
//		String exceptionParam = "dummy";
		mvc.perform(get("/countries/in").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		mvc.perform(get("/countries/az").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
//		ResultActions actions = mvc.perform(get("/countries/{code}"));
//		ClassNotFoundException exception= Assertions.assertThrows(ClassNotFoundException.class, new Executable() {
//			 @Override
//		        public void execute() throws Throwable {
//				 	actions.andExpect(status().isBadRequest());
//				 	actions.andExpect(status().reason("Country Not found"));
//			 	}
//		    });
//			 
		
		 
	}

}
