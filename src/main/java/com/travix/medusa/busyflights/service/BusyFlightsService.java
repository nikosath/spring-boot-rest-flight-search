package com.travix.medusa.busyflights.service;

import com.travix.medusa.busyflights.domain.busyflights.AirlineRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.airline.AirlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusyFlightsService {

    private static final Logger LOG = LoggerFactory.getLogger(BusyFlightsService.class);

    private List<AirlineService> airlineServices;
    private UtilityService utilService;

    public BusyFlightsService(
            List<AirlineService> airlineServices,
            UtilityService utilityService) {

        this.airlineServices = airlineServices;
        this.utilService = utilityService;
    }

    public List<BusyFlightsResponse> searchFlights(BusyFlightsRequest busyReq) {
        LOG.info("busyRec = " + busyReq);

        List<BusyFlightsResponse> busyFlightsResponses = new ArrayList<>();
        for (AirlineService airService : airlineServices) {
            AirlineRequest airlineRequest = airService.createAirlineRequest(busyReq);
            LOG.info("airlineRequest = " + airlineRequest);
            String urlWithParams = utilService.createUrlWithParams(airService.getUrlWithoutParams(), airlineRequest);
            LOG.info("urlWithParams = " + urlWithParams);
            busyFlightsResponses.add(airService.searchFlights(urlWithParams));
        }
        LOG.info("busyFlightsResponses = " + busyFlightsResponses);
        return busyFlightsResponses;
    }

}

