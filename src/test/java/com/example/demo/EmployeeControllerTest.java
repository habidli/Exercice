package com.example.demo;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.Service.EmployeeService;
import com.example.demo.controller.EmployeeController;
//déclenche le mécanisme permettant de tester les controllers. On indique également le ou les controllers concernés.
@WebMvcTest(controllers = EmployeeController.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class EmployeeControllerTest {

	//L’attribut mockMvc est un autre élément important. Il permet d’appeler la méthode “perform” qui déclenche la requête.
	@Autowired
	private MockMvc mockMvc;
	
	//L’attribut employeeService est annoté @MockBean. Il est obligatoire, car la méthode du controller exécutée par l’appel de “/employees” utilise cette classe.
	@MockBean
	private EmployeeService employeeService;
	
	//La méthode perform prend en paramètre l’instruction get(“/employees”). On exécute donc une requête GET sur l’URL /employees.Ensuite, l’instruction .andExpect(status().isOk()) indique que nous attendons une réponse HTTP 200. 
	@Test
	public void testGetEmployees() throws Exception {
		mockMvc.perform(get("/employees"))
		.andExpect(status().isOk());
		//.andExpect(jsonPath("$[0].firstName", is("Laurent")));
		
	}
}
