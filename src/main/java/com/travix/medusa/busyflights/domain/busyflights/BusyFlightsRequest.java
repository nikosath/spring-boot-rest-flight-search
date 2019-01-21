package com.travix.medusa.busyflights.domain.busyflights;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class BusyFlightsRequest {

    private String origin;
    private String destination;
//    TODO add more validations
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate departureDate;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate returnDate;
    private Integer numberOfPassengers;

}
