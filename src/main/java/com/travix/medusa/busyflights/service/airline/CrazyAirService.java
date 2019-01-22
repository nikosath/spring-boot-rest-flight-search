package com.travix.medusa.busyflights.service.airline;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CrazyAirService implements AirlineService<CrazyAirRequest, CrazyAirResponse> {
    private final RestTemplate restTemplateBean;

    public CrazyAirService(RestTemplate restTemplateBean) {
        this.restTemplateBean = restTemplateBean;
    }


    @Override
    public CrazyAirRequest createAirlineRequest(BusyFlightsRequest busyReq) {
        CrazyAirRequest airReq = new CrazyAirRequest();
        airReq.setOrigin(busyReq.getOrigin());
        airReq.setDestination(busyReq.getDestination());
        airReq.setDepartureDate(busyReq.getDepartureDate());
        airReq.setReturnDate(busyReq.getReturnDate());
        airReq.setPassengerCount(busyReq.getNumberOfPassengers());
        return airReq;
    }

    @Override
    public BusyFlightsResponse createBusyFlightsResponse(CrazyAirResponse crazyResp) {
        BusyFlightsResponse busyResp = new BusyFlightsResponse();
        busyResp.setAirline(crazyResp.getAirline());
        busyResp.setFinalPrice(crazyResp.getPrice());
        busyResp.setCabinclass(crazyResp.getCabinclass());
        busyResp.setDepartureAirportCode(crazyResp.getDepartureAirportCode());
        busyResp.setDestinationAirportCode(crazyResp.getDestinationAirportCode());
        busyResp.setDepartureDate(crazyResp.getDepartureDate());
        busyResp.setArrivalDate(crazyResp.getArrivalDate());
        return busyResp;
    }


    @Override
    public String getUrlWithoutParams() {
        return "http://localhost:8080/busyflights/provideDummyCrazyAirResponse";
    }

    // TODO find way to avoid duplicates of searchFlights
    @Override
    public BusyFlightsResponse searchFlights(String urlWithParams) {
//        CrazyAirResponse crazyResp = restTemplateBean.getForObject(getUrlWithoutParams(), CrazyAirResponse.class);
        //TODO replace with AsyncRestTemplate (and CompletableFuture?)
        CrazyAirResponse crazyResp = restTemplateBean.getForObject(urlWithParams, CrazyAirResponse.class);
        return createBusyFlightsResponse(crazyResp);
    }

}
