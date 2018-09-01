/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.data;

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
    
    Connection connection;
    PreparedStatement pstmt;
    
    @Override
    public String login(String username, String password){
        
        String role = null;
        try {
            connection = DatabaseConnect.getConnection();            
            String loginQuary = "SELECT * FROM user u INNER JOIN role r ON u.roleId = r.roleId "
                    + "WHERE username = ? AND password = ?";
            pstmt = connection.prepareStatement(loginQuary);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet loginResult = pstmt.executeQuery();
            
            while(loginResult.next()){
                role = loginResult.getString(ROLENAME);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRoleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }
}
