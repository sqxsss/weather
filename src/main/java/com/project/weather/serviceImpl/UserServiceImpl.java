package com.project.weather.serviceImpl;

import com.project.weather.bean.User;
import com.project.weather.mapper.UserMapper;
import com.project.weather.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List listUser() {
//        System.out.println(userMapper.listUser().get(0));
        return userMapper.listUser();
    }

    @Override
    public User getUserInfoByUserId(int user_id) {
        return userMapper.getUserInfoByID(user_id);
    }

    @Override
    public User getUserInfoByEmail(String email) {
        return userMapper.getUserInfoByEmail(email);
    }

    // 获取时间范围的每一天的时间列表
    @Override
    public List getDateList(String begin, String end) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date b = df.parse(begin);
        Date e = df.parse(end);
        List<String> l = new ArrayList<>();
        l.add(begin);
        Calendar cd = Calendar.getInstance();
        cd.setTime(b);

        while (!b.equals(e)) {
            cd.add(Calendar.DATE, 1);
            b = cd.getTime();
            l.add(df.format(b));
        }
        return l;
    }

    //根据每一天的时间获取每一天的新用户人数
    @Override
    public List getUserNumByDate(String begin, String end) throws ParseException {
        List<String> l = getDateList(begin, end);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<l.size();i++){
            result.add(userMapper.getUserNumByDate(l.get(i)));
        }
        return result;
    }

    @Override
    public User login(String email, String password) {
        return userMapper.getUserInfo(email, password);
    }

    @Override
    public String signUp(String email, String password) {
        User userExist = userMapper.getUserInfoByEmail(email);
        if (userExist != null) {
            return "Account existed";
        }

        String regx = "\\w+@\\w+(\\.[a-zA-Z]+)+";
        if (!email.matches(regx)) {
            return "Incorrect format";
        }

        Integer user_id = userMapper.getLastUserID();
        if (user_id == null) {
            user_id = 0;
        }
        User user = new User();
        user.setUser_id(user_id + 1);
        user.setEmail(email);
        user.setPassword(password);
        user.setUsertype('R');
        user.setCreatetime(new Date());

        userMapper.addUser(user);

        User userCheck = userMapper.getUserInfo(email, password);
        if (userCheck != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @Override
    public void updateEmail(String email, int user_id) {
        User user = userMapper.getUserInfoByID(user_id);
        user.setEmail(email);
        userMapper.updateEmail(user);
    }

    @Override
    public void deleteByUserId(int user_id) {
        userMapper.deleteByUserId(user_id);
    }
}
