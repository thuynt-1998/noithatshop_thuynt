package com.doan.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_shop", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 20, message = "The username must be between 3 and 20 characters.")
    @Column(name = "username", nullable = false,length = 20)
    private String username;

    @NotBlank
    @Size(min = 6, max = 60, message = "The password must be between 6 and 60 characters.")
    @Column(name = "password", nullable = false,length = 60)
    @JsonIgnore
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

}
