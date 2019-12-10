/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadestopbanhang.Users;

/**
 *
 * @author HP
 */
public class Users {
    public static String name;
    public static String id;
    private String username;
    private String password;
    private String role;

    public Users(String name, String id, String username, String password, String role) {
        this.name = name;
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public Users(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
