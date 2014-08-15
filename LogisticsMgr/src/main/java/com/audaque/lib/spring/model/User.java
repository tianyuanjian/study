/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.audaque.lib.spring.model;

import java.io.Serializable;

/**
 *
 * @author [*田园间*]
 */
public class User implements Serializable {
    /***********************************************
    |             C O N S T A N T S             |
    ***********************************************/
    private static final long serialVersionUID = -1L;

    /***********************************************
    |    I N S T A N C E   V A R I A B L E S    |
    ***********************************************/
    private int userId;
    private String firstName;
    private String lastName;
    private String sex;
    private int age;

    /***********************************************
    |         C O N S T R U C T O R S           |
     ***********************************************/
    /***********************************************
    |  A C C E S S O R S / M O D I F I E R S    |
     ***********************************************/
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /***********************************************
    |               M E T H O D S               |
    ***********************************************/
}
