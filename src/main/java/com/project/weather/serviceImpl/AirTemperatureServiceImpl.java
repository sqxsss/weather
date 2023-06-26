package com.project.weather.serviceImpl;

import com.project.weather.bean.AirTemperature;
import com.project.weather.mapper.AirTemperatureMapper;
import com.project.weather.mapper.LocationMapper;
import com.project.weather.service.AirTemperatureService;
import com.project.weather.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AirTemperatureServiceImpl implements AirTemperatureService {
    @Autowired
    private AirTemperatureMapper airTemperatureMapper;

    @Override
    public List listTemperatureByDate(String begin, String end) {
        return addAVGtoList(airTemperatureMapper.listTemByDaterange(begin, end));
    }

    @Override
    public List listTemperatureByCityDate(String city, String begin, String end) {
        return addAVGtoList(airTemperatureMapper.listTemByDaterangeCity(city, begin, end));
    }

    @Override
    public List listTemperatureByStationDate(String station_id, String begin, String end) {
        return addAVGtoList(airTemperatureMapper.listTemByDaterangeStation(station_id, begin, end));
    }

    @Override
    public int getCityAVGMonthlyTem(int year, int month, String city) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateformat.parse(year + "-" + month + "-01");

        String monthF = dateformat.format(date).substring(0,7) + "%"; //format'2019-04%'

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String dnumOfMonth = Integer.toString(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        if(airTemperatureMapper.countTemMonthlyByCity(monthF, city, dnumOfMonth) == 0) {
            return 0;
        }
        return airTemperatureMapper.getAVGTemMonthlyByCity(monthF, city, dnumOfMonth);
    }

    List addAVGtoList(List<AirTemperature> origin) {
        for (int i = 0; i < origin.size(); i++) {
            if (origin.get(i).tavg == -999) {
                origin.get(i).tavg = (origin.get(i).tmax + origin.get(i).tmin) / 2;
            }
        }
        return origin;
    }
}
