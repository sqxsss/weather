package com.project.weather.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AirTemperature {
    public String station_id;
    public Date data_time;
    public int tavg;
    public int tmax;
    public int tmin;
    public int tobs;
}

