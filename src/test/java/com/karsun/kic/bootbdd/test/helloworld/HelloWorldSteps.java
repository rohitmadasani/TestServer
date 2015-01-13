package com.karsun.kic.bootbdd.test.helloworld;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.karsun.kic.bootbdd.Application;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class HelloWorldSteps {
	@Autowired 
	private WebApplicationContext context;
	
	MockMvc mockMvc = null;
	
	@Before
	public void setup() throws IOException {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		//MockMvcClientHttpRequestFactory factory = new MockMvcClientHttpRequestFactory(mockMvc);
	}

	@After
	public void destroy() {
		
	}
	
	@Given("^I access the Hello World resource$")
	public void i_access_the_Hello_World_resource() throws Throwable {
		this.mockMvc.perform(get("/hello")).andExpect(status().isOk());
	}

	@Then("^I should get the hello world resource$")
	public void i_should_get_the_hello_world_resource() throws Throwable {
		this.mockMvc.perform(get("/hello")).andExpect(content().string("Hello World"));
		//System.out.println(content().string("Hello World"));
		//assertEquals(true, content().string("Hello World"));
	}
}
