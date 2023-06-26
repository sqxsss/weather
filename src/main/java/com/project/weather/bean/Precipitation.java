package com.project.weather.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Precipitation {
    public String station_id;
    public Date data_time;
    public float dapr;
    public float mdpr;
    public float snow;
    public float snwd;
    public float prcp;
}
