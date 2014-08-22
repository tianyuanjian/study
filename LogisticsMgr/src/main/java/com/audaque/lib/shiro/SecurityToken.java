/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.audaque.lib.shiro;

import java.io.Serializable;
import org.apache.shiro.authc.RememberMeAuthenticationToken;

/**
 *
 * @author [*田园间*]
 */
public class SecurityToken implements RememberMeAuthenticationToken, Serializable {

    /***********************************************
    |             C O N S T A N T S             |
    ***********************************************/
    private static final long serialVersionUID = 1L;

    /***********************************************
    |    I N S T A N C E   V A R I A B L E S    |
    ***********************************************/
    private Object principal;
    private Object credencial;
    private boolean rememberMe;

    /***********************************************
    |         C O N S T R U C T O R S           |
    ***********************************************/
    public SecurityToken() {
    }

    public SecurityToken(Object principal, Object credencial) {
        this.principal = principal;
        this.credencial = credencial;
    }

    public SecurityToken(Object principal, Object credencial, boolean rememberMe) {
        this.principal = principal;
        this.credencial = credencial;
        this.rememberMe = rememberMe;
    }

    /***********************************************
    |  A C C E S S O R S / M O D I F I E R S    |
     ***********************************************/
    
    public void setPrincipal(Object principal) {
        this.principal = principal;
    }

    public void setCredencial(Object credencial) {
        this.credencial = credencial;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    @Override
    public boolean isRememberMe() {
        return rememberMe;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public Object getCredentials() {
        return credencial;
    }

    /***********************************************
    |               M E T H O D S               |
     ***********************************************/
    @Override
    public String toString() {
        return "SecurityToken{" + "principal=" + principal + ", credencial=" + credencial + ", rememberMe=" + rememberMe + '}';
    }
}
