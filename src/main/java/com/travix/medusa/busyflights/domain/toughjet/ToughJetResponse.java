package com.travix.medusa.busyflights.domain.toughjet;

import com.travix.medusa.busyflights.domain.busyflights.AirlineResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ToughJetResponse implements AirlineResponse {

    private String carrier;
    private double basePrice;
    private double tax;
    private double discount;
    private String departureAirportName;
    private String arrivalAirportName;
    private LocalDate outboundDateTime;
    private LocalDate inboundDateTime;


}
