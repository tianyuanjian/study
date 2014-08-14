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
    private int id;
    private String firstName;
    private String lastName;

    /***********************************************
    |         C O N S T R U C T O R S           |
     ***********************************************/
    /***********************************************
    |  A C C E S S O R S / M O D I F I E R S    |
     ***********************************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
