package com.springboot.springaopandtran.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@ToString
@Entity
public class User {

    @GeneratedValue
    @Id
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private Date date;

}
