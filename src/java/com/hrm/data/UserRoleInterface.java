/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.data;

import com.hrm.model.User;

/**
 *
 * @author Anushanth
 */
public interface UserRoleInterface {
 
    final static String USERID = "userId";
    final static String USERNAME = "userName";
    final static String PASSWORD = "password";
    final static String EMAIL = "email";
    final static String ROLEID = "roleId";
    final static String ROLENAME = "roleName";
    
    public User login(String username, String password);
}
