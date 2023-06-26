package com.project.weather.mapper;

import com.project.weather.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrecipitationMapper {
    public List listPrecipitation();

    public List getListOfPrecByStation(String station_id);

    public List getListOfPrecByStationAT(String station_id, String begin, String end);

    public List getListOfPrecByCityStationAT(String station_id, String begin, String end, String city);

    public List getListOfPrecByTimeRange(String begin, String end);

    public float getAVGMonthlyPByCity(String month, String city, String dnumOfMonth);

    public int countMonthlyPByCity(String month, String city, String dnumOfMonth);
}
