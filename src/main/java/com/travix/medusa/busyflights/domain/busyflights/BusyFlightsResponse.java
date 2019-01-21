package com.travix.medusa.busyflights.domain.busyflights;


import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;

import java.time.LocalDate;

@Data
public class BusyFlightsResponse {

    private String airline;
    private double finalPrice;
    private String cabinclass;
    private String departureAirportCode;
    private String destinationAirportCode;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
}
