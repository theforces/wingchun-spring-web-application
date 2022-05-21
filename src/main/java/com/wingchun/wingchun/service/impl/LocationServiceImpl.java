package com.wingchun.wingchun.service.impl;

import com.wingchun.wingchun.model.dto.LocationDto;
import com.wingchun.wingchun.model.entity.Location;
import com.wingchun.wingchun.repository.LocationRepository;
import com.wingchun.wingchun.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationRepository getLocationRepository() {
        return locationRepository;
    }

    @Override
    public void addLocation(LocationDto locationDto) {
        Location location = modelMapper.map(locationDto, Location.class);
        locationRepository.save(location);
    }
}
