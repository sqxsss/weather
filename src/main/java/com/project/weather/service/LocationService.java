package com.project.weather.service;

import com.project.weather.bean.User;

import java.text.ParseException;
import java.util.List;

public interface LocationService {
    List getListOfAll();

    List getListOfDataByCon(String condition);

    List getListOfCities();
}
