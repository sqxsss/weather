package com.project.weather.service;

import com.project.weather.bean.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface UserService {

    List listUser();

    User getUserInfoByUserId(int user_id);

    User getUserInfoByEmail(String email);

    List getDateList(String begin, String end) throws ParseException;

    List getUserNumByDate(String begin, String end) throws ParseException;

    User login(String email, String password);

    String signUp(String email, String password);

    void updateEmail(String email, int user_id);

    void deleteByUserId(int user_id);
}
