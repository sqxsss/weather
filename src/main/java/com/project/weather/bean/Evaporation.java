package com.project.weather.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Evaporation {
    public String station_id;
    public Date data_time;
    public float mxpn;
    public float mnpn;
    public float evap;
}
