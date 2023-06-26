package com.project.weather.mapper;

import com.project.weather.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocationMapper {
    public List listAllData();

    public List listDataByCondition(String condition);

    public List getCityList();
}
