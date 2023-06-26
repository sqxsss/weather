package com.project.weather.mapper;

import com.project.weather.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WindMapper {
    public List listWindByDaterange(String begin, String end);

    public List listWindByDaterangeCity(String city, String begin, String end);

    public List listWindByDaterangeStation(String station_id, String begin, String end);
}
