package com.project.weather.service;

import com.project.weather.bean.User;

import java.text.ParseException;
import java.util.List;

public interface AirTemperatureService {

    List listTemperatureByDate(String begin, String end);

    List listTemperatureByCityDate(String city, String begin, String end);

    List listTemperatureByStationDate(String station_id, String begin, String end);

    int getCityAVGMonthlyTem(int year, int month, String city) throws ParseException;

}
