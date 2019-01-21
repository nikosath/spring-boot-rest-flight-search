package com.travix.medusa.busyflights.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.travix.medusa.busyflights.service.BusyFlightsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.travix.medusa.busyflights.domain.busyflights.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BusyFlightsController.class)
public class BusyFlightsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BusyFlightsService busyFlightsService;

    // TODO incomplete
    @Test
    public void searchFlights_basic() throws Exception {
        List<BusyFlightsResponse> busyFlightsResponses = new ArrayList<>();
        BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
        busyFlightsResponse.setAirline("CrazyAir");
        busyFlightsResponses.add(busyFlightsResponse);

        when(busyFlightsService.searchFlights(any(BusyFlightsRequest.class))).thenReturn(busyFlightsResponses);

        RequestBuilder request = MockMvcRequestBuilders.get(
                "/busyflights/search?origin=origin&departureDate=departureDate&numberOfPassengers=6")
                .accept(MediaType.ALL);

        String expectedJson = "[{\"airline\":null,\"finalPrice\":0.0,\"cabinclass\":\"cabinn\",\"departureAirportCode\":null," +
                "\"destinationAirportCode\":null,\"departureDate\":null,\"arrivalDate\":null}]";

        mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().json(expectedJson)).andReturn();
    }

}
