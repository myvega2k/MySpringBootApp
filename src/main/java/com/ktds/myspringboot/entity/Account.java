package com.ktds.myspringboot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter @Setter
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    @Builder
    public Account(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
