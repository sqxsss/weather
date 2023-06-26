package com.project.weather.serviceImpl;

import com.project.weather.mapper.PrecipitationMapper;
import com.project.weather.service.PrecipitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PrecipitationServiceImpl implements PrecipitationService {
    @Autowired
    private PrecipitationMapper precipitationMapper;

    @Override
    public List listAllData() {
        return precipitationMapper.listPrecipitation();
    }

    @Override
    public List listDataOfStation(String station_id) {
        return precipitationMapper.getListOfPrecByStation(station_id);
    }

    @Override
    public List listDataOfStationByTime(String station_id, String begin, String end) {
        return precipitationMapper.getListOfPrecByStationAT(station_id, begin, end);
    }

    @Override
    public List listDataOfCityStationByTime(String station_id, String begin, String end, String city) {
        if (station_id.equals("null")) {
            station_id = "";
        }
        String s = "%" + station_id + "%";
        return precipitationMapper.getListOfPrecByCityStationAT(s, begin, end, city);
    }

    @Override
    public List listDataByTime(String begin, String end) {
        return precipitationMapper.getListOfPrecByTimeRange(begin, end);
    }

    @Override
    public float getCityAVGMonthlyPrec(int year, int month, String city) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateformat.parse(year + "-" + month + "-01");

        String monthF = dateformat.format(date).substring(0,7) + "%"; //format'2019-04%'

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String dnumOfMonth = Integer.toString(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        if(precipitationMapper.countMonthlyPByCity(monthF, city, dnumOfMonth) == 0) {
            return 0;
        }
        return precipitationMapper.getAVGMonthlyPByCity(monthF, city, dnumOfMonth);
    }
}
