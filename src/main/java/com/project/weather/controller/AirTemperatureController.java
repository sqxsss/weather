package com.project.weather.controller;

import com.project.weather.service.AirTemperatureService;
import com.project.weather.service.LocationService;
import com.project.weather.service.PrecipitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AirTemperatureController {

    @Autowired
    AirTemperatureService airTemperatureService;

    @RequestMapping(value = "/basicData/temperature/getListByDate/{begin}/{end}", method = RequestMethod.POST)
    public List listDataByDate(@PathVariable("begin") String begin, @PathVariable("end") String end) {
        return airTemperatureService.listTemperatureByDate(begin, end);
    }

    @RequestMapping(value = "/basicData/temperature/getListByCityDate/{city}/{begin}/{end}", method = RequestMethod.POST)
    public List listDataByCityDate(@PathVariable("city") String city, @PathVariable("begin") String begin, @PathVariable("end") String end) {
        return airTemperatureService.listTemperatureByCityDate(city, begin, end);
    }

    @RequestMapping(value = "/basicData/temperature/getListByStationDate/{station_id}/{begin}/{end}", method = RequestMethod.POST)
    public List listDataByStationDate(@PathVariable("station_id") String station_id, @PathVariable("begin") String begin, @PathVariable("end") String end) {
        return airTemperatureService.listTemperatureByStationDate(station_id, begin, end);
    }

    @RequestMapping(value = "/complexQuery/temperatureComp/getMonthlyDataListByCity/{year}/{city}", method = RequestMethod.POST)
    public List getListTemDataByTime(@PathVariable("year") int year, @PathVariable("city") String city) throws ParseException {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            list.add(airTemperatureService.getCityAVGMonthlyTem(year, i, city));
        }
        return list;
    }

}
