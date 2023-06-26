package com.project.weather.service;

import java.text.ParseException;
import java.util.List;

public interface PrecipitationService {

    List listAllData();

    List listDataOfStation(String station_id);

    List listDataOfStationByTime(String station_id, String begin, String end);

    List listDataOfCityStationByTime(String station_id, String begin, String end, String city);

    List listDataByTime(String begin, String end);

    float getCityAVGMonthlyPrec(int year, int month, String city) throws ParseException;
}
