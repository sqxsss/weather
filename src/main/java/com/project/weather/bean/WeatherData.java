package com.project.weather.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WeatherData {
    public String station_id;
    public Date data_time;
}
