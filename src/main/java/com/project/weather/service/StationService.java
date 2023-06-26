package com.project.weather.service;

import com.project.weather.bean.User;

import java.text.ParseException;
import java.util.List;

public interface StationService {

    List listStations();

    List listStationBySearchCon(String city, String condition);

    List listStationIdByCity(String city);
}
