package org.springproject.srpingweb_to_boot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 6, max = 30, message = "Min username length 6, Max username length 30")
    private String  username;

    @NotNull(message = "You should choose your sex")
    private char sex;

    @Column
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email is invalid")
    private String email;

    public User() {
    }

    public User(String username, char sex, String email)  {
        this.username = username;
        this.sex = sex;
        this.email = email;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                '}';
    }
}
