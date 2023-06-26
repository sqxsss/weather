package com.project.weather.controller;

import com.project.weather.service.LocationService;
import com.project.weather.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationController {

    @Autowired
    StationService stationService;

    @RequestMapping(value = "/basicData/station/getAllStations", method = RequestMethod.GET)
    public List listStations() {
        return stationService.listStations();
    }

    @RequestMapping(value = "/basicData/station/getStationBySearch/{city}/{condition}", method = RequestMethod.POST)
    public List listStationsBySearchCon(@PathVariable("city") String city, @PathVariable("condition") String condition) {
        return stationService.listStationBySearchCon(city, condition);
    }

    @RequestMapping(value = "/basicData/station/getIDListByCity/{city}", method = RequestMethod.POST)
    public List listStationsBySearchCon(@PathVariable("city") String city) {
        return stationService.listStationIdByCity(city);
    }

}
