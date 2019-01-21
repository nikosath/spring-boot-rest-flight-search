package com.travix.medusa.busyflights.domain.crazyair;

import com.travix.medusa.busyflights.domain.busyflights.AirlineResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CrazyAirResponse implements AirlineResponse {

    private String airline;
    private double price;
    private String cabinclass;
    private String departureAirportCode;
    private String destinationAirportCode;
    private LocalDate departureDate;
    private LocalDate arrivalDate;

}
