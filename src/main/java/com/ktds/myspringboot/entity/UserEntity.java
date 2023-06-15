package com.ktds.myspringboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "users")
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
@Setter
@DynamicUpdate
@AllArgsConstructor
@Builder
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false, updatable = false)
    //@ColumnDefault(value = "CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();


}
