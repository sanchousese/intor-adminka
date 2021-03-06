package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Admin extends Model {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
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

    public static Admin connect(String username, String password) {
        return find("byUsernameAndPassword", username, password).first();
    }
}