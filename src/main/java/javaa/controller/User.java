package javaa.controller;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public static final String GENDER_MALE = "M";
    public static final String GENDER_FEMALE = "F";
    
    private String Name;
    private String SurName;
    private String email;
    private String gender;
    private String password;
    private String country;
    private String courses;
    private List<String> roles;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    @Column(name = "username")
    protected String username;

    @Column(name = "password")
    protected String password;

    public User(String Name, String SurName,String email, String password, String gender,String courses, String country, String... roles) {
        this.Name = Name;
        this.SurName = SurName;
        this.email = email;
        this.country = country;
        this.courses = courses;
        this.password = password;
        this.gender = gender;

        this.roles = new ArrayList<String>();
        if (roles != null) {
            Collections.addAll(this.roles, roles);
        }
        
    }

    public User(String username, String password) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
    }

    public List<String> getRoles() {
    }
}
