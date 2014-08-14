/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.audaque.lib.spring.action;

import com.audaque.lib.spring.model.User;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author [*田园间*]
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /***********************************************
    |             C O N S T A N T S             |
    ***********************************************/

    /***********************************************
    |    I N S T A N C E   V A R I A B L E S    |
    ***********************************************/
    private Map<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    /***********************************************
    |         C O N S T R U C T O R S           |
    ***********************************************/

    /***********************************************
    |  A C C E S S O R S / M O D I F I E R S    |
    ***********************************************/

    /***********************************************
    |               M E T H O D S               |
    ***********************************************/
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User queryById(@PathVariable("pid") int pid){
        return users.get(pid);
    }
    
    @RequestMapping(value = "/add.xhtml", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(value = "user") User user){
        return "redirect:/user/user_list";
    }
    
    @RequestMapping(value = "/user_list.xhtml", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("userList", users.values());
        
        return "user_list";
    }
}
