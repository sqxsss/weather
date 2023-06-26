package com.project.weather.mapper;

import com.project.weather.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WaterMapper {
    public List listUser();

    public User getUserInfoByID(int user_Id);

    public User getUserInfo(String email, String password);

    public User getUserInfoByEmail(String email);

    public Integer getLastUserID();

    public Integer getUserNumByDate(String date);

    public void addUser(User user);

    public void updateEmail(User user);

    public void deleteByUserId(int user_id);
}
