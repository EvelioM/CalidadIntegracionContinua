package com.example.demo.rest.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.rest.model.Employees;

@SpringBootTest
public class EmployeeDaoTest {

	@Autowired
	EmployeeDao empDao;
	
	@Test
	public void getAllEmployeesTest() {
		
		Employees actualList = empDao.getAllEmployees();
		assertNotNull("Not null", actualList);
		
	}
	
	@Test
	public void failTest() {
		assertEquals("Hola", "Adios");
	}
	
	
	
}
