package com.project.weather.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Wind {
    public String station_id;
    public Date data_time;
    public float wsf5;
    public float wsf2;
    public int wdf5;
    public int wdf2;
    public float awnd;
}
