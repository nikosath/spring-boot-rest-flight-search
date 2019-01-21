package com.travix.medusa.busyflights.domain.crazyair;

import com.travix.medusa.busyflights.domain.busyflights.AirlineRequest;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CrazyAirRequest implements AirlineRequest {

    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private Integer passengerCount;

}
