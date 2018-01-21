/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.demo.pasta.store;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.demo.pasta.store.model.PastaResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class PastaControllerTests {

	
	@Autowired
	protected  ObjectMapper mapper;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testRestOfGetPastas() throws Exception {

		this.mockMvc.perform(get("/pasta")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testRestOfSauce() throws Exception {

		this.mockMvc.perform(get("/sauce")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testRestOfGetPasta() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(get("/pasta/Spaghetti")).andReturn();
		String jsonResult = mvcResult.getResponse().getContentAsString();
		PastaResponse pastaResponse = mapper.readValue(jsonResult, PastaResponse.class);
		validatePastaResponsePrice(pastaResponse, 15.99);

	}

	@Test
	public void testRestOfOrderPasta() throws Exception {
		
		this.mockMvc.perform(post("/order")
				    .contentType(MediaType.APPLICATION_JSON_VALUE)
				    .content("{\"pasta\":\"Farfalle\",\"sauces\":[\"Alfredo\"]}")
				    .accept(MediaType.APPLICATION_JSON)).
		             andDo(print()).andExpect(status().is2xxSuccessful());

	}
	
	
	@Test
	public void testRestOfOrderPastaWithListOfSauces() throws Exception {
		
		this.mockMvc.perform(post("/order")
				    .contentType(MediaType.APPLICATION_JSON_VALUE)
				    .content("{\"pasta\":\"Spaghetti\",\"sauces\":[\"Pesto\",\"Tomato\"]}")
				    .accept(MediaType.APPLICATION_JSON)).
		             andDo(print()).andExpect(status().is2xxSuccessful());

	}
	
	@Test
	public void testRestOfOrderPastaNotFound() throws Exception {
		
		this.mockMvc.perform(post("/order")
				    .contentType(MediaType.APPLICATION_JSON_VALUE)
				    .content("{\"pasta\":\"Stam\",\"sauces\":[\"Alfredo\"]}")
				    .accept(MediaType.APPLICATION_JSON)).
		             andDo(print()).andExpect(status().isNotFound());

	}



	private void validatePastaResponsePrice(PastaResponse pastaResponse, double expectedPrice) {

		Assert.assertNotNull(pastaResponse);
		Assert.assertEquals(expectedPrice, pastaResponse.getPasta().getPrice(), 0.0);
		Assert.assertTrue(pastaResponse.getId() > 0);
	}

}
