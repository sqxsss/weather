package com.project.weather.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    public int user_id;
    public String email;
    public String password;
    public char usertype;
    public Date createtime;
}
