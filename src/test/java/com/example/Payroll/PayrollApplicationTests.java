package com.example.Payroll;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.net.URI;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@SpringBootTest
class PayrollApplicationTests {
	
    private static RestTemplate restTemplate;
    
    private static final String EmployeeUrl = "http://localhost:" + "8081" + "/employees";
    
    @Before
    public static void runBeforeAllTestMethods() throws JSONException {
    	
    	restTemplate = new RestTemplate();
    }

	@Test
	void contextLoads() {
	   // Assertions.assertNotNull(restClient);
		restTemplate = new RestTemplate();
	    Assertions.assertNotNull(restTemplate);
	}
	
	// GET
    @Test
    public void givenResourceUrl_whenRetrievingResource_thenCorrect() throws IOException {
    	restTemplate = new RestTemplate();
        final Employee _employee = restTemplate.getForObject(EmployeeUrl + "/3", Employee.class);

        System.out.println("********************** _employee Name: "+_employee.getName());
        System.out.println("********************** _employee ID: "+_employee.getId());
        System.out.println("********************** _employee Role: "+_employee.getRole());
        
        
        Assertions.assertNotNull(_employee.getName());
        Assertions.assertEquals(_employee.getId(), 3L);
    }
    
    // POST
    @Test
    public void givenFooService_whenPostForObject_thenCreatedObjectIsReturned() {
    	restTemplate = new RestTemplate();
        final HttpEntity<Employee> request = new HttpEntity<>(new Employee("Sam", "wise23", "gardener23"));
        final Employee _employee = restTemplate.postForObject(EmployeeUrl, request, Employee.class);
        
        Assertions.assertNotNull(_employee);
        Assertions.assertEquals(_employee.getName(), "Samwise23");
    }
    
    @Test
    public void givenFooService_whenPostForLocation_thenCreatedLocationIsReturned() {
    	restTemplate = new RestTemplate();
        final HttpEntity<Employee> request = new HttpEntity<>(new Employee("Sam", "wise24", "gardener24"));
        final URI location = restTemplate.postForLocation(EmployeeUrl, request, Employee.class);
        
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&& location: "+location);
        //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&& location: "+location.toString());
        //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&& location: "+location.getHost());
        //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&& location: "+location.getPath());
        
        Assertions.assertNotNull(location);
    }

}
