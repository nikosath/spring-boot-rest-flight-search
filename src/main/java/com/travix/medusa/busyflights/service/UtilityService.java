package com.travix.medusa.busyflights.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travix.medusa.busyflights.domain.busyflights.AirlineRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.airline.AirlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilityService {

    private static final Logger logger = LoggerFactory.getLogger(UtilityService.class);

    private ObjectMapper objectMapper;
    public UtilityService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String createUrlWithParams(String urlWithoutParams, Object urlParams) {
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        LinkedMultiValueMap<String, String> params = objectMapper.convertValue(urlParams,
                new TypeReference<LinkedMultiValueMap<String, String>>() {
                });
        params.entrySet().removeIf(entry -> (entry.getValue() == null) ? true : entry.getValue().get(0).isEmpty());

        String urlWithParams = UriComponentsBuilder.fromHttpUrl(urlWithoutParams)
                .queryParams(params)
                .build()
                .toUri().toString();
        return urlWithParams;
    }

}

