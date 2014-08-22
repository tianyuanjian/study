/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.audaque.lib.spring.action;

import com.audaque.lib.shiro.SecurityToken;
import com.audaque.lib.shiro.UserModel;
import com.audaque.lib.spring.model.User;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String addUser(User user) {
        UserModel.createUser(user);
        return "redirect:list.xhtml";
    }

    @RequestMapping(value = "/update.xhtml", method = RequestMethod.POST)
    public String updateUser( User user) {
        UserModel.createUser(user);

        return "redirect:list.xhtml";
    }
    
    @RequestMapping(value = "/queryById/{pid}.xhtml", method = RequestMethod.GET)
    public String queryById(@PathVariable("pid") int pid, Model model) {
        model.addAttribute("user", UserModel.queryUser(pid));
        return "/user/update";
    }
    
    @RequestMapping(value = "/removeById/{pid}.xhtml", method = RequestMethod.GET)
    public String removeById(@PathVariable("pid") int pid) {
        UserModel.removeUser(pid);
        return "redirect:list.xhtml";
    }
    
    @RequestMapping(value = "/list.xhtml", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("userList", UserModel.list());
        return "/user/list";
    }
    
    @RequestMapping(value = "/authenticate.xhtml", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(HttpServletRequest request){
        String account = request.getParameter("user.account");
        String password = request.getParameter("user.password");
        
        Object principal = null;
        Collection<User> users = UserModel.list();
        for (User user : users) {
            if (account.equals(user.getFirstName())) {
                principal = user.getUserId();
            }
        }
        
        if (principal == null) {
            return "forward:gotoLogin.xhtml";
        }
        
        SecurityToken token  = new SecurityToken(principal, password);
        try {
            SecurityUtils.getSubject().login(token);
            return "redirect:list.xhtml";
        } catch (AuthenticationException e) {
            return "forward:gotoLogin.xhtml";
        }
    }
    
    @RequestMapping(value = "/gotoLogin.xhtml", method = { RequestMethod.GET, RequestMethod.POST })
    public String gotoLogin() {
        return "/user/authenticate";
    }
}
