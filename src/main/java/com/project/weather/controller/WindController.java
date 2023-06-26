package com.project.weather.controller;

import com.project.weather.service.AirTemperatureService;
import com.project.weather.service.LocationService;
import com.project.weather.service.PrecipitationService;
import com.project.weather.service.WindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WindController {

    @Autowired
    WindService windService;

    @RequestMapping(value = "/basicData/wind/getListByDate/{begin}/{end}", method = RequestMethod.POST)
    public List listDataByDate(@PathVariable("begin") String begin, @PathVariable("end") String end) {
        return windService.listWindByDate(begin, end);
    }

    @RequestMapping(value = "/basicData/wind/getListByCityDate/{city}/{begin}/{end}", method = RequestMethod.POST)
    public List listDataByCityDate(@PathVariable("city") String city, @PathVariable("begin") String begin, @PathVariable("end") String end) {
        return windService.listWindByCityDate(city, begin, end);
    }

    @RequestMapping(value = "/basicData/wind/getListByStationDate/{station_id}/{begin}/{end}", method = RequestMethod.POST)
    public List listDataByStationDate(@PathVariable("station_id") String station_id, @PathVariable("begin") String begin, @PathVariable("end") String end) {
        return windService.listWindByStationDate(station_id, begin, end);
    }

}

