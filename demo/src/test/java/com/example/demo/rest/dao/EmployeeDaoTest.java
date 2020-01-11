package com.example.demo.rest.dao;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.rest.model.Employees;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoTest {

	@Autowired
	EmployeeDao empDao;
	
	@Test
	public void getAllEmployeesTest() {
		
		Employees actualList = empDao.getAllEmployees();
		assertThat(actualList).isNotNull();
		
	}
	
	@Test
	public void failTest() {
		assertThat("Hola").isNotEqualTo("Hola");
	}
	
	
	
}
