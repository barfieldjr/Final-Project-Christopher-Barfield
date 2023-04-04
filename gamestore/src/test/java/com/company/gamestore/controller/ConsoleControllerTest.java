package com.company.gamestore.controller;

import com.company.gamestore.model.Console;
import com.company.gamestore.repository.ConsoleRepository;
import com.company.gamestore.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ServiceLayer serviceLayer;

    @MockBean
    ConsoleRepository repo;

    @MockBean
    ServiceLayer serviceLayerMB;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() throws Exception{

    }

    // Console Controller Test Should Create Console
    @Test
    public void shouldCreateConsole() throws Exception{
        Console console = new Console();
        console.setConsoleId(20);
        console.setModel("Playstation 5");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("Eight-core AMD Zen 2 CPU");
        BigDecimal price = new BigDecimal(499.99);
        console.setPrice(price);
        console.setQuantity(100);


        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(post("/consoles")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }



    // Console Controller Test Should Get a Console by ID


    // Console Controller Test Should Get all consoles



    // Console Controller Test Should Update a console


    // Console Controller Test Should Delete a console


    // Console Controller Test Should Get consoles by manufacturer


















}