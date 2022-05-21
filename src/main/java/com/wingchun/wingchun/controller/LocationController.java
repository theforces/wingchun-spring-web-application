package com.wingchun.wingchun.controller;

import com.wingchun.wingchun.model.dto.LocationDto;
import com.wingchun.wingchun.model.entity.Location;
import com.wingchun.wingchun.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final ModelMapper modelMapper;
    private final LocationService locationService;

    public LocationController(ModelMapper modelMapper, LocationService locationService) {
        this.modelMapper = modelMapper;
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<?> getAllLocations() {
        List<Location> locationList = locationService.getLocationRepository().findAll();
        List<LocationDto> locationDtos = locationList.stream()
                .map(location -> modelMapper.map(location, LocationDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(locationDtos);
    }

    @GetMapping("{locationId}")
    public ResponseEntity<?> getLocationById(@PathVariable Long locationId) {

        if (!locationService.getLocationRepository().findById(locationId).isPresent()) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(modelMapper.map(locationService.getLocationRepository().findById(locationId), LocationDto.class), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createLocation(@Validated @RequestBody LocationDto locationDto) {
        locationService.addLocation(locationDto);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @DeleteMapping("{locationId}")
    public ResponseEntity<?> deleteLocationById(@PathVariable Long locationId) {

        if (!locationService.getLocationRepository().findById(locationId).isPresent()) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }

        locationService.getLocationRepository().deleteById(locationId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
