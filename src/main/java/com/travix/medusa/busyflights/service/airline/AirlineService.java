package com.travix.medusa.busyflights.service.airline;

import com.travix.medusa.busyflights.domain.busyflights.AirlineRequest;
import com.travix.medusa.busyflights.domain.busyflights.AirlineResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;


public interface AirlineService<Q extends AirlineRequest, S extends AirlineResponse> {

    AirlineRequest createAirlineRequest(BusyFlightsRequest busyReq);

    BusyFlightsResponse createBusyFlightsResponse(S airlineResponse);

    String getUrlWithoutParams();

    BusyFlightsResponse searchFlights(String urlWithParams);

}
