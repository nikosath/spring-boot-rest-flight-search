package com.travix.medusa.busyflights.domain.busyflights;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//TODO AirlineResponseListWrapper to be used for having each airline return multiple flights (if more than one found, according to criteria)
@Getter
@Setter
public class AirlineResponseListWrapper {
    private List<AirlineResponse> list;

    AirlineResponseListWrapper() {
        list = new ArrayList<>();
    }
}
