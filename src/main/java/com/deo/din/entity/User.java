package com.deo.din.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.swing.*;
import java.util.Set;
import java.util.UUID;

@Entity()
@Table(name = "usr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String username;
    private String password;
    private boolean active;

    @ElementCollection(targetClass = Role.class,fetch = FetchType.LAZY)
    private Set<Role> roles;
}
