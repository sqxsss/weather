package com.project.weather.serviceImpl;

import com.project.weather.bean.AirTemperature;
import com.project.weather.mapper.AirTemperatureMapper;
import com.project.weather.mapper.WindMapper;
import com.project.weather.service.AirTemperatureService;
import com.project.weather.service.WindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WindServiceImpl implements WindService {
    @Autowired
    private WindMapper windMapper;

    @Override
    public List listWindByDate(String begin, String end) {
        return windMapper.listWindByDaterange(begin, end);
    }

    @Override
    public List listWindByCityDate(String city, String begin, String end) {
        return windMapper.listWindByDaterangeCity(city, begin, end);
    }

    @Override
    public List listWindByStationDate(String station_id, String begin, String end) {
        return windMapper.listWindByDaterangeStation(station_id, begin, end);
    }
}
