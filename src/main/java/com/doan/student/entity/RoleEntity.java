package com.doan.student.entity;

import javax.persistence.*;

@Entity
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
