package com.sixlab.peixun;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yingzhang on 12/04/2020.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class MyTest {

    private MockMvc mockMvc;

    @InjectMocks
    private RestController restController;

    @Before
    public void setup(){
        mockMvc= MockMvcBuilders.standaloneSetup(restController).build();
    }

    @Test
    public void testHello() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/hello")
        ).andReturn();

        System.out.println(result.getResponse());

    }
}
