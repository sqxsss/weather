package com.project.weather.serviceImpl;

import com.project.weather.mapper.EvaporationMapper;
import com.project.weather.mapper.WindMapper;
import com.project.weather.service.EvaporationService;
import com.project.weather.service.WindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class EvaporationServiceImpl implements EvaporationService {
    @Autowired
    private EvaporationMapper evaporationMapper;

    @Override
    public List listEvaporationByDate(String begin, String end) {
        return evaporationMapper.listEvapByDaterange(begin, end);
    }

    @Override
    public List listEvaporationByCityDate(String city, String begin, String end) {
        return evaporationMapper.listEvapByDaterangeCity(city, begin, end);
    }

    @Override
    public List listEvaporationByStationDate(String station_id, String begin, String end) {
        return evaporationMapper.listEvapByDaterangeStation(station_id, begin, end);
    }

    @Override
    public float getCityMonthlyEvap(int year, int month, String city) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateformat.parse(year + "-" + month + "-01");

        String monthF = dateformat.format(date).substring(0,7) + "%"; //format'2019-04%'

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String dnumOfMonth = Integer.toString(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        if(evaporationMapper.countEvapMonthlyByCity(monthF, city, dnumOfMonth) == 0) {
            return 0;
        }
        return evaporationMapper.getEvapMonthlyByCity(monthF, city, dnumOfMonth);
    }
}
