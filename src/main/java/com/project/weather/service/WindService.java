package com.project.weather.service;

import com.project.weather.bean.User;

import java.text.ParseException;
import java.util.List;

public interface WindService {

    List listWindByDate(String begin, String end);

    List listWindByCityDate(String city, String begin, String end);

    List listWindByStationDate(String station_id, String begin, String end);
}
