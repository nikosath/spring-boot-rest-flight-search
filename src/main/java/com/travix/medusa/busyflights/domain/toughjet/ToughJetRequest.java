package com.travix.medusa.busyflights.domain.toughjet;

import com.travix.medusa.busyflights.domain.busyflights.AirlineRequest;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
public class ToughJetRequest implements AirlineRequest{

    private String from;
    private String to;
    private LocalDate outboundDate;
    private LocalDate inboundDate;
    private Integer numberOfAdults;

}
