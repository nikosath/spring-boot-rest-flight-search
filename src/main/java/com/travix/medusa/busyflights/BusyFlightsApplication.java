package com.travix.medusa.busyflights;
import java.time.LocalDate;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.travix.medusa.busyflights.service.*;

@SpringBootApplication
public class BusyFlightsApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {

        context = SpringApplication.run(BusyFlightsApplication.class, args);
        demo();
    }

    private static void demo() {
        BusyFlightsService bsService = context.getBean("busyFlightsService", BusyFlightsService.class);
        BusyFlightsRequest busyReq = new BusyFlightsRequest();
        busyReq.setOrigin("ATH");
        busyReq.setDestination("LON");
        busyReq.setDepartureDate(LocalDate.now());
        busyReq.setReturnDate(LocalDate.now());
        busyReq.setNumberOfPassengers(1);

        bsService.searchFlights(busyReq);
    }
}
