package com.vuanhnguyenduc.vuanhportfolio.dto;

import com.vuanhnguyenduc.vuanhportfolio.model.Role;
import com.vuanhnguyenduc.vuanhportfolio.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class UserDTO implements Serializable {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int active;
    private transient Set<Role> roles;
    private Date createdAt;
    private String confirmPassword;

    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.active = user.getActive();
        this.roles = user.getRoles();
        this.createdAt = user.getCreatedAt();
        this.confirmPassword = user.getConfirmPassword();
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
