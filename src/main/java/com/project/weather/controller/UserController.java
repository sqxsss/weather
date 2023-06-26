package com.project.weather.controller;

import com.project.weather.bean.User;
import com.project.weather.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/listu", method = RequestMethod.GET)
    public List listu() {
        return userService.listUser();
    }

    @RequestMapping(value = "/getUserInfo/{email}", method = RequestMethod.POST)
    public User getUserInfo(@PathVariable("email") String email) {
        return userService.getUserInfoByEmail(email);
    }

    @RequestMapping(value = "/UserManagement/getDateList/{beginDate}/{endDate}", method = RequestMethod.POST)
    public List getDateList(@PathVariable("beginDate") String begin, @PathVariable("endDate") String end) throws ParseException {
        return userService.getDateList(begin, end);
    }

    @RequestMapping(value = "/UserManagement/getUserNumList/{beginDate}/{endDate}", method = RequestMethod.POST)
    public List getUserNumList(@PathVariable("beginDate") String begin, @PathVariable("endDate") String end) throws ParseException {
        return userService.getUserNumByDate(begin, end);
    }

    @RequestMapping(value = "/login/{email}/{password}", method = RequestMethod.POST)
    public String login(@PathVariable("email") String email, @PathVariable("password") String password) {
        User user = userService.login(email, password);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return "success";
            } else {
                return "password error";
            }
        } else {
            return "account not exist";
        }
    }

    @RequestMapping(value = "/signUp/{email}/{password}", method = RequestMethod.POST)
    public String signUp(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.signUp(email, password);
    }

    @RequestMapping(value = "/UserManagement/updateEmail/{user_id}/{email}", method = RequestMethod.POST)
    public void signUp(@PathVariable("email") String email, @PathVariable("user_id") int user_id) {
        userService.updateEmail(email, user_id);
    }

    @RequestMapping(value = "/UserManagement/delete/{user_id}", method = RequestMethod.POST)
    public void signUp(@PathVariable("user_id") int user_id) {
        userService.deleteByUserId(user_id);
    }
}
