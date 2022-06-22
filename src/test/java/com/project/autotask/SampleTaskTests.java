package com.project.autotask;
import com.project.autotask.controller.SampleTask;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.cloud.contract.spec.internal.MediaTypes;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(SpringExtension.class)
@WebMvcTest(SampleTask.class)
class SampleTaskTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getApiPocTest() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/apitesting/getapipoc")).andReturn();
		System.out.println("Results: " + result.getResponse().getContentAsString());
		assertEquals("<p>Hello,world</p>", result.getResponse().getContentAsString());
	}

	@Test
	void getApiPocTestJson() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/apitesting/getapipoc").accept(MediaTypes.APPLICATION_JSON)).andReturn();
		System.out.println("Results: " + result.getResponse().getContentType());
		JSONAssert.assertEquals("""
			{"message":"Hello World"}
		""", result.getResponse().getContentAsString(), false);
		assertEquals("application/json", result.getResponse().getContentType());
	}

	@Test
	void postApiPocTest() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/apitesting/postapipoc")).andReturn();
		System.out.println("Results: " + result.getResponse().getContentType());
		JSONAssert.assertEquals("""
			{"message":"Post API Successful"}
		""", result.getResponse().getContentAsString(), false);
		assertEquals("application/json", result.getResponse().getContentType());
	}
}

