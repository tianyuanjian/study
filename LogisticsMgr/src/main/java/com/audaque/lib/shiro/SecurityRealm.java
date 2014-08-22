/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.audaque.lib.shiro;

import com.audaque.lib.spring.model.User;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 *
 * @author [*田园间*]
 */
public class SecurityRealm extends AuthorizingRealm {

    /***********************************************
    |             C O N S T A N T S             |
    ***********************************************/

    /***********************************************
    |    I N S T A N C E   V A R I A B L E S    |
    ***********************************************/

    /***********************************************
    |         C O N S T R U C T O R S           |
    ***********************************************/
    public SecurityRealm() {
        super();
        setAuthenticationTokenClass(SecurityToken.class);
    }

    public SecurityRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
        setAuthenticationTokenClass(SecurityToken.class);
    }

    public SecurityRealm(CacheManager cacheManager) {
        super(cacheManager);
        setAuthenticationTokenClass(SecurityToken.class);
    }

    public SecurityRealm(CredentialsMatcher matcher) {
        super(matcher);
        setAuthenticationTokenClass(SecurityToken.class);
    }

    /***********************************************
    |  A C C E S S O R S / M O D I F I E R S    |
    ***********************************************/

    /***********************************************
    |               M E T H O D S               |
    ***********************************************/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        
        int userId = Integer.parseInt(getAvailablePrincipal(principals).toString());
        Set<String> roles = findRolesByUserId(userId);
        
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        info.setStringPermissions(findPermissionsByRoles(roles));
        
        return info;
    }
    
    private Set<String> findRolesByUserId(int userId){
        Set<String> roles = new LinkedHashSet<String>();
        if (userId == 1) {
            roles.add("admin");
        }else if (userId == 2) {
            roles.add("manager");
            roles.add("employee");
        }else if (userId == 3) {
            roles.add("employee");
        }
        
        return roles;
    }
    
    private Set<String> findPermissionsByRoles(Set<String> roles){
        Set<String> permissions = new LinkedHashSet<String>();
        
        for (String role : roles) {
            if (role.equals("admin")) {
                permissions.add("addManager");
                permissions.add("updateManager");
                permissions.add("removeManager");
                permissions.add("queryManagers");
            }else if (role.equals("manager")) {
                permissions.add("addUser");
                permissions.add("updateUser");
                permissions.add("removeUser");
            }else if (role.equals("employee")) {
                permissions.add("queryUsers");
                permissions.add("findSelfInfo");
            }
        }
        
        return permissions;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SecurityToken upToken = (SecurityToken) token;
        
        Collection<User> users = UserModel.list();
        int userId = Integer.parseInt(token.getPrincipal().toString());
        String credencial = token.getCredentials().toString();
        
        for (User user : users) {
            if (userId == user.getUserId()) {
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(upToken.getPrincipal(), user.getLastName(), getName());
                return info;
            }
        }
        
        throw new AuthenticationException("Authentication failed.");
    }
}
