package com.project.weather.serviceImpl;

import com.project.weather.mapper.StationMapper;
import com.project.weather.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationMapper stationMapper;

    @Override
    public List listStations() {
        return stationMapper.listAllData();
    }

    @Override
    public List listStationBySearchCon(String city, String condition) {
        if (city.equals("null")) {
            city = "";
        } else if (condition.equals("null")) {
            condition = "";
        }
        String ci = "%" + city + "%";
        String con = "%" + condition.toUpperCase() + "%";
        return stationMapper.listDataByCityCon(ci, con);
    }

    @Override
    public List listStationIdByCity(String city) {
        if (city.equals("null")) {
            city = "";
        }
        return stationMapper.listIDByCity(city);
    }
}
