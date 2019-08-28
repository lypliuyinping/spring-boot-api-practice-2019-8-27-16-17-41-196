package com.tw.apistackbase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiStackBaseApplicationTests {
	  @Autowired
	  private MockMvc mockMvc;
	  @Test
	    public void shouldGotNameInBody() throws Exception{
	    	this.mockMvc.perform(get("/companies"))
	    				.andDo(print())
	    				.andExpect(status().isOk())
	    				.andExpect(MockMvcResultMatchers.jsonPath("$.user", CoreMatchers.is("name")));
	    }
	    

}
