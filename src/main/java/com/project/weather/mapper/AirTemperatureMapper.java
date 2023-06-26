package com.project.weather.mapper;

import com.project.weather.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AirTemperatureMapper {
    public List listTemByDaterange(String begin, String end);

    public List listTemByDaterangeCity(String city, String begin, String end);

    public List listTemByDaterangeStation(String station_id, String begin, String end);

    public int getAVGTemMonthlyByCity(String month, String city, String dnumOfMonth);

    public int countTemMonthlyByCity(String month, String city, String dnumOfMonth);

}
