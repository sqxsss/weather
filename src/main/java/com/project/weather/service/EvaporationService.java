package com.project.weather.service;

import com.project.weather.bean.User;

import java.text.ParseException;
import java.util.List;

public interface EvaporationService {

    List listEvaporationByDate(String begin, String end);

    List listEvaporationByCityDate(String city, String begin, String end);

    List listEvaporationByStationDate(String station_id, String begin, String end);

    float getCityMonthlyEvap(int year, int month, String city) throws ParseException;
}
