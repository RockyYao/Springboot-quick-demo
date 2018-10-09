package com.springboot.springaopandtran.dao;

import com.springboot.springaopandtran.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Integer>{
}
