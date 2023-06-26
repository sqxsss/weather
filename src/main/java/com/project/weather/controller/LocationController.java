package com.project.weather.controller;

import com.project.weather.service.LocationService;
import com.project.weather.service.PrecipitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/basicData/location/getListOfAll", method = RequestMethod.GET)
    public List listAllData() {
        return locationService.getListOfAll();
    }

    @RequestMapping(value = "/basicData/location/getListBySearch/{condition}", method = RequestMethod.POST)
    public List listDataBySearchCon(@PathVariable("condition") String condition) {
        return locationService.getListOfDataByCon(condition);
    }

    @RequestMapping(value = "/basicData/location/getCityList", method = RequestMethod.GET)
    public List listAllCities() {
        return locationService.getListOfCities();
    }

}
