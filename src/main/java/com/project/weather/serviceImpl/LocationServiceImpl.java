package com.project.weather.serviceImpl;

import com.project.weather.mapper.LocationMapper;
import com.project.weather.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Locale;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationMapper locationMapper;

    @Override
    public List getListOfAll() {
        return locationMapper.listAllData();
    }

    @Override
    public List getListOfDataByCon(String condition) {
        String c = "%" + condition.toUpperCase() + "%";
        return locationMapper.listDataByCondition(c);
    }

    @Override
    public List getListOfCities() {
        return locationMapper.getCityList();
    }
}
