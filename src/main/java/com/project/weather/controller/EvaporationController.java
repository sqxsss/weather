package com.project.weather.controller;

import com.project.weather.service.EvaporationService;
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
public class EvaporationController {

    @Autowired
    EvaporationService evaporationService;

    @RequestMapping(value = "/basicData/evaporation/getListByDate/{begin}/{end}", method = RequestMethod.POST)
    public List listDataByDate(@PathVariable("begin") String begin, @PathVariable("end") String end) {
        return evaporationService.listEvaporationByDate(begin, end);
    }

    @RequestMapping(value = "/basicData/evaporation/getListByCityDate/{city}/{begin}/{end}", method = RequestMethod.POST)
    public List listDataByCityDate(@PathVariable("city") String city, @PathVariable("begin") String begin, @PathVariable("end") String end) {
        return evaporationService.listEvaporationByCityDate(city, begin, end);
    }

    @RequestMapping(value = "/basicData/evaporation/getListByStationDate/{station_id}/{begin}/{end}", method = RequestMethod.POST)
    public List listDataByStationDate(@PathVariable("station_id") String station_id, @PathVariable("begin") String begin, @PathVariable("end") String end) {
        return evaporationService.listEvaporationByStationDate(station_id, begin, end);
    }

    @RequestMapping(value = "/complexQuery/evaporation/getMonthlyDataListByCity/{year}/{city}", method = RequestMethod.POST)
    public List getListTemDataByTime(@PathVariable("year") int year, @PathVariable("city") String city) throws ParseException {
        List<Float> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            list.add(evaporationService.getCityMonthlyEvap(year, i, city));
        }
        return list;
    }

}

