/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.data;

import com.hrm.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anushanth
 */
public class UserRoleDao implements UserRoleInterface{
    
    Connection connection = null;
    PreparedStatement pstmt = null;
    
    @Override
    public User login(String username, String password){
        
        User user = new User();
        try {
            connection = DatabaseConnect.getConnection();            
            String loginQuary = "SELECT * FROM user INNER JOIN role ON user.roleId = role.roleId WHERE username = ? AND password = ?";
            pstmt = connection.prepareStatement(loginQuary);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet loginResult = pstmt.executeQuery();
            
            while(loginResult.next()){
                user.setUserId(loginResult.getString(USERID));
                user.setUserName(loginResult.getString(USERNAME));
                user.setRoleId(loginResult.getString(ROLEID));
                user.setRoleName(loginResult.getString(ROLENAME));
                user.setEmail(loginResult.getString(EMAIL));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRoleDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DatabaseConnect.disconnect();
        }
        return user;
    }
}
