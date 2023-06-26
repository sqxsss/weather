package com.project.weather.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Station {
    public String station_id;
    public String sname;
    public float latitude;
    public float longtitude;
    public float elevation;
    public int zipcode;
}
