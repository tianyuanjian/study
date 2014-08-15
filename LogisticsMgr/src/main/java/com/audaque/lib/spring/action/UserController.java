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

/**
 *
 * @author [*田园间*]
 */
@Controller
@RequestMapping(UserController.USER_PATH)
public class UserController {

    /**
     * *********************************************
     * | C O N S T A N T S |
     **********************************************
     */
    protected static final String USER_PATH = "/user";

    /**
     * *********************************************
     * | I N S T A N C E V A R I A B L E S |
     **********************************************
     */
    private Map<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    /**
     * *********************************************
     * | C O N S T R U C T O R S |
     **********************************************
     */
    /**
     * *********************************************
     * | A C C E S S O R S / M O D I F I E R S |
     **********************************************
     */
    /**
     * *********************************************
     * | M E T H O D S |
     **********************************************
     */
    
//    @RequestMapping(value="{pathName}.xhtml",method = {RequestMethod.GET})
//    public String gotoView(@PathVariable(value = "pathName") String pathName) {
//		
//        return "/user/" + pathName;
//    }

    @RequestMapping(value = "/create.xhtml", method = RequestMethod.POST)
    public String addUser( User user) {
        users.put(user.getUserId(), user);
        return "redirect:list.xhtml";
    }

    @RequestMapping(value = "/update.xhtml", method = RequestMethod.POST)
    public String updateUser( User user) {
        users.put(user.getUserId(), user);

        return "redirect:list.xhtml";
    }
    
    @RequestMapping(value = "/queryById/{pid}.xhtml", method = RequestMethod.GET)
    public String queryById(@PathVariable("pid") int pid, Model model) {
        model.addAttribute("user", users.get(pid));
        return "/user/update";
    }
    
    @RequestMapping(value = "/list.xhtml", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("userList", users.values());
        return "/user/list";
    }
}
