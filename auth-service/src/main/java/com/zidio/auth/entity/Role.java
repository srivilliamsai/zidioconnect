package com.zidio.auth.entity;

import com.zidio.auth.enums.RoleName;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, unique=true, length=50)
    private RoleName name;

    public Role() {}
    public Role(RoleName name) { this.name = name; }

    public Long getId() { return id; }
    public RoleName getName() { return name; }
    public void setId(Long id) { this.id = id; }
    public void setName(RoleName name) { this.name = name; }
}