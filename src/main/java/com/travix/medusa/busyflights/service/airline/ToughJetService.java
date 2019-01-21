package com.travix.medusa.busyflights.service.airline;
import java.time.LocalDate;

import com.travix.medusa.busyflights.domain.busyflights.AirlineRequest;
import com.travix.medusa.busyflights.domain.busyflights.AirlineResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ToughJetService implements AirlineService<ToughJetRequest, ToughJetResponse> {
    private final RestTemplate restTemplateBean;

    public ToughJetService(RestTemplate restTemplateBean) {
        this.restTemplateBean = restTemplateBean;
    }

    public AirlineRequest createAirlineRequest(BusyFlightsRequest busyReq) {
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom(busyReq.getOrigin());
        toughJetRequest.setTo(busyReq.getDestination());
        toughJetRequest.setOutboundDate(busyReq.getDepartureDate());
        toughJetRequest.setInboundDate(busyReq.getReturnDate());
        toughJetRequest.setNumberOfAdults(busyReq.getNumberOfPassengers());
        return toughJetRequest;
    }

    @Override
    public BusyFlightsResponse createBusyFlightsResponse(ToughJetResponse airResp) {
        BusyFlightsResponse busyResp = new BusyFlightsResponse();
        busyResp.setAirline(airResp.getCarrier());
        double finalPrice = airResp.getBasePrice() * (1 - 1 / airResp.getDiscount()) + airResp.getTax();
        busyResp.setFinalPrice(finalPrice);
        busyResp.setCabinclass("N/A");
        busyResp.setDepartureAirportCode(airResp.getDepartureAirportName());
        busyResp.setDestinationAirportCode(airResp.getArrivalAirportName());
        busyResp.setDepartureDate(airResp.getOutboundDateTime());
        busyResp.setArrivalDate(airResp.getInboundDateTime());
        return busyResp;
    }


    @Override
    public String getUrlWithoutParams() {
        return "http://localhost:8080/busyflights/provideDummyToughJetResponse";
    }

    @Override
    public BusyFlightsResponse searchFlights(String urlWithParams) {
//        ToughJetResponse toughResp = restTemplateBean.getForObject(getUrlWithoutParams(), ToughJetResponse.class);
        ToughJetResponse toughResp = restTemplateBean.getForObject(urlWithParams, ToughJetResponse.class);
        return createBusyFlightsResponse(toughResp);
    }

}
