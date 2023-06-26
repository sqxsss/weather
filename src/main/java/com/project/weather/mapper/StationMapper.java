package com.project.weather.mapper;

import com.project.weather.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StationMapper {
    public List listAllData();

    public List listDataByCityCon(String city, String condition);

    public List listIDByCity(String city);
}
