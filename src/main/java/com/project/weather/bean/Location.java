package com.project.weather.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    public int zip;
    public String city;
    public String county;
    public String state;
}
