/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevj2me;

/**
 *
 * @author maroo
 */
public class User {
    
    private int id;
    private String username;
    private String password;
    private String email;
    private String roles;
    private int enabled;
     private int bonus;
     private String image;

    public User() {
    }

    public User(int id, String username, String email, String roles, int enabled, int bonus, String image) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.enabled = enabled;
        this.bonus = bonus;
        this.image = image;
    }

    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", email=" + email + ", roles=" + roles + ", enabled=" + enabled + ", bonus=" + bonus + ", image=" + image + '}';
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
     
}
