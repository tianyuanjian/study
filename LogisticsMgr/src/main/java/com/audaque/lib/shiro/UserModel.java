/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.audaque.lib.shiro;

import com.audaque.lib.spring.model.User;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author [*田园间*]
 */
public class UserModel {
    /***********************************************
    |             C O N S T A N T S             |
    ***********************************************/
    private static final Map<Integer, User> users = new ConcurrentHashMap<Integer, User>();
    static {
        User admin = new User();
        admin.setUserId(1);
        admin.setFirstName("administrator");
        admin.setLastName("administrator");
        admin.setAge(100);
        admin.setSex("M");
        createUser(admin);
        
        User manager = new User();
        manager.setUserId(2);
        manager.setFirstName("manager");
        manager.setLastName("manager");
        manager.setAge(80);
        manager.setSex("M");
        createUser(manager);
        
        User employee = new User();
        employee.setUserId(3);
        employee.setFirstName("Li");
        employee.setLastName("Lei");
        employee.setAge(50);
        employee.setSex("F");
        createUser(employee);
    }

    /***********************************************
    |    I N S T A N C E   V A R I A B L E S    |
    ***********************************************/

    /***********************************************
    |         C O N S T R U C T O R S           |
    ***********************************************/

    /***********************************************
    |  A C C E S S O R S / M O D I F I E R S    |
    ***********************************************/

    /***********************************************
    |               M E T H O D S               |
    ***********************************************/
    
    public static final void createUser(User user){
        users.put(user.getUserId(), user);
    }
    
    public static final void removeUser(int pid){
        users.remove(pid);
    }
    
    public static final void updateUser(User user){
        users.put(user.getUserId(), user);
    }
    
    public static final User queryUser(int pid){
        return users.get(pid);
    }
    
    public static final Collection<User> list(){
        return users.values();
    }
}
