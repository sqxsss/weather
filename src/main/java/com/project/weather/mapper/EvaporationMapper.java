package com.project.weather.mapper;

import com.project.weather.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EvaporationMapper {
    public List listEvapByDaterange(String begin, String end);

    public List listEvapByDaterangeCity(String city, String begin, String end);

    public List listEvapByDaterangeStation(String station_id, String begin, String end);

    public float getEvapMonthlyByCity(String month, String city, String dnumOfMonth);

    public int countEvapMonthlyByCity(String month, String city, String dnumOfMonth);
}
