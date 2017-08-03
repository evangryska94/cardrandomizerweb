package com.doug.controllers;

/**
 * Created by Doug on 12/19/16.
 */

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IndexControllerTest {

private MockMvc mockMvc;

private IndexController indexController;

@Before
public void setup(){
		  indexController = new IndexController();
		  mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		  }

@Test
public void testIndex() throws Exception{
		  mockMvc.perform(get("/"))
		  .andExpect(status().isOk())
		  .andExpect(view().name("index"));
		  }

}