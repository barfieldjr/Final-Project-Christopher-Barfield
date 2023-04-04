package com.company.gamestore.controller;

import com.company.gamestore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    ServiceLayer serviceLayerMB;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() throws Exception{

    }

}