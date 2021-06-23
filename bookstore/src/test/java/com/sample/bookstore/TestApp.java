package com.sample.bookstore;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TestApp extends BookstoreApplicationTests {

	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	
	
	
	
	
	/* private void testDOW(String birthday, String dow) throws Exception {
	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/test/{test}","hello")
	                .content(birthday)
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andReturn();

	        String resultDOW = result.getResponse().getContentAsString();
	        assertNotNull(resultDOW);
	        assertEquals(dow, resultDOW);
	    }
	
	
	*/
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testEmployee() throws Exception {
		mockMvc.perform(get("/test/{test}","hello")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
				

	}
	
}
