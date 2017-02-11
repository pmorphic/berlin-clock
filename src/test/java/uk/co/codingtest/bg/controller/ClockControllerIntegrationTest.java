package uk.co.codingtest.bg.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import uk.co.codingtest.bg.BerlinClockApplication;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BerlinClockApplication.class)
@WebAppConfiguration
public class ClockControllerIntegrationTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void itShouldUseValidTimePassedIn() throws Exception {
        mockMvc.perform(get("/display-time")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("time", "00:00:01")
        ).andExpect(status().isOk());
    }

    @Test
    public void itShouldReturnBadRequestForInvalidTimeParam() throws Exception {
        mockMvc.perform(get("/display-time")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("time", "ee:00:dd")
        ).andExpect(status().isBadRequest());
    }

    @After
    public void tearDown() throws Exception {

    }

}