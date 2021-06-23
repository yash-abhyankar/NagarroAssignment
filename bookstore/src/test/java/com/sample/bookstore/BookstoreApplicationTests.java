package com.sample.bookstore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.bookstore.entity.Book;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class BookstoreApplicationTests {

	@Test
	void contextLoads() {
	}

	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MockMvc mockMvc;


	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testbook() throws Exception {
		mockMvc.perform(get("/test/{test}","hello")).andExpect(status().isOk())
		.andExpect(content().string(equalTo("hello")));
				

	}  
	
	@Test
	public void testaddbook() throws Exception {
		
		Book book= new Book(101,"yash","xxx",23);
		
		 MvcResult result=	 mockMvc.perform(post("/addBook")
		            .contentType(MediaType.APPLICATION_JSON)
		            .content(asJsonString(book)))
		            .andExpect(status().isOk())
		            .andReturn();
		 
		 String s= result.getResponse().getContentAsString();
		 String s1= book.getTitle()+"added successfully";
		 Assert.assertEquals(s1,s);
		
}  
	
	


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
