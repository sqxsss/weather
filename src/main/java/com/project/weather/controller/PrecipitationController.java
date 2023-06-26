package com.project.weather.controller;

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
public class PrecipitationController {

    @Autowired
    PrecipitationService precipitationService;

    @RequestMapping(value = "/basicData/precipitation/listAllPrecData", method = RequestMethod.GET)
    public List listAllPData() {
        return precipitationService.listAllData();
    }

    @RequestMapping(value = "/basicData/precipitation/getDataByStation/{station_id}", method = RequestMethod.POST)
    public List getListPrecDataByStation(@PathVariable("station_id") String station_id) {
        return precipitationService.listDataOfStation(station_id);
    }

    @RequestMapping(value = "/basicData/precipitation/getDataByStationTime/{station_id}/{begin}/{end}", method = RequestMethod.POST)
    public List getListPrecDataByStationTime(@PathVariable("station_id") String station_id, @PathVariable("begin") String begin, @PathVariable("end") String end) {
        return precipitationService.listDataOfStationByTime(station_id, begin, end);
    }

    @RequestMapping(value = "/basicData/precipitation/getDataByCityStationTime/{station_id}/{begin}/{end}/{city}", method = RequestMethod.POST)
    public List getListPrecDataByFullCondition(@PathVariable("station_id") String station_id, @PathVariable("begin") String begin, @PathVariable("end") String end, @PathVariable("city") String city) {
        return precipitationService.listDataOfCityStationByTime(station_id, begin, end, city);
    }

    @RequestMapping(value = "/basicData/precipitation/getDataByTime/{begin}/{end}", method = RequestMethod.POST)
    public List getListPrecDataByTime(@PathVariable("begin") String begin, @PathVariable("end") String end) {
        return precipitationService.listDataByTime(begin, end);
    }

    @RequestMapping(value = "/complexQuery/precipitationComp/getMonthlyDataListByCity/{year}/{city}", method = RequestMethod.POST)
    public List getListPrecDataByTime(@PathVariable("year") int year, @PathVariable("city") String city) throws ParseException {
        List<Float> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            BigDecimal b = new BigDecimal(precipitationService.getCityAVGMonthlyPrec(year, i, city));
            float f1 = (float) b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            list.add(f1);
        }
        return list;
    }

    @RequestMapping(value = "/basicData/precipitation/test/{year}/{month}/{city}", method = RequestMethod.POST)
    public float getListPrecDataByTime(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("city") String city) throws ParseException {
        return precipitationService.getCityAVGMonthlyPrec(year, month, city);
    }
}
