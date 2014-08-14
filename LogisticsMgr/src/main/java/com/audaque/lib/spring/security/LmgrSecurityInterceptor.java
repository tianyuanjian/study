/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.audaque.lib.spring.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author [*田园间*]
 */
public class LmgrSecurityInterceptor extends HandlerInterceptorAdapter {

    /***********************************************
    |             C O N S T A N T S             |
    ***********************************************/

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
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex); //To change body of generated methods, choose Tools | Templates.
        System.out.println("afterCompletion===================");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView); //To change body of generated methods, choose Tools | Templates.
        System.out.println("postHandle===================");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle===================");
        return super.preHandle(request, response, handler); //To change body of generated methods, choose Tools | Templates.
    }
}
