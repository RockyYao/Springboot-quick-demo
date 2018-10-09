package com.springboot.springaopandtran.service;

import com.springboot.springaopandtran.dao.UserDao;
import com.springboot.springaopandtran.dao2.UserDaoEntity2;
import com.springboot.springaopandtran.entity.User;
import com.springboot.springaopandtran.entity2.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserService {

    @Autowired
    UserDao userDao1;


    @Autowired
    UserDaoEntity2 userDao2;


   public void save1(){
       User user=new User();
       user.setName("rocky");
       user.setAge(19);
       user.setDate(new Date());
       user.setSex("男");
       userDao1.save(user);
   }

    public void save2(){
        User2 user=new User2();
        user.setName("krie");
        user.setAge(15);
        user.setDate(new Date());
        user.setSex("男");
        userDao2.save(user);
    }


}
