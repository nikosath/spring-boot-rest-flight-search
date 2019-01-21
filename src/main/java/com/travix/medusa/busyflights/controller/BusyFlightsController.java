package com.travix.medusa.busyflights.controller;
import java.time.LocalDate;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.service.BusyFlightsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.*;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/busyflights")
public class BusyFlightsController {

    private static final Logger LOG = LoggerFactory.getLogger(BusyFlightsController.class);
    @Autowired
    BusyFlightsService busyFlightsService;

    @GetMapping("/search")
    public List<BusyFlightsResponse> searchFlights(@Valid BusyFlightsRequest busyReq) {
        List<BusyFlightsResponse> resp = busyFlightsService.searchFlights(busyReq);
        return resp;
    }

    @GetMapping("/provideDummyCrazyAirResponse")
    public CrazyAirResponse provideDummyCrazyAirResponse() {
        CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
        crazyAirResponse.setAirline("CrazyAir");
        crazyAirResponse.setPrice(90.0D);
        crazyAirResponse.setCabinclass("B");
        crazyAirResponse.setDepartureAirportCode("LHR");
        crazyAirResponse.setDestinationAirportCode("AMS");
        crazyAirResponse.setDepartureDate(LocalDate.now());
        crazyAirResponse.setArrivalDate(LocalDate.now());

        return crazyAirResponse;
    }

    @GetMapping("/provideDummyToughJetResponse")
    public ToughJetResponse provideDummyToughJetResponse() {
        ToughJetResponse toughResp = new ToughJetResponse();
        toughResp.setCarrier("ToughJet");
        toughResp.setBasePrice(100.0D);
        toughResp.setTax(20.0D);
        toughResp.setDiscount(10.0D);
        toughResp.setDepartureAirportName("LHR");
        toughResp.setArrivalAirportName("AMR");
        toughResp.setOutboundDateTime(LocalDate.now());
        toughResp.setInboundDateTime(LocalDate.now());
        return toughResp;
    }


}
