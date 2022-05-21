package com.wingchun.wingchun.service;

import com.wingchun.wingchun.model.dto.LocationDto;
import com.wingchun.wingchun.repository.LocationRepository;

public interface LocationService {
    LocationRepository getLocationRepository();

    void addLocation(LocationDto locationDto);
}
