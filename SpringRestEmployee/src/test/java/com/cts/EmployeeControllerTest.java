package com.cts;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.controller.EmployeeController;
import com.cts.model.Employee;
import com.cts.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	EmployeeService employeeService;

	@Test
	public void getEmployeeTest() throws Exception {
		mvc.perform(get("/employee/102").accept(MediaType.APPLICATION_JSON)).andDo(print())
//				.andExpect(jsonPath("$.name").value("Riya"))
		.andExpect(status().isOk());

		/*
		 * this cant be tested with jpa
		 * mvc.perform(get("/employee/105").accept(MediaType.APPLICATION_JSON)).andDo(
		 * print()) .andExpect(status().isNotFound());
		 */
	}

	@Test
	public void testAddEmployee() throws Exception {
		mvc.perform(post("/employee").content(convertObjectToJsonString(new Employee(0, "Smith", LocalDate.of(1995, 04, 21), "Trainer")))
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(status().isCreated());
	}

	public static String convertObjectToJsonString(Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
